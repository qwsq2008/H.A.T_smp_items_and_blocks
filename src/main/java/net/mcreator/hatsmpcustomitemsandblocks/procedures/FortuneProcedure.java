package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.hatsmpcustomitemsandblocks.item.ChaosFuelItemItem;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class FortuneProcedure extends HatSmpModElements.ModElement {
	public FortuneProcedure(HatSmpModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure Fortune!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HatSmpMod.LOGGER.warn("Failed to load dependency x for procedure Fortune!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HatSmpMod.LOGGER.warn("Failed to load dependency y for procedure Fortune!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HatSmpMod.LOGGER.warn("Failed to load dependency z for procedure Fortune!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HatSmpMod.LOGGER.warn("Failed to load dependency world for procedure Fortune!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 0)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 2000);
				world.addEntity(entityToSpawn);
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 2000);
				world.addEntity(entityToSpawn);
			}
			if ((Math.random() < 0.33)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 2000);
					world.addEntity(entityToSpawn);
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
			if ((Math.random() < 0.5)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 2000);
					world.addEntity(entityToSpawn);
				}
			} else {
				if ((Math.random() < 0.25)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
				} else if ((Math.random() < 0.25)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
			if ((Math.random() < 0.4)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 2000);
					world.addEntity(entityToSpawn);
				}
			} else {
				if ((Math.random() < 0.2)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
				} else if ((Math.random() < 0.2)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
				} else if ((Math.random() < 0.2)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChaosFuelItemItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 2000);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
