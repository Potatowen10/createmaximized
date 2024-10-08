package net.potatowen.createmaximized.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potatowen.createmaximized.CreateMaximized;
import net.potatowen.createmaximized.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateMaximized.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        signBlock(((StandingSignBlock) ModBlocks.MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get()),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));

        hangingSignBlock(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));

    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
