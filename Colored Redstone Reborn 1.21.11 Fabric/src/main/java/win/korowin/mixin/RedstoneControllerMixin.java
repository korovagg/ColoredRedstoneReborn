package win.korowin.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RedstoneController;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Mixin to change the behavior of the redstone wire evaluator (RedstoneController).
 * Allows different redstone colors to share signals.
 */
@Mixin(RedstoneController.class)
public abstract class RedstoneControllerMixin {

    /**
     * Allows different redstone wire blocks to share signal in the evaluator.
     * @author Korowin
     * @reason Allows colored wires to consider each other's signal.
     */
    @Overwrite
    public int getWirePowerAt(BlockPos pos, BlockState state) {
        if (state.getBlock() instanceof RedstoneWireBlock) {
            return state.get(RedstoneWireBlock.POWER);
        }
        return 0;
    }
}
