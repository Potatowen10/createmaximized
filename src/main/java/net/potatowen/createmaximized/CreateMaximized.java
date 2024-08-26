package net.potatowen.createmaximized;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.potatowen.createmaximized.block.ModBlocks;
import net.potatowen.createmaximized.block.entity.ModBlockEntities;
import net.potatowen.createmaximized.entity.ModEntities;
import net.potatowen.createmaximized.entity.client.ModBoatRenderer;
import net.potatowen.createmaximized.item.MaximizedCreativeTab;
import net.potatowen.createmaximized.item.ModItems;
import net.potatowen.createmaximized.util.MapleWoodType;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateMaximized.MODID)
public class CreateMaximized
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "createmaximized";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateMaximized()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        MaximizedCreativeTab.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(MapleWoodType.MAPLE);

            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
        }
    }
}
