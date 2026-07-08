package win.korowin.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ObserverBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
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
@Mixin(RedstoneWireBlock.class)
public abstract class RedstoneWireBlockMixin {

    /**
     * Preserves vanilla-style static connection checks for vanilla redstone wire only.
     * @author Korowin
     * @reason Same-color colored wire checks require the current block instance.
     */
    @Overwrite
    public static boolean connectsTo(BlockState state) {
        return state.isOf(Blocks.REDSTONE_WIRE) || state.isOf(Blocks.REPEATER) || state.isOf(Blocks.OBSERVER) || state.emitsRedstonePower();
    }

    /**
     * Preserves vanilla-style static connection checks for vanilla redstone wire only.
     * @author Korowin
     * @reason Same-color colored wire checks require the current block instance.
     */
    @Overwrite
    public static boolean connectsTo(BlockState state, @Nullable Direction direction) {
        if (state.isOf(Blocks.REDSTONE_WIRE)) {
            return true;
        } else if (state.isOf(Blocks.REPEATER)) {
            Direction facing = state.get(RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.isOf(Blocks.OBSERVER)) {
            return direction == state.get(ObserverBlock.FACING);
        } else {
            return state.emitsRedstonePower() && direction != null;
        }
    }

    @Inject(method = "getRenderConnectionType(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;Z)Lnet/minecraft/block/enums/WireConnection;", at = @At("HEAD"), cancellable = true)
    private void onGetRenderConnectionType(BlockView world, BlockPos pos, Direction direction, boolean canClimb, CallbackInfoReturnable<WireConnection> cir) {
        RedstoneWireBlock currentWire = (RedstoneWireBlock) (Object) this;
        BlockPos blockpos = pos.offset(direction);
        BlockState blockstate = world.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canRunOnTop(world, blockpos, blockstate);
            if (flag && connectsToSameColor(world.getBlockState(blockpos.up()), currentWire)) {
                cir.setReturnValue(WireConnection.UP);
                return;
            }
        }

        if (connectsToSameColor(blockstate, direction, currentWire)) {
            cir.setReturnValue(WireConnection.SIDE);
        } else if (blockstate.isSolidBlock(world, blockpos)) {
            cir.setReturnValue(WireConnection.NONE);
        } else {
            cir.setReturnValue(connectsToSameColor(world.getBlockState(blockpos.down()), direction, currentWire) ? WireConnection.SIDE : WireConnection.NONE);
        }
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean connectsToSameColor(BlockState state, RedstoneWireBlock currentWire) {
        return connectsToSameColor(state, null, currentWire);
    }

    /**
     * Checks if the adjacent block can connect to the current wire color.
     */
    private static boolean connectsToSameColor(BlockState state, @Nullable Direction direction, RedstoneWireBlock currentWire) {
        if (state.getBlock() instanceof RedstoneWireBlock) {
            return state.getBlock() == currentWire;
        } else if (state.isOf(Blocks.REPEATER)) {
            Direction facing = state.get(RepeaterBlock.FACING);
            return facing == direction || facing.getOpposite() == direction;
        } else if (state.isOf(Blocks.OBSERVER)) {
            return direction == state.get(ObserverBlock.FACING);
        } else {
            return state.emitsRedstonePower() && direction != null;
        }
    }

    @Shadow
    protected abstract boolean canRunOnTop(BlockView world, BlockPos pos, BlockState state);
}
