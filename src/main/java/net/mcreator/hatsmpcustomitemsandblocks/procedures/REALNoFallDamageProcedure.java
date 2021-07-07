package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class REALNoFallDamageProcedure extends HatSmpModElements.ModElement {

	public REALNoFallDamageProcedure(HatSmpModElements instance) {
		super(instance, 64);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure REALNoFallDamage!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.fallDistance = (float) (0);

	}

}
