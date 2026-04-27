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
 * Allows different redstone colors to connect to each other and share signals.
 */
@Mixin(RedstoneWireBlock.class)
public abstract class RedstoneWireBlockMixin {

    /**
     * Allows different redstone wire blocks to connect to each other.
     * @author Korowin
     * @reason Allows colored wires to connect into a single circuit.
     */
    @Overwrite
    public static boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof RedstoneWireBlock || state.isOf(Blocks.REPEATER) || state.isOf(Blocks.OBSERVER) || state.emitsRedstonePower();
    }

    /**
     * Allows different redstone wire blocks to connect to each other.
     * @author Korowin
     * @reason Allows colored wires to connect into a single circuit.
     */
    @Overwrite
    public static boolean connectsTo(BlockState state, @Nullable Direction direction) {
        if (state.getBlock() instanceof RedstoneWireBlock) {
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
        BlockPos blockpos = pos.offset(direction);
        BlockState blockstate = world.getBlockState(blockpos);
        if (canClimb) {
            boolean flag = this.canRunOnTop(world, blockpos, blockstate);
            if (flag && connectsTo(world.getBlockState(blockpos.up()))) {
                cir.setReturnValue(WireConnection.UP);
                return;
            }
        }

        if (connectsTo(blockstate, direction)) {
            cir.setReturnValue(WireConnection.SIDE);
        } else if (blockstate.isSolidBlock(world, blockpos)) {
            cir.setReturnValue(WireConnection.NONE);
        } else {
            cir.setReturnValue(connectsTo(world.getBlockState(blockpos.down()), direction) ? WireConnection.SIDE : WireConnection.NONE);
        }
    }

    @Shadow
    protected abstract boolean canRunOnTop(BlockView world, BlockPos pos, BlockState state);
}
