package win.korowin.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import win.korowin.ColoredRedstoneFabric;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for initializing and registering all mod items on Fabric.
 */
public class ModItems {
    public static final List<Item> ALL_ITEMS = new ArrayList<>();

    private static Item registerItem(String name, Item item) {
        Item registered = Registry.register(Registries.ITEM, Identifier.of(ColoredRedstoneFabric.MODID, name), item);
        ALL_ITEMS.add(registered);
        return registered;
    }

    private static Item registerRedstoneDust(String name, Block block) {
        Identifier id = Identifier.of(ColoredRedstoneFabric.MODID, name);
        return registerItem(name, new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id))));
    }

    private static Item registerRedstoneBlock(String name, Block block) {
        Identifier id = Identifier.of(ColoredRedstoneFabric.MODID, name);
        return registerItem(name, new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)).useBlockPrefixedTranslationKey()));
    }

    private static Item registerRedstoneLamp(String name, Block block) {
        Identifier id = Identifier.of(ColoredRedstoneFabric.MODID, name);
        return registerItem(name, new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)).useBlockPrefixedTranslationKey()));
    }

    private static Item registerRedstoneTorch(String name, Block standing, Block wall) {
        Identifier id = Identifier.of(ColoredRedstoneFabric.MODID, name);
        return registerItem(name, new VerticallyAttachableBlockItem(standing, wall, Direction.DOWN, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)).useBlockPrefixedTranslationKey()));
    }

    // Dusts
    public static final Item WHITE_REDSTONE = registerRedstoneDust("white_redstone", ModBlocks.WHITE_REDSTONE_WIRE);
    public static final Item LIGHT_GRAY_REDSTONE = registerRedstoneDust("light_gray_redstone", ModBlocks.LIGHT_GRAY_REDSTONE_WIRE);
    public static final Item GRAY_REDSTONE = registerRedstoneDust("gray_redstone", ModBlocks.GRAY_REDSTONE_WIRE);
    public static final Item BLACK_REDSTONE = registerRedstoneDust("black_redstone", ModBlocks.BLACK_REDSTONE_WIRE);
    public static final Item BROWN_REDSTONE = registerRedstoneDust("brown_redstone", ModBlocks.BROWN_REDSTONE_WIRE);
    public static final Item ORANGE_REDSTONE = registerRedstoneDust("orange_redstone", ModBlocks.ORANGE_REDSTONE_WIRE);
    public static final Item YELLOW_REDSTONE = registerRedstoneDust("yellow_redstone", ModBlocks.YELLOW_REDSTONE_WIRE);
    public static final Item LIME_REDSTONE = registerRedstoneDust("lime_redstone", ModBlocks.LIME_REDSTONE_WIRE);
    public static final Item GREEN_REDSTONE = registerRedstoneDust("green_redstone", ModBlocks.GREEN_REDSTONE_WIRE);
    public static final Item CYAN_REDSTONE = registerRedstoneDust("cyan_redstone", ModBlocks.CYAN_REDSTONE_WIRE);
    public static final Item LIGHT_BLUE_REDSTONE = registerRedstoneDust("light_blue_redstone", ModBlocks.LIGHT_BLUE_REDSTONE_WIRE);
    public static final Item BLUE_REDSTONE = registerRedstoneDust("blue_redstone", ModBlocks.BLUE_REDSTONE_WIRE);
    public static final Item PURPLE_REDSTONE = registerRedstoneDust("purple_redstone", ModBlocks.PURPLE_REDSTONE_WIRE);
    public static final Item MAGENTA_REDSTONE = registerRedstoneDust("magenta_redstone", ModBlocks.MAGENTA_REDSTONE_WIRE);
    public static final Item PINK_REDSTONE = registerRedstoneDust("pink_redstone", ModBlocks.PINK_REDSTONE_WIRE);

    // Blocks
    public static final Item WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", ModBlocks.WHITE_REDSTONE_BLOCK);
    public static final Item LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", ModBlocks.LIGHT_GRAY_REDSTONE_BLOCK);
    public static final Item GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", ModBlocks.GRAY_REDSTONE_BLOCK);
    public static final Item BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", ModBlocks.BLACK_REDSTONE_BLOCK);
    public static final Item BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", ModBlocks.BROWN_REDSTONE_BLOCK);
    public static final Item ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", ModBlocks.ORANGE_REDSTONE_BLOCK);
    public static final Item YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", ModBlocks.YELLOW_REDSTONE_BLOCK);
    public static final Item LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", ModBlocks.LIME_REDSTONE_BLOCK);
    public static final Item GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", ModBlocks.GREEN_REDSTONE_BLOCK);
    public static final Item CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", ModBlocks.CYAN_REDSTONE_BLOCK);
    public static final Item LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", ModBlocks.LIGHT_BLUE_REDSTONE_BLOCK);
    public static final Item BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", ModBlocks.BLUE_REDSTONE_BLOCK);
    public static final Item PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", ModBlocks.PURPLE_REDSTONE_BLOCK);
    public static final Item MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", ModBlocks.MAGENTA_REDSTONE_BLOCK);
    public static final Item PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", ModBlocks.PINK_REDSTONE_BLOCK);

    // Lamps
    public static final Item WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", ModBlocks.WHITE_REDSTONE_LAMP);
    public static final Item LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", ModBlocks.LIGHT_GRAY_REDSTONE_LAMP);
    public static final Item GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", ModBlocks.GRAY_REDSTONE_LAMP);
    public static final Item BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", ModBlocks.BLACK_REDSTONE_LAMP);
    public static final Item BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", ModBlocks.BROWN_REDSTONE_LAMP);
    public static final Item RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", ModBlocks.RED_REDSTONE_LAMP);
    public static final Item ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", ModBlocks.ORANGE_REDSTONE_LAMP);
    public static final Item YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", ModBlocks.YELLOW_REDSTONE_LAMP);
    public static final Item LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", ModBlocks.LIME_REDSTONE_LAMP);
    public static final Item GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", ModBlocks.GREEN_REDSTONE_LAMP);
    public static final Item CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", ModBlocks.CYAN_REDSTONE_LAMP);
    public static final Item LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", ModBlocks.LIGHT_BLUE_REDSTONE_LAMP);
    public static final Item BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", ModBlocks.BLUE_REDSTONE_LAMP);
    public static final Item PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", ModBlocks.PURPLE_REDSTONE_LAMP);
    public static final Item MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", ModBlocks.MAGENTA_REDSTONE_LAMP);
    public static final Item PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", ModBlocks.PINK_REDSTONE_LAMP);

    // Torches
    public static final Item WHITE_REDSTONE_TORCH = registerRedstoneTorch("white_redstone_torch", ModBlocks.WHITE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(0));
    public static final Item LIGHT_GRAY_REDSTONE_TORCH = registerRedstoneTorch("light_gray_redstone_torch", ModBlocks.LIGHT_GRAY_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(1));
    public static final Item GRAY_REDSTONE_TORCH = registerRedstoneTorch("gray_redstone_torch", ModBlocks.GRAY_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(2));
    public static final Item BLACK_REDSTONE_TORCH = registerRedstoneTorch("black_redstone_torch", ModBlocks.BLACK_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(3));
    public static final Item BROWN_REDSTONE_TORCH = registerRedstoneTorch("brown_redstone_torch", ModBlocks.BROWN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(4));
    public static final Item ORANGE_REDSTONE_TORCH = registerRedstoneTorch("orange_redstone_torch", ModBlocks.ORANGE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(5));
    public static final Item YELLOW_REDSTONE_TORCH = registerRedstoneTorch("yellow_redstone_torch", ModBlocks.YELLOW_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(6));
    public static final Item LIME_REDSTONE_TORCH = registerRedstoneTorch("lime_redstone_torch", ModBlocks.LIME_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(7));
    public static final Item GREEN_REDSTONE_TORCH = registerRedstoneTorch("green_redstone_torch", ModBlocks.GREEN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(8));
    public static final Item CYAN_REDSTONE_TORCH = registerRedstoneTorch("cyan_redstone_torch", ModBlocks.CYAN_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(9));
    public static final Item LIGHT_BLUE_REDSTONE_TORCH = registerRedstoneTorch("light_blue_redstone_torch", ModBlocks.LIGHT_BLUE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(10));
    public static final Item BLUE_REDSTONE_TORCH = registerRedstoneTorch("blue_redstone_torch", ModBlocks.BLUE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(11));
    public static final Item PURPLE_REDSTONE_TORCH = registerRedstoneTorch("purple_redstone_torch", ModBlocks.PURPLE_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(12));
    public static final Item MAGENTA_REDSTONE_TORCH = registerRedstoneTorch("magenta_redstone_torch", ModBlocks.MAGENTA_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(13));
    public static final Item PINK_REDSTONE_TORCH = registerRedstoneTorch("pink_redstone_torch", ModBlocks.PINK_REDSTONE_TORCH, ModBlocks.REDSTONE_WALL_TORCHES.get(14));

    public static void register() {
        // Items are registered during field initialization
    }
}
