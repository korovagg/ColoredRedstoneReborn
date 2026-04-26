package win.korowin.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import win.korowin.ColoredRedstoneReborn;
import win.korowin.block.ColoredRedstoneWireBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for initializing and registering all mod blocks.
 */
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ColoredRedstoneReborn.MODID);
    public static final List<DeferredBlock<Block>> REDSTONE_BLOCKS = new ArrayList<>();
    public static final List<DeferredBlock<Block>> REDSTONE_WIRES = new ArrayList<>();
    public static final List<DeferredBlock<Block>> REDSTONE_LAMPS = new ArrayList<>();

    private static DeferredBlock<Block> registerWire(String name, int color) {
        DeferredBlock<Block> block = BLOCKS.registerBlock(name, (properties) -> new ColoredRedstoneWireBlock(properties, color), BlockBehaviour.Properties.of()
                .noCollision()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.STONE));
        REDSTONE_WIRES.add(block);
        return block;
    }

    /**
     * Helper method to register colored redstone block.
     * @param name The block name
     * @param color The map color
     * @return The registered block
     */
    private static DeferredBlock<Block> registerRedstoneBlock(String name, MapColor color) {
        DeferredBlock<Block> block = BLOCKS.registerBlock(name, PoweredBlock::new, BlockBehaviour.Properties.of()
                .mapColor(color)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL));
        REDSTONE_BLOCKS.add(block);
        return block;
    }

    /**
     * Helper method to register colored redstone lamp.
     * @param name The block name
     * @param color The map color
     * @return The registered block
     */
    private static DeferredBlock<Block> registerRedstoneLamp(String name, MapColor color) {
        DeferredBlock<Block> block = BLOCKS.registerBlock(name, RedstoneLampBlock::new, BlockBehaviour.Properties.of()
                .mapColor(color)
                .strength(0.3F)
                .explosionResistance(0.3F)
                .lightLevel((state) -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                .sound(SoundType.GLASS));
        REDSTONE_LAMPS.add(block);
        return block;
    }

    // Register wires

    public static final DeferredBlock<Block> WHITE_REDSTONE_WIRE = registerWire("white_redstone_wire", 0xF9FFFE);
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_WIRE = registerWire("light_gray_redstone_wire", 0x9D9D97);
    public static final DeferredBlock<Block> GRAY_REDSTONE_WIRE = registerWire("gray_redstone_wire", 0x474F52);
    public static final DeferredBlock<Block> BLACK_REDSTONE_WIRE = registerWire("black_redstone_wire", 0x1D1D21);
    public static final DeferredBlock<Block> BROWN_REDSTONE_WIRE = registerWire("brown_redstone_wire", 0x835432);
    public static final DeferredBlock<Block> ORANGE_REDSTONE_WIRE = registerWire("orange_redstone_wire", 0xF07613);
    public static final DeferredBlock<Block> YELLOW_REDSTONE_WIRE = registerWire("yellow_redstone_wire", 0xFED83D);
    public static final DeferredBlock<Block> LIME_REDSTONE_WIRE = registerWire("lime_redstone_wire", 0x80C71F);
    public static final DeferredBlock<Block> GREEN_REDSTONE_WIRE = registerWire("green_redstone_wire", 0x5E7C16);
    public static final DeferredBlock<Block> CYAN_REDSTONE_WIRE = registerWire("cyan_redstone_wire", 0x169C9C);
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_WIRE = registerWire("light_blue_redstone_wire", 0x3AB3DA);
    public static final DeferredBlock<Block> BLUE_REDSTONE_WIRE = registerWire("blue_redstone_wire", 0x3C44AA);
    public static final DeferredBlock<Block> PURPLE_REDSTONE_WIRE = registerWire("purple_redstone_wire", 0x8932B8);
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_WIRE = registerWire("magenta_redstone_wire", 0xC74EBD);
    public static final DeferredBlock<Block> PINK_REDSTONE_WIRE = registerWire("pink_redstone_wire", 0xF38BAA);

    public static final DeferredBlock<Block> WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", MapColor.SNOW);
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", MapColor.COLOR_GRAY);
    public static final DeferredBlock<Block> BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", MapColor.COLOR_BROWN);
    public static final DeferredBlock<Block> ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", MapColor.COLOR_ORANGE);
    public static final DeferredBlock<Block> YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", MapColor.COLOR_YELLOW);
    public static final DeferredBlock<Block> LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredBlock<Block> GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", MapColor.COLOR_GREEN);
    public static final DeferredBlock<Block> CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", MapColor.COLOR_CYAN);
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", MapColor.COLOR_LIGHT_BLUE);
    public static final DeferredBlock<Block> BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", MapColor.COLOR_BLUE);
    public static final DeferredBlock<Block> PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", MapColor.COLOR_PURPLE);
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", MapColor.COLOR_MAGENTA);
    public static final DeferredBlock<Block> PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", MapColor.COLOR_PINK);

    public static final DeferredBlock<Block> WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", MapColor.SNOW);
    public static final DeferredBlock<Block> LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", MapColor.COLOR_GRAY);
    public static final DeferredBlock<Block> BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", MapColor.COLOR_BROWN);
    public static final DeferredBlock<Block> RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", MapColor.COLOR_RED);
    public static final DeferredBlock<Block> ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", MapColor.COLOR_ORANGE);
    public static final DeferredBlock<Block> YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", MapColor.COLOR_YELLOW);
    public static final DeferredBlock<Block> LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredBlock<Block> GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", MapColor.COLOR_GREEN);
    public static final DeferredBlock<Block> CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", MapColor.COLOR_CYAN);
    public static final DeferredBlock<Block> LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", MapColor.COLOR_LIGHT_BLUE);
    public static final DeferredBlock<Block> BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", MapColor.COLOR_BLUE);
    public static final DeferredBlock<Block> PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", MapColor.COLOR_PURPLE);
    public static final DeferredBlock<Block> MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", MapColor.COLOR_MAGENTA);
    public static final DeferredBlock<Block> PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", MapColor.COLOR_PINK);

    /**
     * Register blocks with the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
