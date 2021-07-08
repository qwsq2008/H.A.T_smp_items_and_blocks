package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hatsmpcustomitemsandblocks.item.LasersItem;
import net.mcreator.hatsmpcustomitemsandblocks.item.IronManHackerProtoTestItem;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Random;
import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class BlasterProcedure extends HatSmpModElements.ModElement {
	public BlasterProcedure(HatSmpModElements instance) {
		super(instance, 65);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure Blaster!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(LasersItem.block, (int) (1)).getItem())
				|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 1) && ((entity instanceof PlayerEntity)
						&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == new ItemStack(IronManHackerProtoTestItem.body, (int) (1)).getItem()))))) {
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LasersItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 5, (float) 10, (int) 20);
				}
			}
		}
	}
}
