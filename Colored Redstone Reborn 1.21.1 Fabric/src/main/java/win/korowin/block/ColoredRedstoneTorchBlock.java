package win.korowin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone torch.
 * Allows changing particle colors when torch is active.
 */
public class ColoredRedstoneTorchBlock extends RedstoneTorchBlock {
    private final Vector3f particleColor;

    public ColoredRedstoneTorchBlock(Settings settings, int color) {
        super(settings);
        this.particleColor = new Vector3f(
                (float) (color >> 16 & 255) / 255.0F,
                (float) (color >> 8 & 255) / 255.0F,
                (float) (color & 255) / 255.0F
        );
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            double d0 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            world.addParticle(new DustParticleEffect(this.particleColor, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
