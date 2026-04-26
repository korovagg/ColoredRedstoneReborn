package win.korowin.init;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import win.korowin.ColoredRedstoneFabric;
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

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ColoredRedstoneFabric.MODID, name), block);
    }

    private static Block registerWire(String name, int color) {
        Block block = registerBlock(name, new ColoredRedstoneWireBlock(AbstractBlock.Settings.create()
                .noCollision()
                .breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY)
                .sounds(BlockSoundGroup.STONE), color));
        REDSTONE_WIRES.add(block);
        return block;
    }

    private static Block registerRedstoneBlock(String name, MapColor color) {
        Block block = registerBlock(name, new RedstoneBlock(AbstractBlock.Settings.create()
                .mapColor(color)
                .requiresTool()
                .strength(5.0F, 6.0F)
                .sounds(BlockSoundGroup.METAL)));
        REDSTONE_BLOCKS.add(block);
        return block;
    }

    private static Block registerRedstoneLamp(String name, MapColor color) {
        Block block = registerBlock(name, new RedstoneLampBlock(AbstractBlock.Settings.create()
                .mapColor(color)
                .strength(0.3F)
                .luminance((state) -> state.get(RedstoneLampBlock.LIT) ? 15 : 0)
                .sounds(BlockSoundGroup.GLASS)));
        REDSTONE_LAMPS.add(block);
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
    public static final Block WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", MapColor.WHITE);
    public static final Block LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", MapColor.LIGHT_GRAY);
    public static final Block GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", MapColor.GRAY);
    public static final Block BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", MapColor.BLACK);
    public static final Block BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", MapColor.BROWN);
    public static final Block ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", MapColor.ORANGE);
    public static final Block YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", MapColor.YELLOW);
    public static final Block LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", MapColor.LIME);
    public static final Block GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", MapColor.GREEN);
    public static final Block CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", MapColor.CYAN);
    public static final Block LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", MapColor.LIGHT_BLUE);
    public static final Block BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", MapColor.BLUE);
    public static final Block PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", MapColor.PURPLE);
    public static final Block MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", MapColor.MAGENTA);
    public static final Block PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", MapColor.PINK);

    // Register lamps
    public static final Block WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", MapColor.WHITE);
    public static final Block LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", MapColor.LIGHT_GRAY);
    public static final Block GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", MapColor.GRAY);
    public static final Block BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", MapColor.BLACK);
    public static final Block BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", MapColor.BROWN);
    public static final Block RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", MapColor.RED);
    public static final Block ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", MapColor.ORANGE);
    public static final Block YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", MapColor.YELLOW);
    public static final Block LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", MapColor.LIME);
    public static final Block GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", MapColor.GREEN);
    public static final Block CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", MapColor.CYAN);
    public static final Block LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", MapColor.LIGHT_BLUE);
    public static final Block BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", MapColor.BLUE);
    public static final Block PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", MapColor.PURPLE);
    public static final Block MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", MapColor.MAGENTA);
    public static final Block PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", MapColor.PINK);

    public static void register() {
        // Blocks are registered during field initialization
    }
}
