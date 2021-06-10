
package net.mcreator.hatsmpcustomitemsandblocks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.hatsmpcustomitemsandblocks.itemgroup.HATSMPItemGroup;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;

import java.util.List;

@HatSmpModElements.ModElement.Tag
public class DragonBowlItem extends HatSmpModElements.ModElement {
	@ObjectHolder("hat_smp:dragon_bowl")
	public static final Item block = null;
	public DragonBowlItem(HatSmpModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(HATSMPItemGroup.tab).maxStackSize(16).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("dragon_bowl");
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
			list.add(new StringTextComponent("A bowl will power potential... what foods could this make?"));
		}
	}
}
