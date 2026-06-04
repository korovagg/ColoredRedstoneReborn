package win.korowin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWallTorchBlock;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

/**
 * Custom class for colored redstone wall torch in 1.16.5.
 * Allows changing particle colors when torch is active.
 */
public class ColoredRedstoneWallTorchBlock extends RedstoneWallTorchBlock {
    private final Vector3f particleColor;

    public ColoredRedstoneWallTorchBlock(Properties properties, int color) {
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
            Direction direction = state.getValue(FACING).getOpposite();
            double d1 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getStepX();
            double d2 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D + 0.22D;
            double d3 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getStepZ();
            world.addParticle(new RedstoneParticleData(this.particleColor.x(), this.particleColor.y(), this.particleColor.z(), 1.0F), d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }
}
