package win.korowin.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RedstoneController;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Mixin to change the behavior of the redstone wire evaluator (RedstoneController).
 * Restricts wire power lookup to the same exact wire block.
 */
@Mixin(RedstoneController.class)
public abstract class RedstoneControllerMixin {
    @Shadow
    @Final
    protected RedstoneWireBlock wire;

    /**
     * Restricts wire power lookup to the same exact wire block in the evaluator.
     * @author Korowin
     * @reason Prevents different colored wires from powering each other.
     */
    @Overwrite
    public int getWirePowerAt(BlockPos pos, BlockState state) {
        if (state.getBlock() == this.wire) {
            return state.get(RedstoneWireBlock.POWER);
        }
        return 0;
    }
}
