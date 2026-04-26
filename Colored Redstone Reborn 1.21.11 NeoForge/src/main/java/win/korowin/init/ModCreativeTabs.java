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
                ModItems.ITEMS.getEntries().forEach(item -> {
                    output.accept(item.get());
                });
            }).build());

    /**
     * Register creative tabs with the mod event bus.
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
