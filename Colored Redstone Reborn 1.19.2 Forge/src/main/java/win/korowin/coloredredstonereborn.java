package win.korowin;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
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
import win.korowin.init.ModItems;
import net.minecraftforge.fml.ModLoadingContext;

/**
 * Main mod class for Colored Redstone Reborn in 1.19.2.
 */
@Mod(coloredredstonereborn.MODID)
public class coloredredstonereborn {
    public static final String MODID = "coloredredstonereborn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public coloredredstonereborn() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register components
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        // Lifecycle event listeners
        modEventBus.addListener(this::commonSetup);

        // Configuration
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.register(Config.class);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Colored Redstone Reborn: Common setup finished.");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Colored Redstone Reborn: Client setup finished.");
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            ModColorHandlers.registerBlockColors(event);
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            ModColorHandlers.registerItemColors(event);
        }
    }
}
