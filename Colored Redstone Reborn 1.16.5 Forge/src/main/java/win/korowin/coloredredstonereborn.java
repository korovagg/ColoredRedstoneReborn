package win.korowin;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.event.ColorHandlerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import win.korowin.init.ModBlocks;
import win.korowin.init.ModColorHandlers;
import win.korowin.init.ModItems;
import net.minecraftforge.fml.ModLoadingContext;

/**
 * Main mod class for Colored Redstone Reborn in 1.16.5.
 */
@Mod(coloredredstonereborn.MODID)
public class coloredredstonereborn {
    public static final String MODID = "coloredredstonereborn";
    public static final Logger LOGGER = LogManager.getLogger();

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
            // Set render layer for redstone wires to allow transparency in 1.16.5
            ModBlocks.REDSTONE_WIRES.forEach(block -> {
                RenderTypeLookup.setRenderLayer(block.get(), RenderType.cutout());
            });
            
            LOGGER.info("Colored Redstone Reborn: Client setup finished.");
        }

        @SubscribeEvent
        public static void registerBlockColors(ColorHandlerEvent.Block event) {
            ModColorHandlers.registerBlockColors(event);
        }

        @SubscribeEvent
        public static void registerItemColors(ColorHandlerEvent.Item event) {
            ModColorHandlers.registerItemColors(event);
        }
    }
}
