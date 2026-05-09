package win.korowin.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import win.korowin.ColoredRedstoneReborn;

/**
 * Class for registering creative mode tabs.
 */
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColoredRedstoneReborn.MODID);

    /**
     * Registration of the main mod creative tab.
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COLORED_REDSTONE_TAB = CREATIVE_MODE_TABS.register("colored_redstone_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.coloredredstonereborn"))
            .icon(() -> new ItemStack(ModItems.CYAN_REDSTONE.get()))
            .displayItems((parameters, output) -> {
                // Add Redstone Dusts
                output.accept(ModItems.WHITE_REDSTONE.get());
                output.accept(ModItems.LIGHT_GRAY_REDSTONE.get());
                output.accept(ModItems.GRAY_REDSTONE.get());
                output.accept(ModItems.BLACK_REDSTONE.get());
                output.accept(ModItems.BROWN_REDSTONE.get());
                output.accept(ModItems.ORANGE_REDSTONE.get());
                output.accept(ModItems.YELLOW_REDSTONE.get());
                output.accept(ModItems.LIME_REDSTONE.get());
                output.accept(ModItems.GREEN_REDSTONE.get());
                output.accept(ModItems.CYAN_REDSTONE.get());
                output.accept(ModItems.LIGHT_BLUE_REDSTONE.get());
                output.accept(ModItems.BLUE_REDSTONE.get());
                output.accept(ModItems.PURPLE_REDSTONE.get());
                output.accept(ModItems.MAGENTA_REDSTONE.get());
                output.accept(ModItems.PINK_REDSTONE.get());

                // Add Redstone Blocks
                output.accept(ModItems.WHITE_REDSTONE_BLOCK.get());
                output.accept(ModItems.LIGHT_GRAY_REDSTONE_BLOCK.get());
                output.accept(ModItems.GRAY_REDSTONE_BLOCK.get());
                output.accept(ModItems.BLACK_REDSTONE_BLOCK.get());
                output.accept(ModItems.BROWN_REDSTONE_BLOCK.get());
                output.accept(ModItems.ORANGE_REDSTONE_BLOCK.get());
                output.accept(ModItems.YELLOW_REDSTONE_BLOCK.get());
                output.accept(ModItems.LIME_REDSTONE_BLOCK.get());
                output.accept(ModItems.GREEN_REDSTONE_BLOCK.get());
                output.accept(ModItems.CYAN_REDSTONE_BLOCK.get());
                output.accept(ModItems.LIGHT_BLUE_REDSTONE_BLOCK.get());
                output.accept(ModItems.BLUE_REDSTONE_BLOCK.get());
                output.accept(ModItems.PURPLE_REDSTONE_BLOCK.get());
                output.accept(ModItems.MAGENTA_REDSTONE_BLOCK.get());
                output.accept(ModItems.PINK_REDSTONE_BLOCK.get());

                // Add Redstone Lamps
                output.accept(ModItems.WHITE_REDSTONE_LAMP.get());
                output.accept(ModItems.LIGHT_GRAY_REDSTONE_LAMP.get());
                output.accept(ModItems.GRAY_REDSTONE_LAMP.get());
                output.accept(ModItems.BLACK_REDSTONE_LAMP.get());
                output.accept(ModItems.BROWN_REDSTONE_LAMP.get());
                output.accept(ModItems.RED_REDSTONE_LAMP.get());
                output.accept(ModItems.ORANGE_REDSTONE_LAMP.get());
                output.accept(ModItems.YELLOW_REDSTONE_LAMP.get());
                output.accept(ModItems.LIME_REDSTONE_LAMP.get());
                output.accept(ModItems.GREEN_REDSTONE_LAMP.get());
                output.accept(ModItems.CYAN_REDSTONE_LAMP.get());
                output.accept(ModItems.LIGHT_BLUE_REDSTONE_LAMP.get());
                output.accept(ModItems.BLUE_REDSTONE_LAMP.get());
                output.accept(ModItems.PURPLE_REDSTONE_LAMP.get());
                output.accept(ModItems.MAGENTA_REDSTONE_LAMP.get());
                output.accept(ModItems.PINK_REDSTONE_LAMP.get());

                // Add Redstone Torches
                output.accept(ModItems.WHITE_REDSTONE_TORCH.get());
                output.accept(ModItems.LIGHT_GRAY_REDSTONE_TORCH.get());
                output.accept(ModItems.GRAY_REDSTONE_TORCH.get());
                output.accept(ModItems.BLACK_REDSTONE_TORCH.get());
                output.accept(ModItems.BROWN_REDSTONE_TORCH.get());
                output.accept(ModItems.ORANGE_REDSTONE_TORCH.get());
                output.accept(ModItems.YELLOW_REDSTONE_TORCH.get());
                output.accept(ModItems.LIME_REDSTONE_TORCH.get());
                output.accept(ModItems.GREEN_REDSTONE_TORCH.get());
                output.accept(ModItems.CYAN_REDSTONE_TORCH.get());
                output.accept(ModItems.LIGHT_BLUE_REDSTONE_TORCH.get());
                output.accept(ModItems.BLUE_REDSTONE_TORCH.get());
                output.accept(ModItems.PURPLE_REDSTONE_TORCH.get());
                output.accept(ModItems.MAGENTA_REDSTONE_TORCH.get());
                output.accept(ModItems.PINK_REDSTONE_TORCH.get());
            }).build());

    /**
     * Register creative tabs with the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
