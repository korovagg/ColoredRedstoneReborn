package win.korowin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallRedstoneTorchBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone wall torch.
 * Allows changing particle colors when torch is active.
 */
public class ColoredRedstoneWallTorchBlock extends WallRedstoneTorchBlock {
    private final int particleColor;

    public ColoredRedstoneWallTorchBlock(Settings settings, int color) {
        super(settings);
        this.particleColor = color;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            Direction direction = state.get(FACING).getOpposite();
            double d1 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getOffsetX();
            double d2 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D + 0.22D;
            double d3 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getOffsetZ();
            world.addParticleClient(new DustParticleEffect(this.particleColor, 1.0F), d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }
}
