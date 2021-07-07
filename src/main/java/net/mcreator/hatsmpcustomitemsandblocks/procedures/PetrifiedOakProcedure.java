package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class PetrifiedOakProcedure extends HatSmpModElements.ModElement {

	public PetrifiedOakProcedure(HatSmpModElements instance) {
		super(instance, 43);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure PetrifiedOak!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Blocks.PETRIFIED_OAK_SLAB, (int) (1));
			_setstack.setCount((int) 64);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}

	}

}
