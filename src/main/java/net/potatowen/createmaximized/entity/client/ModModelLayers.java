package net.potatowen.createmaximized.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.potatowen.createmaximized.CreateMaximized;

public class ModModelLayers {
    public static final ModelLayerLocation MAPLE_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(CreateMaximized.MODID, "boat/maple"), "main");
    public static final ModelLayerLocation MAPLE_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(CreateMaximized.MODID, "chest_boat/maple"), "main");
}
