package win.korowin.init;

import net.minecraft.util.Mth;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for handling block and item colors.
 * Used for dynamic tinting of redstone wires based on power level.
 */
public class ModColorHandlers {

    private static final Map<String, Integer> COLOR_MAP = new HashMap<>();

    static {
        // Color map for each redstone type
        COLOR_MAP.put("white", 0xF9FFFE);
        COLOR_MAP.put("light_gray", 0x9D9D97);
        COLOR_MAP.put("gray", 0x474F52);
        COLOR_MAP.put("black", 0x1D1D21);
        COLOR_MAP.put("brown", 0x835432);
        COLOR_MAP.put("orange", 0xF07613);
        COLOR_MAP.put("yellow", 0xFED83D);
        COLOR_MAP.put("lime", 0x80C71F);
        COLOR_MAP.put("green", 0x5E7C16);
        COLOR_MAP.put("cyan", 0x169C9C);
        COLOR_MAP.put("light_blue", 0x3AB3DA);
        COLOR_MAP.put("blue", 0x3C44AA);
        COLOR_MAP.put("purple", 0x8932B8);
        COLOR_MAP.put("magenta", 0xC74EBD);
        COLOR_MAP.put("pink", 0xF38BAA);
    }

    /**
     * Register color handlers for blocks.
     * @param event The block color registration event
     */
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        // Register color for each wire
        registerWireColor(event, ModBlocks.WHITE_REDSTONE_WIRE.get(), COLOR_MAP.get("white"));
        registerWireColor(event, ModBlocks.LIGHT_GRAY_REDSTONE_WIRE.get(), COLOR_MAP.get("light_gray"));
        registerWireColor(event, ModBlocks.GRAY_REDSTONE_WIRE.get(), COLOR_MAP.get("gray"));
        registerWireColor(event, ModBlocks.BLACK_REDSTONE_WIRE.get(), COLOR_MAP.get("black"));
        registerWireColor(event, ModBlocks.BROWN_REDSTONE_WIRE.get(), COLOR_MAP.get("brown"));
        registerWireColor(event, ModBlocks.ORANGE_REDSTONE_WIRE.get(), COLOR_MAP.get("orange"));
        registerWireColor(event, ModBlocks.YELLOW_REDSTONE_WIRE.get(), COLOR_MAP.get("yellow"));
        registerWireColor(event, ModBlocks.LIME_REDSTONE_WIRE.get(), COLOR_MAP.get("lime"));
        registerWireColor(event, ModBlocks.GREEN_REDSTONE_WIRE.get(), COLOR_MAP.get("green"));
        registerWireColor(event, ModBlocks.CYAN_REDSTONE_WIRE.get(), COLOR_MAP.get("cyan"));
        registerWireColor(event, ModBlocks.LIGHT_BLUE_REDSTONE_WIRE.get(), COLOR_MAP.get("light_blue"));
        registerWireColor(event, ModBlocks.BLUE_REDSTONE_WIRE.get(), COLOR_MAP.get("blue"));
        registerWireColor(event, ModBlocks.PURPLE_REDSTONE_WIRE.get(), COLOR_MAP.get("purple"));
        registerWireColor(event, ModBlocks.MAGENTA_REDSTONE_WIRE.get(), COLOR_MAP.get("magenta"));
        registerWireColor(event, ModBlocks.PINK_REDSTONE_WIRE.get(), COLOR_MAP.get("pink"));
    }

    /**
     * Register color handlers for items.
     * @param event The item color registration event
     */
    public static void registerItemColors(RegisterColorHandlersEvent.ColorResolvers event) {
        // Redstone dust items use colored textures, so no additional handlers are needed.
    }

    /**
     * Helper method to register wire color.
     * @param event The registration event
     * @param block The wire block
     * @param baseColor The base color
     */
    private static void registerWireColor(RegisterColorHandlersEvent.Block event, net.minecraft.world.level.block.Block block, int baseColor) {
        event.register((state, world, pos, tintIndex) -> {
            int power = state.getValue(RedStoneWireBlock.POWER);
            return getRedstoneColor(power, baseColor);
        }, block);
    }

    /**
     * Calculate redstone color based on power level.
     * @param power Power level (0-15)
     * @param baseColor Base color in HEX format
     * @return Resulting color
     */
    private static int getRedstoneColor(int power, int baseColor) {
        float f = (float) power / 15.0F;
        float r = (float) (baseColor >> 16 & 255) / 255.0F;
        float g = (float) (baseColor >> 8 & 255) / 255.0F;
        float b = (float) (baseColor & 255) / 255.0F;

        // Apply a similar darkening effect as vanilla for low power
        float f1 = f * 0.6F + 0.4F;
        if (power == 0) {
            f1 = 0.3F;
        }

        float f2 = f * f * 0.7F - 0.5F;
        float f3 = f * f * 0.6F - 0.7F;
        if (f2 < 0.0F) {
            f2 = 0.0F;
        }
        if (f3 < 0.0F) {
            f3 = 0.0F;
        }

        int i = Mth.clamp((int) (r * f1 * 255.0F), 0, 255);
        int j = Mth.clamp((int) (g * f1 * 255.0F), 0, 255);
        int k = Mth.clamp((int) (b * f1 * 255.0F), 0, 255);
        
        return i << 16 | j << 8 | k;
    }
}
