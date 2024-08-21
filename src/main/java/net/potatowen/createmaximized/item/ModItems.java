package net.potatowen.createmaximized.item;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.potatowen.createmaximized.CreateMaximized;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potatowen.createmaximized.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateMaximized.MODID);

    public static final RegistryObject<Item> BRASS_COIN = ITEMS.register("brass_coin",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> POLISHED_NETHER_QUARTZ = ITEMS.register("polished_nether_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_QUARTZ_SHEET = ITEMS.register("nether_quartz_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
