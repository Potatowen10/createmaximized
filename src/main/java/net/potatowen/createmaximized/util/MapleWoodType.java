package net.potatowen.createmaximized.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.potatowen.createmaximized.CreateMaximized;

public class MapleWoodType {
    public static final WoodType MAPLE = WoodType.register(new WoodType(CreateMaximized.MODID + ":maple", BlockSetType.OAK));
}