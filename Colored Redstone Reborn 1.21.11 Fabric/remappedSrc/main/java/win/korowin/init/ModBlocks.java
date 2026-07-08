package win.korowin.init;

import net.minecraft.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import win.korowin.ColoredRedstoneFabric;
import win.korowin.block.ColoredRedstoneTorchBlock;
import win.korowin.block.ColoredRedstoneWallTorchBlock;
import win.korowin.block.ColoredRedstoneWireBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for initializing and registering all mod blocks on Fabric.
 */
public class ModBlocks {
    public static final List<Block> REDSTONE_BLOCKS = new ArrayList<>();
    public static final List<Block> REDSTONE_WIRES = new ArrayList<>();
    public static final List<Block> REDSTONE_LAMPS = new ArrayList<>();
    public static final List<Block> REDSTONE_TORCHES = new ArrayList<>();
    public static final List<Block> REDSTONE_WALL_TORCHES = new ArrayList<>();

    private static Block registerWire(String name, int color) {
        Identifier id = Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, name);
        Block block = Registry.register(BuiltInRegistries.BLOCK, id, new ColoredRedstoneWireBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, id))
                .noCollision()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.STONE), color));
        REDSTONE_WIRES.add(block);
        return block;
    }

    private static Block registerRedstoneBlock(String name, MapColor color) {
        Identifier id = Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, name);
        Block block = Registry.register(BuiltInRegistries.BLOCK, id, new PoweredBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, id))
                .mapColor(color)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)));
        REDSTONE_BLOCKS.add(block);
        return block;
    }

    private static Block registerRedstoneLamp(String name, MapColor color) {
        Identifier id = Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, name);
        Block block = Registry.register(BuiltInRegistries.BLOCK, id, new RedstoneLampBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, id))
                .mapColor(color)
                .strength(0.3F)
                .lightLevel((state) -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                .sound(SoundType.GLASS)));
        REDSTONE_LAMPS.add(block);
        return block;
    }

    private static Block registerRedstoneTorch(String name, MapColor color, int hexColor) {
        String wallName = name.replace("_torch", "_wall_torch");
        Identifier wallId = Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, wallName);
        Identifier torchId = Identifier.fromNamespaceAndPath(ColoredRedstoneFabric.MODID, name);

        Block wall = Registry.register(BuiltInRegistries.BLOCK, wallId, new ColoredRedstoneWallTorchBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, wallId))
                .mapColor(color)
                .noCollision()
                .instabreak()
                .lightLevel((state) -> state.getValue(RedstoneTorchBlock.LIT) ? 7 : 0)
                .sound(SoundType.WOOD)
                .pushReaction(PushReaction.DESTROY), hexColor));
        REDSTONE_WALL_TORCHES.add(wall);

        Block block = Registry.register(BuiltInRegistries.BLOCK, torchId, new ColoredRedstoneTorchBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, torchId))
                .mapColor(color)
                .noCollision()
                .instabreak()
                .lightLevel((state) -> state.getValue(RedstoneTorchBlock.LIT) ? 7 : 0)
                .sound(SoundType.WOOD)
                .pushReaction(PushReaction.DESTROY), hexColor));

        REDSTONE_TORCHES.add(block);
        return block;
    }

    // Register wires
    public static final Block WHITE_REDSTONE_WIRE = registerWire("white_redstone_wire", 0xF9FFFE);
    public static final Block LIGHT_GRAY_REDSTONE_WIRE = registerWire("light_gray_redstone_wire", 0x9D9D97);
    public static final Block GRAY_REDSTONE_WIRE = registerWire("gray_redstone_wire", 0x474F52);
    public static final Block BLACK_REDSTONE_WIRE = registerWire("black_redstone_wire", 0x1D1D21);
    public static final Block BROWN_REDSTONE_WIRE = registerWire("brown_redstone_wire", 0x835432);
    public static final Block ORANGE_REDSTONE_WIRE = registerWire("orange_redstone_wire", 0xF07613);
    public static final Block YELLOW_REDSTONE_WIRE = registerWire("yellow_redstone_wire", 0xFED83D);
    public static final Block LIME_REDSTONE_WIRE = registerWire("lime_redstone_wire", 0x80C71F);
    public static final Block GREEN_REDSTONE_WIRE = registerWire("green_redstone_wire", 0x5E7C16);
    public static final Block CYAN_REDSTONE_WIRE = registerWire("cyan_redstone_wire", 0x169C9C);
    public static final Block LIGHT_BLUE_REDSTONE_WIRE = registerWire("light_blue_redstone_wire", 0x3AB3DA);
    public static final Block BLUE_REDSTONE_WIRE = registerWire("blue_redstone_wire", 0x3C44AA);
    public static final Block PURPLE_REDSTONE_WIRE = registerWire("purple_redstone_wire", 0x8932B8);
    public static final Block MAGENTA_REDSTONE_WIRE = registerWire("magenta_redstone_wire", 0xC74EBD);
    public static final Block PINK_REDSTONE_WIRE = registerWire("pink_redstone_wire", 0xF38BAA);

    // Register blocks
    public static final Block WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", MapColor.SNOW);
    public static final Block LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", MapColor.COLOR_LIGHT_GRAY);
    public static final Block GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", MapColor.COLOR_GRAY);
    public static final Block BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", MapColor.COLOR_BLACK);
    public static final Block BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", MapColor.COLOR_BROWN);
    public static final Block ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", MapColor.COLOR_ORANGE);
    public static final Block YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", MapColor.COLOR_YELLOW);
    public static final Block LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", MapColor.COLOR_LIGHT_GREEN);
    public static final Block GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", MapColor.COLOR_GREEN);
    public static final Block CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", MapColor.COLOR_CYAN);
    public static final Block LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", MapColor.COLOR_LIGHT_BLUE);
    public static final Block BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", MapColor.COLOR_BLUE);
    public static final Block PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", MapColor.COLOR_PURPLE);
    public static final Block MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", MapColor.COLOR_MAGENTA);
    public static final Block PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", MapColor.COLOR_PINK);

    // Register lamps
    public static final Block WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", MapColor.SNOW);
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", MapColor.COLOR_LIGHT_GRAY);
    public static final Block GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", MapColor.COLOR_GRAY);
    public static final Block BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", MapColor.COLOR_BLACK);
    public static final Block BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", MapColor.COLOR_BROWN);
    public static final Block RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", MapColor.COLOR_RED);
    public static final Block ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", MapColor.COLOR_ORANGE);
    public static final Block YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", MapColor.COLOR_YELLOW);
    public static final Block LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", MapColor.COLOR_LIGHT_GREEN);
    public static final Block GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", MapColor.COLOR_GREEN);
    public static final Block CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", MapColor.COLOR_CYAN);
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", MapColor.COLOR_LIGHT_BLUE);
    public static final Block BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", MapColor.COLOR_BLUE);
    public static final Block PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", MapColor.COLOR_PURPLE);
    public static final Block MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", MapColor.COLOR_MAGENTA);
    public static final Block PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", MapColor.COLOR_PINK);

    // Register torches
    public static final Block WHITE_REDSTONE_TORCH = registerRedstoneTorch("white_redstone_torch", MapColor.SNOW, 0xF9FFFE);
    public static final Block LIGHT_GRAY_REDSTONE_TORCH = registerRedstoneTorch("light_gray_redstone_torch", MapColor.COLOR_LIGHT_GRAY, 0x9D9D97);
    public static final Block GRAY_REDSTONE_TORCH = registerRedstoneTorch("gray_redstone_torch", MapColor.COLOR_GRAY, 0x474F52);
    public static final Block BLACK_REDSTONE_TORCH = registerRedstoneTorch("black_redstone_torch", MapColor.COLOR_BLACK, 0x1D1D21);
    public static final Block BROWN_REDSTONE_TORCH = registerRedstoneTorch("brown_redstone_torch", MapColor.COLOR_BROWN, 0x835432);
    public static final Block ORANGE_REDSTONE_TORCH = registerRedstoneTorch("orange_redstone_torch", MapColor.COLOR_ORANGE, 0xF07613);
    public static final Block YELLOW_REDSTONE_TORCH = registerRedstoneTorch("yellow_redstone_torch", MapColor.COLOR_YELLOW, 0xFED83D);
    public static final Block LIME_REDSTONE_TORCH = registerRedstoneTorch("lime_redstone_torch", MapColor.COLOR_LIGHT_GREEN, 0x80C71F);
    public static final Block GREEN_REDSTONE_TORCH = registerRedstoneTorch("green_redstone_torch", MapColor.COLOR_GREEN, 0x5E7C16);
    public static final Block CYAN_REDSTONE_TORCH = registerRedstoneTorch("cyan_redstone_torch", MapColor.COLOR_CYAN, 0x169C9C);
    public static final Block LIGHT_BLUE_REDSTONE_TORCH = registerRedstoneTorch("light_blue_redstone_torch", MapColor.COLOR_LIGHT_BLUE, 0x3AB3DA);
    public static final Block BLUE_REDSTONE_TORCH = registerRedstoneTorch("blue_redstone_torch", MapColor.COLOR_BLUE, 0x3C44AA);
    public static final Block PURPLE_REDSTONE_TORCH = registerRedstoneTorch("purple_redstone_torch", MapColor.COLOR_PURPLE, 0x8932B8);
    public static final Block MAGENTA_REDSTONE_TORCH = registerRedstoneTorch("magenta_redstone_torch", MapColor.COLOR_MAGENTA, 0xC74EBD);
    public static final Block PINK_REDSTONE_TORCH = registerRedstoneTorch("pink_redstone_torch", MapColor.COLOR_PINK, 0xF38BAA);

    public static void register() {
        // Blocks are registered during field initialization
    }
}
