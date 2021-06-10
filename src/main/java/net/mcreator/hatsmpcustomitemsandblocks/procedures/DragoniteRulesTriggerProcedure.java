package net.mcreator.hatsmpcustomitemsandblocks.procedures;

@HatSmpModElements.ModElement.Tag
public class DragoniteRulesTriggerProcedure extends HatSmpModElements.ModElement {

	public DragoniteRulesTriggerProcedure(HatSmpModElements instance) {
		super(instance, 15);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure DragoniteRulesTrigger!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HatSmpMod.LOGGER.warn("Failed to load dependency world for procedure DragoniteRulesTrigger!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		double diamonds = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (((((new ItemStack(DragonarmorItem.helmet, (int) (1)).getItem() == (itemstackiterator).getItem())
							&& (new ItemStack(DragonarmorItem.body, (int) (1)).getItem() == (itemstackiterator).getItem()))
							&& (new ItemStack(DragonarmorItem.legs, (int) (1)).getItem() == (itemstackiterator).getItem()))
							&& (new ItemStack(DragonarmorItem.boots, (int) (1)).getItem() == (itemstackiterator).getItem()))) {
						if (entity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("hat_smp:dragonite_rules"));
							AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					}
				}
			}
		}

	}

}
