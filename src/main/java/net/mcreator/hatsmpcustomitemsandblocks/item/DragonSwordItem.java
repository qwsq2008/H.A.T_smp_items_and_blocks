
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class DragonSwordItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:dragon_sword")
	public static final Item block = null;

	public DragonSwordItem(HatSmpModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 5;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DragonpasteItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(HATSMPItemGroup.tab).isImmuneToFire()) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("A powerful sword..."));
				list.add(new StringTextComponent("seems like it can hold a lot of power."));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("dragon_sword"));
	}

}
