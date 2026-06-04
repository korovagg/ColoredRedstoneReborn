package win.korowin.block;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;

/**
 * Custom class for colored redstone torch.
 * Allows changing particle colors when torch is active.
 */
public class ColoredRedstoneTorchBlock extends RedstoneTorchBlock {
    private final Vector3f particleColor;

    public ColoredRedstoneTorchBlock(Properties properties, int color) {
        super(properties);
        this.particleColor = new Vector3f(
                (float) (color >> 16 & 255) / 255.0F,
                (float) (color >> 8 & 255) / 255.0F,
                (float) (color & 255) / 255.0F
        );
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (state.getValue(LIT)) {
            double d0 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            level.addParticle(new DustParticleOptions(this.particleColor, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
