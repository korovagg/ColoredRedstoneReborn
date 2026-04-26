package win.korowin;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import org.slf4j.Logger;
import win.korowin.init.ModBlocks;
import win.korowin.init.ModColorHandlers;
import win.korowin.init.ModCreativeTabs;
import win.korowin.init.ModItems;
import net.minecraftforge.fml.ModLoadingContext;

/**
 * Main mod class for Colored Redstone Reborn.
 */
@Mod(ColoredRedstoneReborn.MODID)
public class ColoredRedstoneReborn {
    public static final String MODID = "coloredredstonereborn";
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Mod constructor initializing registration for blocks, items, and tabs.
     */
    public ColoredRedstoneReborn() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register components
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Lifecycle event listeners
        modEventBus.addListener(this::commonSetup);

        // Configuration
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.register(Config.class);
    }

    /**
     * Common setup for the mod, executed on both sides (client and server).
     * @param event The common setup event
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Colored Redstone Reborn: Common setup finished.");
    }

    /**
     * Client-only event handlers.
     */
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        /**
         * Client-side setup.
         * @param event The client setup event
         */
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Colored Redstone Reborn: Client setup finished.");
        }

        /**
         * Register color handlers for blocks.
         * @param event The block color registration event
         */
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            ModColorHandlers.registerBlockColors(event);
        }

        /**
         * Register color handlers for items.
         * @param event The item color registration event
         */
        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            ModColorHandlers.registerItemColors(event);
        }
    }
}
