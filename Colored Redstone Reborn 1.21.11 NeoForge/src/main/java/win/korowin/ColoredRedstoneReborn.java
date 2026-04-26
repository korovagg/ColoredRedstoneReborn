package win.korowin;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.slf4j.Logger;
import win.korowin.init.ModBlocks;
import win.korowin.init.ModColorHandlers;
import win.korowin.init.ModCreativeTabs;
import win.korowin.init.ModItems;

/**
 * Main mod class for Colored Redstone Reborn.
 */
@Mod(ColoredRedstoneReborn.MODID)
public class ColoredRedstoneReborn {
    public static final String MODID = "coloredredstonereborn";
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Mod constructor initializing registration for blocks, items, and tabs.
     * @param modEventBus The mod event bus
     * @param modContainer The mod container
     */
    public ColoredRedstoneReborn(IEventBus modEventBus, ModContainer modContainer) {
        // Register components
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Lifecycle event listeners
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::registerBlockColors);
        modEventBus.addListener(this::registerItemColors);

        // Configuration
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.addListener(Config::onLoad);
    }

    /**
     * Common setup for the mod, executed on both sides (client and server).
     * @param event The common setup event
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Colored Redstone Reborn: Common setup finished.");
    }

    /**
     * Client-side setup.
     * @param event The client setup event
     */
    private void onClientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Colored Redstone Reborn: Client setup finished.");
    }

    /**
     * Register color handlers for blocks.
     * @param event The block color registration event
     */
    private void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        ModColorHandlers.registerBlockColors(event);
    }

    /**
     * Register color handlers for items.
     * @param event The item color registration event
     */
    private void registerItemColors(RegisterColorHandlersEvent.ColorResolvers event) {
        ModColorHandlers.registerItemColors(event);
    }
}
