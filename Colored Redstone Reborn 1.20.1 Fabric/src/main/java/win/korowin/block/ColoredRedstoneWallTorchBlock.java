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
 * A colored wall redstone torch that spawns colored particles while lit.
 */
public class ColoredRedstoneWallTorchBlock extends WallRedstoneTorchBlock {
    private final Vector3f particleColor;

    /**
     * Creates a colored wall redstone torch.
     *
     * @param settings block settings
     * @param color    particle color in 0xRRGGBB format
     */
    public ColoredRedstoneWallTorchBlock(Settings settings, int color) {
        super(settings);
        this.particleColor = new Vector3f(
                (float) (color >> 16 & 255) / 255.0F,
                (float) (color >> 8 & 255) / 255.0F,
                (float) (color & 255) / 255.0F
        );
    }

    /**
     * Spawns colored particles when the torch is lit.
     */
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            Direction direction = state.get(FACING).getOpposite();
            double d1 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getOffsetX();
            double d2 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D + 0.22D;
            double d3 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D + 0.27D * (double) direction.getOffsetZ();
            world.addParticle(new DustParticleEffect(this.particleColor, 1.0F), d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }
}
