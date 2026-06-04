package win.korowin.init;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import win.korowin.coloredredstonereborn;
import win.korowin.block.ColoredRedstoneTorchBlock;
import win.korowin.block.ColoredRedstoneWallTorchBlock;
import win.korowin.block.ColoredRedstoneWireBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for initializing and registering all mod blocks.
 */
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, coloredredstonereborn.MODID);
    public static final List<RegistryObject<Block>> REDSTONE_BLOCKS = new ArrayList<>();
    public static final List<RegistryObject<Block>> REDSTONE_WIRES = new ArrayList<>();
    public static final List<RegistryObject<Block>> REDSTONE_LAMPS = new ArrayList<>();
    public static final List<RegistryObject<Block>> REDSTONE_TORCHES = new ArrayList<>();
    public static final Map<String, RegistryObject<Block>> REDSTONE_WALL_TORCHES = new HashMap<>();

    /**
     * Helper method to register colored redstone wire.
     * @param name The block name
     * @param color The color in HEX format
     * @return The registered block
     */
    private static RegistryObject<Block> registerWire(String name, int color) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new ColoredRedstoneWireBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                .noOcclusion()
                .noCollission()
                .instabreak()
                .sound(SoundType.STONE), color));
        REDSTONE_WIRES.add(block);
        return block;
    }

    /**
     * Helper method to register colored redstone block.
     * @param name The block name
     * @param color The material color
     * @return The registered block
     */
    private static RegistryObject<Block> registerRedstoneBlock(String name, MaterialColor color) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new PoweredBlock(BlockBehaviour.Properties.of(Material.METAL, color)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)));
        REDSTONE_BLOCKS.add(block);
        return block;
    }

    /**
     * Helper method to register colored redstone lamp.
     * @param name The block name
     * @param color The material color
     * @return The registered block
     */
    private static RegistryObject<Block> registerRedstoneLamp(String name, MaterialColor color) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS, color)
                .strength(0.3F)
                .explosionResistance(0.3F)
                .lightLevel((state) -> state.getValue(RedstoneLampBlock.LIT) ? 15 : 0)
                .sound(SoundType.GLASS)));
        REDSTONE_LAMPS.add(block);
        return block;
    }

    /**
     * Helper method to register colored redstone torch.
     * @param name The block name
     * @param color The material color
     * @param hexColor The color in HEX format
     * @return The registered block
     */
    private static RegistryObject<Block> registerRedstoneTorch(String name, MaterialColor color, int hexColor) {
        String wallName = name.replace("_torch", "_wall_torch");

        RegistryObject<Block> wall = BLOCKS.register(wallName, () -> new ColoredRedstoneWallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION, color)
                .noCollission()
                .instabreak()
                .lightLevel((state) -> state.getValue(RedstoneTorchBlock.LIT) ? 7 : 0)
                .sound(SoundType.WOOD), hexColor));
        REDSTONE_WALL_TORCHES.put(wallName, wall);

        RegistryObject<Block> block = BLOCKS.register(name, () -> new ColoredRedstoneTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION, color)
                .noCollission()
                .instabreak()
                .lightLevel((state) -> state.getValue(RedstoneTorchBlock.LIT) ? 7 : 0)
                .sound(SoundType.WOOD), hexColor));
        REDSTONE_TORCHES.add(block);

        return block;
    }

    // Register wires

    public static final RegistryObject<Block> WHITE_REDSTONE_WIRE = registerWire("white_redstone_wire", 0xF9FFFE);
    public static final RegistryObject<Block> LIGHT_GRAY_REDSTONE_WIRE = registerWire("light_gray_redstone_wire", 0x9D9D97);
    public static final RegistryObject<Block> GRAY_REDSTONE_WIRE = registerWire("gray_redstone_wire", 0x474F52);
    public static final RegistryObject<Block> BLACK_REDSTONE_WIRE = registerWire("black_redstone_wire", 0x1D1D21);
    public static final RegistryObject<Block> BROWN_REDSTONE_WIRE = registerWire("brown_redstone_wire", 0x835432);
    public static final RegistryObject<Block> ORANGE_REDSTONE_WIRE = registerWire("orange_redstone_wire", 0xF07613);
    public static final RegistryObject<Block> YELLOW_REDSTONE_WIRE = registerWire("yellow_redstone_wire", 0xFED83D);
    public static final RegistryObject<Block> LIME_REDSTONE_WIRE = registerWire("lime_redstone_wire", 0x80C71F);
    public static final RegistryObject<Block> GREEN_REDSTONE_WIRE = registerWire("green_redstone_wire", 0x5E7C16);
    public static final RegistryObject<Block> CYAN_REDSTONE_WIRE = registerWire("cyan_redstone_wire", 0x169C9C);
    public static final RegistryObject<Block> LIGHT_BLUE_REDSTONE_WIRE = registerWire("light_blue_redstone_wire", 0x3AB3DA);
    public static final RegistryObject<Block> BLUE_REDSTONE_WIRE = registerWire("blue_redstone_wire", 0x3C44AA);
    public static final RegistryObject<Block> PURPLE_REDSTONE_WIRE = registerWire("purple_redstone_wire", 0x8932B8);
    public static final RegistryObject<Block> MAGENTA_REDSTONE_WIRE = registerWire("magenta_redstone_wire", 0xC74EBD);
    public static final RegistryObject<Block> PINK_REDSTONE_WIRE = registerWire("pink_redstone_wire", 0xF38BAA);

    public static final RegistryObject<Block> WHITE_REDSTONE_BLOCK = registerRedstoneBlock("white_redstone_block", MaterialColor.SNOW);
    public static final RegistryObject<Block> LIGHT_GRAY_REDSTONE_BLOCK = registerRedstoneBlock("light_gray_redstone_block", MaterialColor.COLOR_LIGHT_GRAY);
    public static final RegistryObject<Block> GRAY_REDSTONE_BLOCK = registerRedstoneBlock("gray_redstone_block", MaterialColor.COLOR_GRAY);
    public static final RegistryObject<Block> BLACK_REDSTONE_BLOCK = registerRedstoneBlock("black_redstone_block", MaterialColor.COLOR_BLACK);
    public static final RegistryObject<Block> BROWN_REDSTONE_BLOCK = registerRedstoneBlock("brown_redstone_block", MaterialColor.COLOR_BROWN);
    public static final RegistryObject<Block> ORANGE_REDSTONE_BLOCK = registerRedstoneBlock("orange_redstone_block", MaterialColor.COLOR_ORANGE);
    public static final RegistryObject<Block> YELLOW_REDSTONE_BLOCK = registerRedstoneBlock("yellow_redstone_block", MaterialColor.COLOR_YELLOW);
    public static final RegistryObject<Block> LIME_REDSTONE_BLOCK = registerRedstoneBlock("lime_redstone_block", MaterialColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> GREEN_REDSTONE_BLOCK = registerRedstoneBlock("green_redstone_block", MaterialColor.COLOR_GREEN);
    public static final RegistryObject<Block> CYAN_REDSTONE_BLOCK = registerRedstoneBlock("cyan_redstone_block", MaterialColor.COLOR_CYAN);
    public static final RegistryObject<Block> LIGHT_BLUE_REDSTONE_BLOCK = registerRedstoneBlock("light_blue_redstone_block", MaterialColor.COLOR_LIGHT_BLUE);
    public static final RegistryObject<Block> BLUE_REDSTONE_BLOCK = registerRedstoneBlock("blue_redstone_block", MaterialColor.COLOR_BLUE);
    public static final RegistryObject<Block> PURPLE_REDSTONE_BLOCK = registerRedstoneBlock("purple_redstone_block", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> MAGENTA_REDSTONE_BLOCK = registerRedstoneBlock("magenta_redstone_block", MaterialColor.COLOR_MAGENTA);
    public static final RegistryObject<Block> PINK_REDSTONE_BLOCK = registerRedstoneBlock("pink_redstone_block", MaterialColor.COLOR_PINK);

    public static final RegistryObject<Block> WHITE_REDSTONE_LAMP = registerRedstoneLamp("white_redstone_lamp", MaterialColor.SNOW);
    public static final RegistryObject<Block> LIGHT_GRAY_REDSTONE_LAMP = registerRedstoneLamp("light_gray_redstone_lamp", MaterialColor.COLOR_LIGHT_GRAY);
    public static final RegistryObject<Block> GRAY_REDSTONE_LAMP = registerRedstoneLamp("gray_redstone_lamp", MaterialColor.COLOR_GRAY);
    public static final RegistryObject<Block> BLACK_REDSTONE_LAMP = registerRedstoneLamp("black_redstone_lamp", MaterialColor.COLOR_BLACK);
    public static final RegistryObject<Block> BROWN_REDSTONE_LAMP = registerRedstoneLamp("brown_redstone_lamp", MaterialColor.COLOR_BROWN);
    public static final RegistryObject<Block> RED_REDSTONE_LAMP = registerRedstoneLamp("red_redstone_lamp", MaterialColor.COLOR_RED);
    public static final RegistryObject<Block> ORANGE_REDSTONE_LAMP = registerRedstoneLamp("orange_redstone_lamp", MaterialColor.COLOR_ORANGE);
    public static final RegistryObject<Block> YELLOW_REDSTONE_LAMP = registerRedstoneLamp("yellow_redstone_lamp", MaterialColor.COLOR_YELLOW);
    public static final RegistryObject<Block> LIME_REDSTONE_LAMP = registerRedstoneLamp("lime_redstone_lamp", MaterialColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> GREEN_REDSTONE_LAMP = registerRedstoneLamp("green_redstone_lamp", MaterialColor.COLOR_GREEN);
    public static final RegistryObject<Block> CYAN_REDSTONE_LAMP = registerRedstoneLamp("cyan_redstone_lamp", MaterialColor.COLOR_CYAN);
    public static final RegistryObject<Block> LIGHT_BLUE_REDSTONE_LAMP = registerRedstoneLamp("light_blue_redstone_lamp", MaterialColor.COLOR_LIGHT_BLUE);
    public static final RegistryObject<Block> BLUE_REDSTONE_LAMP = registerRedstoneLamp("blue_redstone_lamp", MaterialColor.COLOR_BLUE);
    public static final RegistryObject<Block> PURPLE_REDSTONE_LAMP = registerRedstoneLamp("purple_redstone_lamp", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> MAGENTA_REDSTONE_LAMP = registerRedstoneLamp("magenta_redstone_lamp", MaterialColor.COLOR_MAGENTA);
    public static final RegistryObject<Block> PINK_REDSTONE_LAMP = registerRedstoneLamp("pink_redstone_lamp", MaterialColor.COLOR_PINK);

    // Register torches

    public static final RegistryObject<Block> WHITE_REDSTONE_TORCH = registerRedstoneTorch("white_redstone_torch", MaterialColor.SNOW, 0xF9FFFE);
    public static final RegistryObject<Block> LIGHT_GRAY_REDSTONE_TORCH = registerRedstoneTorch("light_gray_redstone_torch", MaterialColor.COLOR_LIGHT_GRAY, 0x9D9D97);
    public static final RegistryObject<Block> GRAY_REDSTONE_TORCH = registerRedstoneTorch("gray_redstone_torch", MaterialColor.COLOR_GRAY, 0x474F52);
    public static final RegistryObject<Block> BLACK_REDSTONE_TORCH = registerRedstoneTorch("black_redstone_torch", MaterialColor.COLOR_BLACK, 0x1D1D21);
    public static final RegistryObject<Block> BROWN_REDSTONE_TORCH = registerRedstoneTorch("brown_redstone_torch", MaterialColor.COLOR_BROWN, 0x835432);
    public static final RegistryObject<Block> ORANGE_REDSTONE_TORCH = registerRedstoneTorch("orange_redstone_torch", MaterialColor.COLOR_ORANGE, 0xF07613);
    public static final RegistryObject<Block> YELLOW_REDSTONE_TORCH = registerRedstoneTorch("yellow_redstone_torch", MaterialColor.COLOR_YELLOW, 0xFED83D);
    public static final RegistryObject<Block> LIME_REDSTONE_TORCH = registerRedstoneTorch("lime_redstone_torch", MaterialColor.COLOR_LIGHT_GREEN, 0x80C71F);
    public static final RegistryObject<Block> GREEN_REDSTONE_TORCH = registerRedstoneTorch("green_redstone_torch", MaterialColor.COLOR_GREEN, 0x5E7C16);
    public static final RegistryObject<Block> CYAN_REDSTONE_TORCH = registerRedstoneTorch("cyan_redstone_torch", MaterialColor.COLOR_CYAN, 0x169C9C);
    public static final RegistryObject<Block> LIGHT_BLUE_REDSTONE_TORCH = registerRedstoneTorch("light_blue_redstone_torch", MaterialColor.COLOR_LIGHT_BLUE, 0x3AB3DA);
    public static final RegistryObject<Block> BLUE_REDSTONE_TORCH = registerRedstoneTorch("blue_redstone_torch", MaterialColor.COLOR_BLUE, 0x3C44AA);
    public static final RegistryObject<Block> PURPLE_REDSTONE_TORCH = registerRedstoneTorch("purple_redstone_torch", MaterialColor.COLOR_PURPLE, 0x8932B8);
    public static final RegistryObject<Block> MAGENTA_REDSTONE_TORCH = registerRedstoneTorch("magenta_redstone_torch", MaterialColor.COLOR_MAGENTA, 0xC74EBD);
    public static final RegistryObject<Block> PINK_REDSTONE_TORCH = registerRedstoneTorch("pink_redstone_torch", MaterialColor.COLOR_PINK, 0xF38BAA);

    /**
     * Registers the DeferredRegister to the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
