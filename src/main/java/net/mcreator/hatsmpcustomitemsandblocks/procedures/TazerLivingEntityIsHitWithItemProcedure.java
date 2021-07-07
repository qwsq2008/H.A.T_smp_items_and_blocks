package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class TazerLivingEntityIsHitWithItemProcedure extends HatSmpModElements.ModElement {

	public TazerLivingEntityIsHitWithItemProcedure(HatSmpModElements instance) {
		super(instance, 68);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure TazerLivingEntityIsHitWithItem!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60000, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60000, (int) 6, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60000, (int) 1, (false), (false)));

	}

}
