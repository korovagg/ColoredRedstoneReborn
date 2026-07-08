package win.korowin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3f;

/**
 * Custom class for colored redstone dust (wire).
 * Allows changing particle colors when redstone is active.
 */
public class ColoredRedstoneWireBlock extends RedStoneWireBlock {
    private final int baseColor;
    private final Vector3f particleColor;

    public ColoredRedstoneWireBlock(Properties settings, int baseColor) {
        super(settings);
        this.baseColor = baseColor;
        this.particleColor = new Vector3f(
                (float) (baseColor >> 16 & 255) / 255.0F,
                (float) (baseColor >> 8 & 255) / 255.0F,
                (float) (baseColor & 255) / 255.0F
        );
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        int i = state.getValue(POWER);
        if (i != 0) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                net.minecraft.world.level.block.state.properties.RedstoneSide connection = state.getValue(PROPERTY_BY_DIRECTION.get(direction));
                if (connection == net.minecraft.world.level.block.state.properties.RedstoneSide.UP) {
                    this.spawnParticles(world, random, pos, Direction.DOWN, direction, 0.0F, 0.5F);
                    this.spawnParticles(world, random, pos, direction, Direction.UP, -0.5F, 0.5F);
                } else if (connection == net.minecraft.world.level.block.state.properties.RedstoneSide.SIDE) {
                    this.spawnParticles(world, random, pos, Direction.DOWN, direction, 0.0F, 0.5F);
                } else {
                    this.spawnParticles(world, random, pos, Direction.DOWN, direction, 0.0F, 0.3F);
                }
            }
        }
    }

    private void spawnParticles(Level world, RandomSource random, BlockPos pos, Direction direction, Direction direction1, float f, float f1) {
        float f2 = f1 - f;
        if (!(random.nextFloat() > 0.2F * f2)) {
            float f4 = f + f2 * random.nextFloat();
            double d0 = 0.5D + (double) (0.4375F * (float) direction.getStepX()) + (double) (f4 * (float) direction1.getStepX());
            double d1 = 0.5D + (double) (0.4375F * (float) direction.getStepY()) + (double) (f4 * (float) direction1.getStepY());
            double d2 = 0.5D + (double) (0.4375F * (float) direction.getStepZ()) + (double) (f4 * (float) direction1.getStepZ());
            
            ParticleOptions particleEffect = new DustParticleOptions(this.baseColor, 1.0F);
            world.addParticle(particleEffect, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
