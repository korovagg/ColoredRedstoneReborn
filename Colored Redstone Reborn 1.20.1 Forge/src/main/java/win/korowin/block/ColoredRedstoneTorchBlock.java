package win.korowin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3f;

public class ColoredRedstoneTorchBlock extends RedstoneTorchBlock {
    private final Vector3f particleColor;

    public ColoredRedstoneTorchBlock(Properties properties, int color) {
        super(properties);
        this.particleColor = new Vector3f(((color >> 16) & 0xFF) / 255.0f, ((color >> 8) & 0xFF) / 255.0f, (color & 0xFF) / 255.0f);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            double d0 = (double) pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double) pos.getY() + 0.7D + (random.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double) pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.2D;
            level.addParticle(new DustParticleOptions(this.particleColor, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
