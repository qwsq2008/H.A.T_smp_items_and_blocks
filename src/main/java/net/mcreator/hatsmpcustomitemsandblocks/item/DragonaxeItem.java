
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class DragonaxeItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:dragonaxe")
	public static final Item block = null;

	public DragonaxeItem(HatSmpModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 13f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DragonpasteItem.block, (int) (1)));
			}
		}, 1, 1.1f, new Item.Properties().group(HATSMPItemGroup.tab).isImmuneToFire()) {

			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				return new ItemStack(this);
			}

			@Override
			public boolean isRepairable(ItemStack itemstack) {
				return false;
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("dragonaxe"));
	}

}
