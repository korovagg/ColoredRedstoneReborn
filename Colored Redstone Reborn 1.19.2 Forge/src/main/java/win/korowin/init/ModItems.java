package win.korowin.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import win.korowin.coloredredstonereborn;

/**
 * Class for initializing and registering all mod items.
 */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, coloredredstonereborn.MODID);

    /**
     * Helper method to register colored redstone dust item.
     * @param name The item name
     * @param block The corresponding wire block
     * @return The registered item
     */
    private static RegistryObject<Item> registerRedstoneDust(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties().tab(ModCreativeTabs.COLORED_REDSTONE_TAB)));
    }

    /**
     * Helper method to register block item for colored redstone block.
     * @param name The item name
     * @param block The corresponding block
     * @return The registered block item
     */
    private static RegistryObject<Item> registerRedstoneBlock(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeTabs.COLORED_REDSTONE_TAB)));
    }

    /**
     * Helper method to register block item for colored redstone lamp.
     * @param name The item name
     * @param block The corresponding block
     * @return The registered block item
     */
    private static RegistryObject<Item> registerRedstoneLamp(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeTabs.COLORED_REDSTONE_TAB)));
    }

    /**
     * Helper method to register torch item that can be placed on floor or wall.
     * @param name The item name
     * @param standing The standing torch block
     * @param wall The wall torch block
     * @return The registered item
     */
    private static RegistryObject<Item> registerRedstoneTorch(String name, RegistryObject<Block> standing, RegistryObject<Block> wall) {
        return ITEMS.register(name, () -> new StandingAndWallBlockItem(standing.get(), wall.get(), new Item.Properties().tab(ModCreativeTabs.COLORED_REDSTONE_TAB)));
    }

    // Dusts
    public static final RegistryObject<Item> WHITE_REDSTONE = registerRedstoneDust("white_redstone", ModBlocks.WHITE_REDSTONE_WIRE);
    public static final RegistryObject<Item> LIGHT_GRAY_REDSTONE = registerRedstoneDust("light_gray_redstone", ModBlocks.LIGHT_GRAY_REDSTONE_WIRE);
    public static final RegistryObject<Item> GRAY_REDSTONE = registerRedstoneDust("gray_redstone", ModBlocks.GRAY_REDSTONE_WIRE);
    public static final RegistryObject<Item> BLACK_REDSTONE = registerRedstoneDust("black_redstone", ModBlocks.BLACK_REDSTONE_WIRE);
    public static final RegistryObject<Item> BROWN_REDSTONE = registerRedstoneDust("brown_redstone", ModBlocks.BROWN_REDSTONE_WIRE);
    public static final RegistryObject<Item> ORANGE_REDSTONE = registerRedstoneDust("orange_redstone", ModBlocks.ORANGE_REDSTONE_WIRE);
    public static final RegistryObject<Item> YELLOW_REDSTONE = registerRedstoneDust("yellow_redstone", ModBlocks.YELLOW_REDSTONE_WIRE);
    public static final RegistryObject<Item> LIME_REDSTONE = registerRedstoneDust("lime_redstone", ModBlocks.LIME_REDSTONE_WIRE);
    public static final RegistryObject<Item> GREEN_REDSTONE = registerRedstoneDust("green_redstone", ModBlocks.GREEN_REDSTONE_WIRE);
    public static final RegistryObject<Item> CYAN_REDSTONE = registerRedstoneDust("cyan_redstone", ModBlocks.CYAN_REDSTONE_WIRE);
    public static final RegistryObject<Item> LIGHT_BLUE_REDSTONE = registerRedstoneDust("light_blue_redstone", ModBlocks.LIGHT_BLUE_REDSTONE_WIRE);
    public static final RegistryObject<Item> BLUE_REDSTONE = registerRedstoneDust("blue_redstone", ModBlocks.BLUE_REDSTONE_WIRE);
    public static final RegistryObject<Item> PURPLE_REDSTONE = registerRedstoneDust("purple_redstone", ModBlocks.PURPLE_REDSTONE_WIRE);
    public static final RegistryObject<Item> MAGENTA_REDSTONE = registerRedstoneDust("magenta_redstone", ModBlocks.MAGENTA_REDSTONE_WIRE);
    public static final RegistryObject<Item> PINK_REDSTONE = registerRedstoneDust("pink_redstone", ModBlocks.PINK_REDSTONE_WIRE);

    public static final RegistryObject<Item> WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", ModBlocks.WHITE_REDSTONE_BLOCK);
    public static final RegistryObject<Item> LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", ModBlocks.LIGHT_GRAY_REDSTONE_BLOCK);
    public static final RegistryObject<Item> GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", ModBlocks.GRAY_REDSTONE_BLOCK);
    public static final RegistryObject<Item> BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", ModBlocks.BLACK_REDSTONE_BLOCK);
    public static final RegistryObject<Item> BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", ModBlocks.BROWN_REDSTONE_BLOCK);
    public static final RegistryObject<Item> ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", ModBlocks.ORANGE_REDSTONE_BLOCK);
    public static final RegistryObject<Item> YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", ModBlocks.YELLOW_REDSTONE_BLOCK);
    public static final RegistryObject<Item> LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", ModBlocks.LIME_REDSTONE_BLOCK);
    public static final RegistryObject<Item> GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", ModBlocks.GREEN_REDSTONE_BLOCK);
    public static final RegistryObject<Item> CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", ModBlocks.CYAN_REDSTONE_BLOCK);
    public static final RegistryObject<Item> LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", ModBlocks.LIGHT_BLUE_REDSTONE_BLOCK);
    public static final RegistryObject<Item> BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", ModBlocks.BLUE_REDSTONE_BLOCK);
    public static final RegistryObject<Item> PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", ModBlocks.PURPLE_REDSTONE_BLOCK);
    public static final RegistryObject<Item> MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", ModBlocks.MAGENTA_REDSTONE_BLOCK);
    public static final RegistryObject<Item> PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", ModBlocks.PINK_REDSTONE_BLOCK);

    public static final RegistryObject<Item> WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", ModBlocks.WHITE_REDSTONE_LAMP);
    public static final RegistryObject<Item> LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", ModBlocks.LIGHT_GRAY_REDSTONE_LAMP);
    public static final RegistryObject<Item> GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", ModBlocks.GRAY_REDSTONE_LAMP);
    public static final RegistryObject<Item> BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", ModBlocks.BLACK_REDSTONE_LAMP);
    public static final RegistryObject<Item> BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", ModBlocks.BROWN_REDSTONE_LAMP);
    public static final RegistryObject<Item> RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", ModBlocks.RED_REDSTONE_LAMP);
    public static final RegistryObject<Item> ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", ModBlocks.ORANGE_REDSTONE_LAMP);
    public static final RegistryObject<Item> YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", ModBlocks.YELLOW_REDSTONE_LAMP);
    public static final RegistryObject<Item> LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", ModBlocks.LIME_REDSTONE_LAMP);
    public static final RegistryObject<Item> GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", ModBlocks.GREEN_REDSTONE_LAMP);
    public static final RegistryObject<Item> CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", ModBlocks.CYAN_REDSTONE_LAMP);
    public static final RegistryObject<Item> LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", ModBlocks.LIGHT_BLUE_REDSTONE_LAMP);
    public static final RegistryObject<Item> BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", ModBlocks.BLUE_REDSTONE_LAMP);
    public static final RegistryObject<Item> PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", ModBlocks.PURPLE_REDSTONE_LAMP);
    public static final RegistryObject<Item> MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", ModBlocks.MAGENTA_REDSTONE_LAMP);
    public static final RegistryObject<Item> PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", ModBlocks.PINK_REDSTONE_LAMP);

    // Torches

    public static final RegistryObject<Item> WHITE_REDSTONE_TORCH = registerRedstoneTorch("white_redstone_torch", ModBlocks.WHITE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("white_redstone_wall_torch"));
    public static final RegistryObject<Item> LIGHT_GRAY_REDSTONE_TORCH = registerRedstoneTorch("light_gray_redstone_torch", ModBlocks.LIGHT_GRAY_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("light_gray_redstone_wall_torch"));
    public static final RegistryObject<Item> GRAY_REDSTONE_TORCH = registerRedstoneTorch("gray_redstone_torch", ModBlocks.GRAY_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("gray_redstone_wall_torch"));
    public static final RegistryObject<Item> BLACK_REDSTONE_TORCH = registerRedstoneTorch("black_redstone_torch", ModBlocks.BLACK_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("black_redstone_wall_torch"));
    public static final RegistryObject<Item> BROWN_REDSTONE_TORCH = registerRedstoneTorch("brown_redstone_torch", ModBlocks.BROWN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("brown_redstone_wall_torch"));
    public static final RegistryObject<Item> ORANGE_REDSTONE_TORCH = registerRedstoneTorch("orange_redstone_torch", ModBlocks.ORANGE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("orange_redstone_wall_torch"));
    public static final RegistryObject<Item> YELLOW_REDSTONE_TORCH = registerRedstoneTorch("yellow_redstone_torch", ModBlocks.YELLOW_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("yellow_redstone_wall_torch"));
    public static final RegistryObject<Item> LIME_REDSTONE_TORCH = registerRedstoneTorch("lime_redstone_torch", ModBlocks.LIME_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("lime_redstone_wall_torch"));
    public static final RegistryObject<Item> GREEN_REDSTONE_TORCH = registerRedstoneTorch("green_redstone_torch", ModBlocks.GREEN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("green_redstone_wall_torch"));
    public static final RegistryObject<Item> CYAN_REDSTONE_TORCH = registerRedstoneTorch("cyan_redstone_torch", ModBlocks.CYAN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("cyan_redstone_wall_torch"));
    public static final RegistryObject<Item> LIGHT_BLUE_REDSTONE_TORCH = registerRedstoneTorch("light_blue_redstone_torch", ModBlocks.LIGHT_BLUE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("light_blue_redstone_wall_torch"));
    public static final RegistryObject<Item> BLUE_REDSTONE_TORCH = registerRedstoneTorch("blue_redstone_torch", ModBlocks.BLUE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("blue_redstone_wall_torch"));
    public static final RegistryObject<Item> PURPLE_REDSTONE_TORCH = registerRedstoneTorch("purple_redstone_torch", ModBlocks.PURPLE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("purple_redstone_wall_torch"));
    public static final RegistryObject<Item> MAGENTA_REDSTONE_TORCH = registerRedstoneTorch("magenta_redstone_torch", ModBlocks.MAGENTA_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("magenta_redstone_wall_torch"));
    public static final RegistryObject<Item> PINK_REDSTONE_TORCH = registerRedstoneTorch("pink_redstone_torch", ModBlocks.PINK_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get("pink_redstone_wall_torch"));

    /**
     * Register items with the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
