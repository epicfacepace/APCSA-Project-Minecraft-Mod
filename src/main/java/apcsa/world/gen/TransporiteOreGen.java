package apcsa.world.gen;

import apcsa.block.ModBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TransporiteOreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == Biomes.END_BARRENS || biome == Biomes.END_MIDLANDS || biome == Biomes.END_HIGHLANDS) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(5, 5, 5, 205));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType
                                .create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)), ModBlock.TRANSPORITE_ORE.getDefaultState(), 10))
                        .withPlacement(customConfig));
            }
        }
    }
}
