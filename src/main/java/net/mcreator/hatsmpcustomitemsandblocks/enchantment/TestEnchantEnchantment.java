
package net.mcreator.hatsmpcustomitemsandblocks.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.hatsmpcustomitemsandblocks.item.DragonarmorItem;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;

@HatSmpModElements.ModElement.Tag
public class TestEnchantEnchantment extends HatSmpModElements.ModElement {
	@ObjectHolder("hat_smp:test_enchant")
	public static final Enchantment enchantment = null;
	public TestEnchantEnchantment(HatSmpModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("test_enchant"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR, slots);
		}

		@Override
		public int getMinLevel() {
			return 29;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 2;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(DragonarmorItem.helmet, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DragonarmorItem.body, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DragonarmorItem.legs, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DragonarmorItem.boots, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
