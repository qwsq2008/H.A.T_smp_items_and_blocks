
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class DragonhoeItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:dragonhoe")
	public static final Item block = null;

	public DragonhoeItem(HatSmpModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 15;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DragonpasteItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(HATSMPItemGroup.tab).isImmuneToFire()) {

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("dragonhoe"));
	}

}
