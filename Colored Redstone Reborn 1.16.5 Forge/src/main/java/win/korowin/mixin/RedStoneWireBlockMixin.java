package win.korowin.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.ObserverBlock;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

/**
 * Mixin to change the behavior of vanilla redstone wire.
 * Allows different redstone colors to connect to each other and share signals in 1.16.5.
 */
@Mixin(RedstoneWireBlock.class)
public abstract class RedStoneWireBlockMixin {

    /**
     * Allows different redstone wire blocks to share signal.
     * @author Korowin
     * @reason Allows colored wires to consider each other's signal.
     */
    @Inject(method = "getWireSignal(Lnet/minecraft/block/BlockState;)I", at = @At("HEAD"), cancellable = true)
    private void onGetWireSignal(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (state.getBlock() instanceof RedstoneWireBlock) {
            cir.setReturnValue(state.getValue(RedstoneWireBlock.POWER));
        }
    }

    @Inject(method = "getConnectingSide(Lnet/minecraft/world/IBlockReader;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Direction;Z)Lnet/minecraft/state/properties/RedstoneSide;", at = @At("HEAD"), cancellable = true)
    private void onGetConnectingSide(IBlockReader world, BlockPos pos, Direction direction, boolean canClimb, CallbackInfoReturnable<RedstoneSide> cir) {
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = world.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canSurviveOn(world, blockpos, blockstate);
            if (flag && myShouldConnectTo(world.getBlockState(blockpos.above()))) {
                cir.setReturnValue(RedstoneSide.UP);
                return;
            }
        }

        if (myShouldConnectTo(blockstate, direction)) {
            cir.setReturnValue(RedstoneSide.SIDE);
        } else if (blockstate.isRedstoneConductor(world, blockpos)) {
            cir.setReturnValue(RedstoneSide.NONE);
        } else {
            cir.setReturnValue(myShouldConnectTo(world.getBlockState(blockpos.below()), direction) ? RedstoneSide.SIDE : RedstoneSide.NONE);
        }
    }

    /**
     * Replacement for vanilla shouldConnectTo that also handles colored redstone.
     */
    private static boolean myShouldConnectTo(BlockState state) {
        return myShouldConnectTo(state, null);
    }

    /**
     * Replacement for vanilla shouldConnectTo that also handles colored redstone.
     */
    private static boolean myShouldConnectTo(BlockState state, @Nullable Direction direction) {
        if (state.getBlock() instanceof RedstoneWireBlock) {
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

    @Shadow
    private boolean canSurviveOn(IBlockReader world, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }
}
