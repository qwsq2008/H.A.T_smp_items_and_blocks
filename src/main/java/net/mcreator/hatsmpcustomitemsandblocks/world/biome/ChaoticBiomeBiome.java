
package net.mcreator.hatsmpcustomitemsandblocks.world.biome;

import net.minecraft.block.material.Material;import java.util.ArrayList;import java.util.HashMap;

@HatSmpModElements.ModElement.Tag public class ChaoticBiomeBiome extends HatSmpModElements.ModElement{

	public static Biome biome;

	public ChaoticBiomeBiome(HatSmpModElements instance) {
		super(instance, 19);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder()
						.setFogColor(-10092544)
						.setWaterColor(-10092442)
						.setWaterFogColor(-13434829)
						.withSkyColor(-10092544)
						.withFoliageColor(-16724788)
						.withGrassColor(-16738048)
                        .setMoodSound(new MoodSoundAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), 6000, 8, 2))
                        .setParticle(new ParticleEffectAmbience(ParticleTypes.SMOKE, 0.005f))
                        .build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(
								new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.DIRT.getDefaultState(),
									Blocks.DIRT.getDefaultState())));


				biomeGenerationSettings.withStructure(StructureFeatures.MINESHAFT);


				biomeGenerationSettings.withStructure(StructureFeatures.VILLAGE_TAIGA);


				biomeGenerationSettings.withStructure(StructureFeatures.JUNGLE_PYRAMID);







					biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
							Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
								new SimpleBlockStateProvider(ChaosWoodLeavesBlock.block.getDefaultState()),
								new SimpleBlockStateProvider(ChaosWoodLogBlock.block.getDefaultState()),
								new JungleFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 2),
								new MegaJungleTrunkPlacer(19, 2, 19),
								new TwoLayerFeature(1, 1, 2)))
.setDecorators(ImmutableList.of(
		CustomLeaveVineTreeDecorator.instance,
		CustomTrunkVineTreeDecorator.instance

		,
		new CustomCocoaTreeDecorator()
))
								.setMaxWaterDepth(5)
							.build())
							.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
							.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1)))
					);

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG)
						.withPlacement(Features.Placements.PATCH_PLACEMENT)
						.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 4))));


				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
								.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(5));




				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
								ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(1));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.SUGAR_CANE_PATCH_CONFIG)
								.withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(7));


						DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
						DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
						DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
						mobSpawnInfo.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 20, 4, 4));
						mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.BLAZE, 1, 1, 2));
						mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 4, 1, 3));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 7, 1, 5));
						mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 8, 4, 4));

				biome = new Biome.Builder()
						.precipitation(Biome.RainType.RAIN)
						.category(Biome.Category.NETHER)
						.depth(1.4000000000000001f)
						.scale(0.5f)
						.temperature(1.6f)
						.downfall(0.3f)
						.setEffects(effects)
						.withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build())
						.build();

				event.getRegistry().register(biome.setRegistryName("hat_smp:chaotic_biome"));
			}
		}

	}

	@Override public void init(FMLCommonSetupEvent event) {
			BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)),
				BiomeDictionary.Type.FOREST
			);
	}

	private static class CustomLeaveVineTreeDecorator extends LeaveVineTreeDecorator {

		public static final CustomLeaveVineTreeDecorator instance = new CustomLeaveVineTreeDecorator();
		public static com.mojang.serialization.Codec<LeaveVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("chaotic_biome_lvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.WEEPING_VINES.getDefaultState(), sbc, mbb);
		}

	}

	private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator {

		public static final CustomTrunkVineTreeDecorator instance = new CustomTrunkVineTreeDecorator();
		public static com.mojang.serialization.Codec<CustomTrunkVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("chaotic_biome_tvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.WEEPING_VINES.getDefaultState(), sbc, mbb);
		}

	}

	private static class CustomCocoaTreeDecorator extends CocoaTreeDecorator {

		public static final CustomCocoaTreeDecorator instance = new CustomCocoaTreeDecorator();
		public static com.mojang.serialization.Codec<CustomCocoaTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("chaotic_biome_ctd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		public CustomCocoaTreeDecorator() {
			super(0.2f);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override public void func_225576_a_(ISeedReader p_225576_1_,Random p_225576_2_,List<BlockPos> p_225576_3_,List<BlockPos> p_225576_4_,Set<BlockPos> p_225576_5_,MutableBoundingBox p_225576_6_){
  if (!(p_225576_2_.nextFloat() >= 0.2F)) {
    int i=p_225576_3_.get(0).getY();
    p_225576_3_.stream().filter((p_236867_1_) -> {
      return p_236867_1_.getY() - i <= 2;
    }
).forEach((p_242865_5_) -> {
      for (      Direction direction : Direction.Plane.HORIZONTAL) {
        if (p_225576_2_.nextFloat() <= 0.25F) {
          Direction direction1=direction.getOpposite();
          BlockPos blockpos=p_242865_5_.add(direction1.getXOffset(),0,direction1.getZOffset());
          if (Feature.isAirAt(p_225576_1_,blockpos)) {
            BlockState blockstate=Blocks.AIR.getDefaultState();
            this.func_227423_a_(p_225576_1_,blockpos,blockstate,p_225576_5_,p_225576_6_);
          }
        }
      }
    }
);
  }
}


	}

}

