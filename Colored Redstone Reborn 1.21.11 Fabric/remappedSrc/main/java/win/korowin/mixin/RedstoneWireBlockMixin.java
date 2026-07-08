package win.korowin.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin to change the behavior of vanilla redstone wire.
 * Restricts colored wire connectivity to wires of the same exact color.
 */
@Mixin(RedStoneWireBlock.class)
public abstract class RedstoneWireBlockMixin {

    /**
     * Preserves vanilla-style static connection checks for vanilla redstone wire only.
     * @author Korowin
     * @reason Same-color colored wire checks require the current block instance.
     */
    @Overwrite
    public static boolean shouldConnectTo(BlockState state) {
        return state.is(Blocks.REDSTONE_WIRE) || state.is(Blocks.REPEATER) || state.is(Blocks.OBSERVER) || state.isSignalSource();
    }

    /**
     * Preserves vanilla-style static connection checks for vanilla redstone wire only.
     * @author Korowin
     * @reason Same-color colored wire checks require the current block instance.
     */
    @Overwrite
    public static boolean shouldConnectTo(BlockState state, @Nullable Direction direction) {
        if (state.is(Blocks.REDSTONE_WIRE)) {
            return true;
        } else if (state.is(Blocks.REPEATER)) {
            Direction facing = state.getValue(RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.is(Blocks.OBSERVER)) {
            return direction == state.getValue(ObserverBlock.FACING);
        } else {
            return state.isSignalSource() && direction != null;
        }
    }

    @Inject(method = "getConnectingSide(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Z)Lnet/minecraft/world/level/block/state/properties/RedstoneSide;", at = @At("HEAD"), cancellable = true)
    private void onGetRenderConnectionType(BlockGetter world, BlockPos pos, Direction direction, boolean canClimb, CallbackInfoReturnable<RedstoneSide> cir) {
        RedStoneWireBlock currentWire = (RedStoneWireBlock) (Object) this;
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = world.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canSurviveOn(world, blockpos, blockstate);
            if (flag && connectsToSameColor(world.getBlockState(blockpos.above()), currentWire)) {
                cir.setReturnValue(RedstoneSide.UP);
                return;
            }
        }

        if (connectsToSameColor(blockstate, direction, currentWire)) {
            cir.setReturnValue(RedstoneSide.SIDE);
        } else if (blockstate.isRedstoneConductor(world, blockpos)) {
            cir.setReturnValue(RedstoneSide.NONE);
        } else {
            cir.setReturnValue(connectsToSameColor(world.getBlockState(blockpos.below()), direction, currentWire) ? RedstoneSide.SIDE : RedstoneSide.NONE);
        }
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean connectsToSameColor(BlockState state, RedStoneWireBlock currentWire) {
        return connectsToSameColor(state, null, currentWire);
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean connectsToSameColor(BlockState state, @Nullable Direction direction, RedStoneWireBlock currentWire) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            return state.getBlock() == currentWire;
        } else if (state.is(Blocks.REPEATER)) {
            Direction facing = state.getValue(RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.is(Blocks.OBSERVER)) {
            return direction == state.getValue(ObserverBlock.FACING);
        } else {
            return state.isSignalSource() && direction != null;
        }
    }

    @Shadow
    protected abstract boolean canSurviveOn(BlockGetter world, BlockPos pos, BlockState state);
}
