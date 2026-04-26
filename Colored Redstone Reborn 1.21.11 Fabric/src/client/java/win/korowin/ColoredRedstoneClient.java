package win.korowin;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.util.math.MathHelper;
import win.korowin.init.ModBlocks;

/**
 * Client-side entry point for Colored Redstone Reborn on Fabric.
 */
public class ColoredRedstoneClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register color providers for wires
        registerWireColor(ModBlocks.WHITE_REDSTONE_WIRE, 0xF9FFFE);
        registerWireColor(ModBlocks.LIGHT_GRAY_REDSTONE_WIRE, 0x9D9D97);
        registerWireColor(ModBlocks.GRAY_REDSTONE_WIRE, 0x474F52);
        registerWireColor(ModBlocks.BLACK_REDSTONE_WIRE, 0x1D1D21);
        registerWireColor(ModBlocks.BROWN_REDSTONE_WIRE, 0x835432);
        registerWireColor(ModBlocks.ORANGE_REDSTONE_WIRE, 0xF07613);
        registerWireColor(ModBlocks.YELLOW_REDSTONE_WIRE, 0xFED83D);
        registerWireColor(ModBlocks.LIME_REDSTONE_WIRE, 0x80C71F);
        registerWireColor(ModBlocks.GREEN_REDSTONE_WIRE, 0x5E7C16);
        registerWireColor(ModBlocks.CYAN_REDSTONE_WIRE, 0x169C9C);
        registerWireColor(ModBlocks.LIGHT_BLUE_REDSTONE_WIRE, 0x3AB3DA);
        registerWireColor(ModBlocks.BLUE_REDSTONE_WIRE, 0x3C44AA);
        registerWireColor(ModBlocks.PURPLE_REDSTONE_WIRE, 0x8932B8);
        registerWireColor(ModBlocks.MAGENTA_REDSTONE_WIRE, 0xC74EBD);
        registerWireColor(ModBlocks.PINK_REDSTONE_WIRE, 0xF38BAA);

        // Register render layers
        ModBlocks.REDSTONE_WIRES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
    }

    private void registerWireColor(Block block, int baseColor) {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) return 0xFFFFFF; // No color for non-zero tint indexes
            int power = state.get(RedstoneWireBlock.POWER);
            return getRedstoneColor(power, baseColor);
        }, block);
    }

    private int getRedstoneColor(int power, int baseColor) {
        float f = (float) power / 15.0F;
        float r = (float) (baseColor >> 16 & 255) / 255.0F;
        float g = (float) (baseColor >> 8 & 255) / 255.0F;
        float b = (float) (baseColor & 255) / 255.0F;

        float f1 = f * 0.6F + (f > 0.0F ? 0.4F : 0.3F);
        float f2 = MathHelper.clamp(f * f * 0.7F - 0.5F, 0.0F, 1.0F);

        float r1 = MathHelper.clamp(r * f1 + f2, 0.0F, 1.0F);
        float g1 = MathHelper.clamp(g * f1 + f2, 0.0F, 1.0F);
        float b1 = MathHelper.clamp(b * f1 + f2, 0.0F, 1.0F);

        return ((int)(r1 * 255) << 16) | ((int)(g1 * 255) << 8) | (int)(b1 * 255);
    }
}
