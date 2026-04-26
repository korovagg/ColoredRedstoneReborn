package win.korowin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ComparatorMode;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone comparator.
 */
public class ColoredComparatorBlock extends ComparatorBlock {
    private final Vector3f particleColor;

    public ColoredComparatorBlock(Properties properties, int baseColor) {
        super(properties);
        this.particleColor = new Vector3f(
                (float) (baseColor >> 16 & 255) / 255.0F,
                (float) (baseColor >> 8 & 255) / 255.0F,
                (float) (baseColor & 255) / 255.0F
        );
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (this.shouldActivate(level, pos, state)) {
            Direction direction = state.getValue(FACING);
            double d0 = (double)pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double)pos.getY() + 0.4D + (random.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double)pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            float f = -5.0F;
            if (random.nextBoolean()) {
                f = (float)(state.getValue(MODE) == ComparatorMode.SUBTRACT ? 3 : 4);
            }

            f /= 16.0F;
            double d3 = (double)(f * (float)direction.getStepX());
            double d4 = (double)(f * (float)direction.getStepZ());
            level.addParticle(new DustParticleOptions(this.particleColor, 1.0F), d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
    }
    
    private boolean shouldActivate(Level level, BlockPos pos, BlockState state) {
        return this.getInputSignal(level, pos, state) > 0;
    }
}
