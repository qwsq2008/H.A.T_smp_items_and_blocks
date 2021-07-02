
package net.mcreator.hatsmpcustomitemsandblocks.block;

import net.minecraft.block.material.Material;

@HatSmpModElements.ModElement.Tag
public class ChaosWoodWoodBlock extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:chaos_wood_wood")
	public static final Block block = null;

	public ChaosWoodWoodBlock(HatSmpModElements instance) {
		super(instance, 41);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(HATSMPItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.4000000000000004f, 2.3140620096063054f)
					.setLightLevel(s -> 0).harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool());

			setRegistryName("chaos_wood_wood");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 6;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
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
