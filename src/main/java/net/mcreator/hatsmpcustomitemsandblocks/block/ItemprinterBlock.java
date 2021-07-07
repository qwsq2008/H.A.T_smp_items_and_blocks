
package net.mcreator.hatsmpcustomitemsandblocks.block;

import net.minecraft.block.material.Material;

@HatSmpModElements.ModElement.Tag
public class ItemprinterBlock extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:itemprinter")
	public static final Block block = null;

	public ItemprinterBlock(HatSmpModElements instance) {
		super(instance, 62);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(HATSMPItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("itemprinter");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
