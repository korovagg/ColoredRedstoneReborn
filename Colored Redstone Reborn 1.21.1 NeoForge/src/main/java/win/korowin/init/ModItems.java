package win.korowin.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import win.korowin.ColoredRedstoneReborn;

/**
 * Class for initializing and registering all mod items.
 */
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ColoredRedstoneReborn.MODID);

    /**
     * Helper method to register colored redstone dust item.
     * @param name The item name
     * @param block The corresponding wire block
     * @return The registered item
     */
    private static DeferredItem<Item> registerRedstoneDust(String name, DeferredBlock<Block> block) {
        return ITEMS.registerItem(name, properties -> new ItemNameBlockItem(block.get(), properties));
    }

    /**
     * Helper method to register block item for colored redstone block.
     * @param name The item name
     * @param block The corresponding block
     * @return The registered block item
     */
    private static DeferredItem<BlockItem> registerRedstoneBlock(String name, DeferredBlock<Block> block) {
        return ITEMS.registerSimpleBlockItem(name, block);
    }

    /**
     * Helper method to register block item for colored redstone lamp.
     * @param name The item name
     * @param block The corresponding block
     * @return The registered block item
     */
    private static DeferredItem<BlockItem> registerRedstoneLamp(String name, DeferredBlock<Block> block) {
        return ITEMS.registerSimpleBlockItem(name, block);
    }

    public static final DeferredItem<Item> WHITE_REDSTONE = registerRedstoneDust("white_redstone", ModBlocks.WHITE_REDSTONE_WIRE);
    public static final DeferredItem<Item> LIGHT_GRAY_REDSTONE = registerRedstoneDust("light_gray_redstone", ModBlocks.LIGHT_GRAY_REDSTONE_WIRE);
    public static final DeferredItem<Item> GRAY_REDSTONE = registerRedstoneDust("gray_redstone", ModBlocks.GRAY_REDSTONE_WIRE);
    public static final DeferredItem<Item> BLACK_REDSTONE = registerRedstoneDust("black_redstone", ModBlocks.BLACK_REDSTONE_WIRE);
    public static final DeferredItem<Item> BROWN_REDSTONE = registerRedstoneDust("brown_redstone", ModBlocks.BROWN_REDSTONE_WIRE);
    public static final DeferredItem<Item> ORANGE_REDSTONE = registerRedstoneDust("orange_redstone", ModBlocks.ORANGE_REDSTONE_WIRE);
    public static final DeferredItem<Item> YELLOW_REDSTONE = registerRedstoneDust("yellow_redstone", ModBlocks.YELLOW_REDSTONE_WIRE);
    public static final DeferredItem<Item> LIME_REDSTONE = registerRedstoneDust("lime_redstone", ModBlocks.LIME_REDSTONE_WIRE);
    public static final DeferredItem<Item> GREEN_REDSTONE = registerRedstoneDust("green_redstone", ModBlocks.GREEN_REDSTONE_WIRE);
    public static final DeferredItem<Item> CYAN_REDSTONE = registerRedstoneDust("cyan_redstone", ModBlocks.CYAN_REDSTONE_WIRE);
    public static final DeferredItem<Item> LIGHT_BLUE_REDSTONE = registerRedstoneDust("light_blue_redstone", ModBlocks.LIGHT_BLUE_REDSTONE_WIRE);
    public static final DeferredItem<Item> BLUE_REDSTONE = registerRedstoneDust("blue_redstone", ModBlocks.BLUE_REDSTONE_WIRE);
    public static final DeferredItem<Item> PURPLE_REDSTONE = registerRedstoneDust("purple_redstone", ModBlocks.PURPLE_REDSTONE_WIRE);
    public static final DeferredItem<Item> MAGENTA_REDSTONE = registerRedstoneDust("magenta_redstone", ModBlocks.MAGENTA_REDSTONE_WIRE);
    public static final DeferredItem<Item> PINK_REDSTONE = registerRedstoneDust("pink_redstone", ModBlocks.PINK_REDSTONE_WIRE);

    public static final DeferredItem<BlockItem> WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", ModBlocks.WHITE_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", ModBlocks.LIGHT_GRAY_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", ModBlocks.GRAY_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", ModBlocks.BLACK_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", ModBlocks.BROWN_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", ModBlocks.ORANGE_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", ModBlocks.YELLOW_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", ModBlocks.LIME_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", ModBlocks.GREEN_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", ModBlocks.CYAN_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", ModBlocks.LIGHT_BLUE_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", ModBlocks.BLUE_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", ModBlocks.PURPLE_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", ModBlocks.MAGENTA_REDSTONE_BLOCK);
    public static final DeferredItem<BlockItem> PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", ModBlocks.PINK_REDSTONE_BLOCK);

    public static final DeferredItem<BlockItem> WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", ModBlocks.WHITE_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", ModBlocks.LIGHT_GRAY_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", ModBlocks.GRAY_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", ModBlocks.BLACK_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", ModBlocks.BROWN_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", ModBlocks.RED_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", ModBlocks.ORANGE_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", ModBlocks.YELLOW_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", ModBlocks.LIME_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", ModBlocks.GREEN_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", ModBlocks.CYAN_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", ModBlocks.LIGHT_BLUE_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", ModBlocks.BLUE_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", ModBlocks.PURPLE_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", ModBlocks.MAGENTA_REDSTONE_LAMP);
    public static final DeferredItem<BlockItem> PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", ModBlocks.PINK_REDSTONE_LAMP);

    /**
     * Register items with the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
