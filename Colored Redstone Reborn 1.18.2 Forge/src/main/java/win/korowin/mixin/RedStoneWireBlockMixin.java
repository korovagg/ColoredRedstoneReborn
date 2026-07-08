package win.korowin.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.core.BlockPos;

/**
 * Mixin to change the behavior of vanilla redstone wire.
 * Restricts colored wire connectivity to wires of the same exact color.
 */
@Mixin(RedStoneWireBlock.class)
public abstract class RedStoneWireBlockMixin {

    /**
     * Restricts wire signal sharing to the same exact wire block.
     * @author Korowin
     * @reason Prevents different colored wires from powering each other.
     */
    @Inject(method = "getWireSignal", at = @At("HEAD"), cancellable = true)
    private void onGetWireSignal(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (state.getBlock() == (Object) this) {
            cir.setReturnValue(state.getValue(RedStoneWireBlock.POWER));
        }
    }

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
    public static boolean shouldConnectTo(BlockState state, @Nullable Direction p_direction) {
        if (state.is(Blocks.REDSTONE_WIRE)) {
            return true;
        } else if (state.is(Blocks.REPEATER)) {
            Direction direction = state.getValue(net.minecraft.world.level.block.RepeaterBlock.FACING);
            return direction == p_direction || direction.getOpposite() == p_direction;
        } else if (state.is(Blocks.OBSERVER)) {
            return p_direction == state.getValue(net.minecraft.world.level.block.ObserverBlock.FACING);
        } else {
            return state.isSignalSource() && p_direction != null;
        }
    }

    @Inject(method = "getConnectingSide(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Z)Lnet/minecraft/world/level/block/state/properties/RedstoneSide;", at = @At("HEAD"), cancellable = true)
    private void onGetConnectingSide(BlockGetter level, BlockPos pos, Direction direction, boolean canClimb, CallbackInfoReturnable<RedstoneSide> cir) {
        RedStoneWireBlock currentWire = (RedStoneWireBlock) (Object) this;
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canSurviveOn(level, blockpos, blockstate);
            if (flag && shouldConnectToSameColor(level.getBlockState(blockpos.above()), currentWire)) {
                cir.setReturnValue(RedstoneSide.UP);
                return;
            }
        }

        if (shouldConnectToSameColor(blockstate, direction, currentWire)) {
            cir.setReturnValue(RedstoneSide.SIDE);
        } else if (blockstate.isRedstoneConductor(level, blockpos)) {
            cir.setReturnValue(RedstoneSide.NONE);
        } else {
            cir.setReturnValue(shouldConnectToSameColor(level.getBlockState(blockpos.below()), direction, currentWire) ? RedstoneSide.SIDE : RedstoneSide.NONE);
        }
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean shouldConnectToSameColor(BlockState state, RedStoneWireBlock currentWire) {
        return shouldConnectToSameColor(state, null, currentWire);
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean shouldConnectToSameColor(BlockState state, @Nullable Direction direction, RedStoneWireBlock currentWire) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            return state.getBlock() == currentWire;
        } else if (state.is(Blocks.REPEATER)) {
            Direction facing = state.getValue(net.minecraft.world.level.block.RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.is(Blocks.OBSERVER)) {
            return direction == state.getValue(net.minecraft.world.level.block.ObserverBlock.FACING);
        } else {
            return state.isSignalSource() && direction != null;
        }
    }

    @Shadow
    private boolean canSurviveOn(BlockGetter level, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }
}
