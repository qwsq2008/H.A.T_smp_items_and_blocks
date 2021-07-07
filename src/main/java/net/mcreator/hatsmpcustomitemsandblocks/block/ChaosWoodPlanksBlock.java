
package net.mcreator.hatsmpcustomitemsandblocks.block;

import net.minecraft.block.material.Material;

@HatSmpModElements.ModElement.Tag
public class ChaosWoodPlanksBlock extends HatSmpModElements.ModElement {

	@ObjectHolder("hat_smp:chaos_wood_planks")
	public static final Block block = null;

	public ChaosWoodPlanksBlock(HatSmpModElements instance) {
		super(instance, 43);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(HATSMPItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.4000000000000004f, 3.4710930144094583f)
					.setLightLevel(s -> 0).harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool());

			setRegistryName("chaos_wood_planks");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 6;
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
