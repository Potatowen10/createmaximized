package net.potatowen.createmaximized.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.potatowen.createmaximized.CreateMaximized;
import net.potatowen.createmaximized.block.ModBlocks;

public class MaximizedCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMaximized.MODID);

    public static final RegistryObject<CreativeModeTab> MAXIMIZED = CREATIVE_TAB.register("maximized",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRASS_COIN.get()))
                    .title(Component.translatable("creativetab.maximizedtab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BRASS_COIN.get());
                        output.accept(ModItems.POLISHED_NETHER_QUARTZ.get());
                        output.accept(ModItems.NETHER_QUARTZ_SHEET.get());
                        output.accept(ModBlocks.NETHER_QUARTZ_TILES.get());
                        output.accept(ModBlocks.SMALL_NETHER_QUARTZ_TILES.get());
                        output.accept(ModBlocks.INCOMPLETE_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.ROSE_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.NETHER_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.INCOMPLETE_IRON_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.IRON_ROSE_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.IRON_NETHER_QUARTZ_LAMP.get());
                        output.accept(ModBlocks.MAPLE_LOG.get());
                        output.accept(ModBlocks.MAPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MAPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MAPLE_WOOD.get());
                        output.accept(ModBlocks.MAPLE_PLANKS.get());
                        output.accept(ModBlocks.MAPLE_STAIRS.get());
                        output.accept(ModBlocks.MAPLE_SLAB.get());
                        output.accept(ModBlocks.MAPLE_FENCE.get());
                        output.accept(ModBlocks.MAPLE_FENCE_GATE.get());
                        output.accept(ModBlocks.MAPLE_DOOR.get());
                        output.accept(ModBlocks.MAPLE_TRAPDOOR.get());
                        output.accept(ModBlocks.MAPLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MAPLE_BUTTON.get());
                        output.accept(ModBlocks.MAPLE_LEAVES.get());
                        output.accept(ModItems.MAPLE_SIGN.get());
                        output.accept(ModItems.MAPLE_HANGING_SIGN.get());
                        output.accept(ModItems.MAPLE_BOAT.get());
                        output.accept(ModItems.MAPLE_CHEST_BOAT.get());
                        output.accept(ModBlocks.MAPLE_SAPLING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TAB.register(eventBus);
    }
}
