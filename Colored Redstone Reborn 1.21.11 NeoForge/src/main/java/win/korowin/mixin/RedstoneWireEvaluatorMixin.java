package win.korowin.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.RedstoneWireEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Mixin to change the behavior of the redstone wire evaluator.
 * Allows different redstone colors to share signals.
 */
@Mixin(RedstoneWireEvaluator.class)
public abstract class RedstoneWireEvaluatorMixin {

    /**
     * Allows different redstone wire blocks to share signal in the evaluator.
     * @author Korowin
     * @reason Allows colored wires to consider each other's signal.
     */
    @Overwrite
    protected int getWireSignal(BlockPos pos, BlockState state) {
        if (state.getBlock() instanceof RedStoneWireBlock) {
            return state.getValue(RedStoneWireBlock.POWER);
        }
        return 0;
    }
}
