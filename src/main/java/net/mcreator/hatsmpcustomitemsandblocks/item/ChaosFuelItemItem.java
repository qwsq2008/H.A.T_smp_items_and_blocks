
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class ChaosFuelItemItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:chaos_fuel_item")
	public static final Item block = null;

	public ChaosFuelItemItem(HatSmpModElements instance) {
		super(instance, 30);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(HATSMPItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("chaos_fuel_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Chaos Fuel... Literally."));
		}

	}

}
