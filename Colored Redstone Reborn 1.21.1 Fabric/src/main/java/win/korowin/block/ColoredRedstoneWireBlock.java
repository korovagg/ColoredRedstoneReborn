package win.korowin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone dust (wire).
 * Allows changing particle colors when redstone is active.
 */
public class ColoredRedstoneWireBlock extends RedstoneWireBlock {
    private final int baseColor;
    private final Vector3f particleColor;

    public ColoredRedstoneWireBlock(Settings settings, int baseColor) {
        super(settings);
        this.baseColor = baseColor;
        this.particleColor = new Vector3f(
                (float) (baseColor >> 16 & 255) / 255.0F,
                (float) (baseColor >> 8 & 255) / 255.0F,
                (float) (baseColor & 255) / 255.0F
        );
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int i = state.get(POWER);
        if (i != 0) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                switch (state.get(DIRECTION_TO_WIRE_CONNECTION_PROPERTY.get(direction))) {
                    case UP:
                        this.spawnParticles(world, random, pos, this.particleColor, Direction.DOWN, direction, 0.0F, 0.5F);
                        this.spawnParticles(world, random, pos, this.particleColor, direction, Direction.UP, -0.5F, 0.5F);
                        break;
                    case SIDE:
                        this.spawnParticles(world, random, pos, this.particleColor, Direction.DOWN, direction, 0.0F, 0.5F);
                        break;
                    case NONE:
                    default:
                        this.spawnParticles(world, random, pos, this.particleColor, Direction.DOWN, direction, 0.0F, 0.3F);
                        break;
                }
            }
        }
    }

    private void spawnParticles(World world, Random random, BlockPos pos, Vector3f color, Direction direction, Direction direction1, float f, float f1) {
        float f2 = f1 - f;
        if (!(random.nextFloat() > 0.2F * f2)) {
            float f4 = f + f2 * random.nextFloat();
            double d0 = 0.5D + (double) (0.4375F * (float) direction.getOffsetX()) + (double) (f4 * (float) direction1.getOffsetX());
            double d1 = 0.5D + (double) (0.4375F * (float) direction.getOffsetY()) + (double) (f4 * (float) direction1.getOffsetY());
            double d2 = 0.5D + (double) (0.4375F * (float) direction.getOffsetZ()) + (double) (f4 * (float) direction1.getOffsetZ());
            world.addParticle(new DustParticleEffect(color, 1.0F), (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
