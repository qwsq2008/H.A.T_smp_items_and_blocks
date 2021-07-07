package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class IronLaunchProcedure extends HatSmpModElements.ModElement {

	public IronLaunchProcedure(HatSmpModElements instance) {
		super(instance, 60);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure IronLaunch!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double diamonds = 0;
		if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 1) && (entity instanceof PlayerEntity))
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronManHackerProtoTestItem.boots, (int) (1)))
						: false))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 1, (int) 5, (true), (false)));
		}

	}

}
