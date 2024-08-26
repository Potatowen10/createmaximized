package net.potatowen.createmaximized.datagen;

import net.potatowen.createmaximized.CreateMaximized;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.potatowen.createmaximized.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateMaximized.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MAPLE_SIGN);
        simpleItem(ModItems.MAPLE_HANGING_SIGN);
        simpleItem(ModItems.MAPLE_BOAT);
        simpleItem(ModItems.MAPLE_CHEST_BOAT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMaximized.MODID,"item/" + item.getId().getPath()));
    }
}