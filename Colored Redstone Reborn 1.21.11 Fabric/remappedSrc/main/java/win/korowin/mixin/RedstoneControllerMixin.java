package win.korowin.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.RedstoneWireEvaluator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Mixin to change the behavior of the redstone wire evaluator (RedstoneController).
 * Restricts wire power lookup to the same exact wire block.
 */
@Mixin(RedstoneWireEvaluator.class)
public abstract class RedstoneControllerMixin {
    @Shadow
    @Final
    protected RedStoneWireBlock wireBlock;

    /**
     * Restricts wire power lookup to the same exact wire block in the evaluator.
     * @author Korowin
     * @reason Prevents different colored wires from powering each other.
     */
    @Overwrite
    public int getWireSignal(BlockPos pos, BlockState state) {
        if (state.getBlock() == this.wireBlock) {
            return state.getValue(RedStoneWireBlock.POWER);
        }
        return 0;
    }
}
