package net.potatowen.createmaximized.event;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.potatowen.createmaximized.CreateMaximized;
import net.potatowen.createmaximized.block.ModBlocks;
import net.potatowen.createmaximized.block.entity.ModBlockEntities;
import net.potatowen.createmaximized.entity.client.ModModelLayers;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = CreateMaximized.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    private static Object pLevel;
    private static Object pBlockPos;

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MAPLE_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.MAPLE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

}
