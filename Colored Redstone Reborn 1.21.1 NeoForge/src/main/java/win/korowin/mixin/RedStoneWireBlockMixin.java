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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.core.BlockPos;

/**
 * Mixin to change the behavior of vanilla redstone wire.
 * Allows different redstone colors to connect to each other and share signals.
 */
@Mixin(RedStoneWireBlock.class)
public abstract class RedStoneWireBlockMixin {

    /**
     * Allows different redstone wire blocks to share signal.
     * @author Korowin
     * @reason Allows colored wires to consider each other's signal.
     */
    @Inject(method = "getWireSignal", at = @At("HEAD"), cancellable = true)
    private void onGetWireSignal(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            cir.setReturnValue(state.getValue(RedStoneWireBlock.POWER));
        }
    }

    /**
     * Allows different redstone wire blocks to connect to each other.
     * @author Korowin
     * @reason Allows colored wires to connect into a single circuit.
     */
    @Overwrite
    protected static boolean shouldConnectTo(BlockState state) {
        return state.getBlock() instanceof RedStoneWireBlock || state.is(Blocks.REPEATER) || state.is(Blocks.OBSERVER) || state.isSignalSource();
    }

    /**
     * Allows different redstone wire blocks to connect to each other.
     * @author Korowin
     * @reason Allows colored wires to connect into a single circuit.
     */
    @Overwrite
    protected static boolean shouldConnectTo(BlockState state, @Nullable Direction p_direction) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
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
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canSurviveOn(level, blockpos, blockstate);
            if (flag && shouldConnectTo(level.getBlockState(blockpos.above()))) {
                cir.setReturnValue(RedstoneSide.UP);
                return;
            }
        }

        if (shouldConnectTo(blockstate, direction)) {
            cir.setReturnValue(RedstoneSide.SIDE);
        } else if (blockstate.isRedstoneConductor(level, blockpos)) {
            cir.setReturnValue(RedstoneSide.NONE);
        } else {
            cir.setReturnValue(shouldConnectTo(level.getBlockState(blockpos.below()), direction) ? RedstoneSide.SIDE : RedstoneSide.NONE);
        }
    }

    @Shadow
    private boolean canSurviveOn(BlockGetter level, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }
}
