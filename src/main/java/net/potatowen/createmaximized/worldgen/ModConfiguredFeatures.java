package net.potatowen.createmaximized.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.potatowen.createmaximized.CreateMaximized;
import net.potatowen.createmaximized.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new CherryTrunkPlacer(7, 1, 0, ConstantInt.of(1), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)),

                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CreateMaximized.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}