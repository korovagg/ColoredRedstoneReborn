package win.korowin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

/**
 * Custom class for colored redstone torch in 1.16.5.
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
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.getValue(LIT)) {
            double d0 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            world.addParticle(new RedstoneParticleData(this.particleColor.x(), this.particleColor.y(), this.particleColor.z(), 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
