
package net.mcreator.hatsmpcustomitemsandblocks.item;

@HatSmpModElements.ModElement.Tag
public class SwordshardItem extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:swordshard")
	public static final Item block = null;

	public SwordshardItem(HatSmpModElements instance) {
		super(instance, 28);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("swordshard");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
