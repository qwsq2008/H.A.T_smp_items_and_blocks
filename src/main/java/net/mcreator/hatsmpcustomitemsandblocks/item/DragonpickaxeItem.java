
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class DragonpickaxeItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:dragonpickaxe")
	public static final Item block = null;

	public DragonpickaxeItem(HatSmpModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 17;
			}

			public int getEnchantability() {
				return 7;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DragonpasteItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(HATSMPItemGroup.tab).isImmuneToFire()) {

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("dragonpickaxe"));
	}

}
