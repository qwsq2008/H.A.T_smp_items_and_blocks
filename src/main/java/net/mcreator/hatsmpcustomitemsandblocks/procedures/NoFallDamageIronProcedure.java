package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class NoFallDamageIronProcedure extends HatSmpModElements.ModElement {

	public NoFallDamageIronProcedure(HatSmpModElements instance) {
		super(instance, 63);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure NoFallDamageIron!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronManHackerProtoTestItem.helmet, (int) (1)))
				: false)
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronManHackerProtoTestItem.body, (int) (1)))
						: false))
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronManHackerProtoTestItem.legs, (int) (1)))
						: false))
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronManHackerProtoTestItem.boots, (int) (1)))
						: false))
				&& (entity instanceof PlayerEntity))
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 4))) {
			entity.setCustomName(new StringTextComponent("You Know Who I Am"));
		}

	}

}
