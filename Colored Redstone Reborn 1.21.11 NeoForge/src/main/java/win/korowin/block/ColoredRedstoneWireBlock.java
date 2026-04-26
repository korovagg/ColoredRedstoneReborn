package win.korowin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone dust (wire).
 * Allows changing particle colors when redstone is active.
 */
public class ColoredRedstoneWireBlock extends RedStoneWireBlock {
    private final int baseColor;
    private final Vector3f particleColor;

    /**
     * Constructor for colored wire.
     * @param properties Block properties
     * @param baseColor Base color in HEX format
     */
    public ColoredRedstoneWireBlock(Properties properties, int baseColor) {
        super(properties);
        this.baseColor = baseColor;
        this.particleColor = new Vector3f(
                (float) (baseColor >> 16 & 255) / 255.0F,
                (float) (baseColor >> 8 & 255) / 255.0F,
                (float) (baseColor & 255) / 255.0F
        );
    }

    /**
     * Animate tick method, used for spawning colored particles.
     */
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        int i = state.getValue(POWER);
        if (i != 0) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                RedstoneSide redstoneside = state.getValue(PROPERTY_BY_DIRECTION.get(direction));
                switch (redstoneside) {
                    case UP: case SIDE:
                    
                    this.spawnParticles(level, random, pos, this.particleColor, Direction.DOWN, direction, 0.0F, 0.5F);
                        if (redstoneside == RedstoneSide.UP) {
                            this.spawnParticles(level, random, pos, this.particleColor, direction, Direction.UP, -0.5F, 0.5F);
                        }
                        break;
                    case NONE:
                    default:
                        this.spawnParticles(level, random, pos, this.particleColor, Direction.DOWN, direction, 0.0F, 0.3F);
                        break;
                }
            }
        }
    }

    /**
     * Helper method to spawn particles.
     */
    private void spawnParticles(Level level, RandomSource random, BlockPos pos, Vector3f color, Direction direction, Direction direction1, float f, float f1) {
        float f2 = f1 - f;
        if (!(random.nextFloat() > 0.2F * f2)) {
            float f3 = 0.4375F;
            float f4 = f + f2 * random.nextFloat();
            double d0 = 0.5D + (double) (0.4375F * (float) direction.getStepX()) + (double) (f4 * (float) direction1.getStepX());
            double d1 = 0.5D + (double) (0.4375F * (float) direction.getStepY()) + (double) (f4 * (float) direction1.getStepY());
            double d2 = 0.5D + (double) (0.4375F * (float) direction.getStepZ()) + (double) (f4 * (float) direction1.getStepZ());
            level.addParticle(new DustParticleOptions(baseColor, 1.0F), (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
        }
    }
}

