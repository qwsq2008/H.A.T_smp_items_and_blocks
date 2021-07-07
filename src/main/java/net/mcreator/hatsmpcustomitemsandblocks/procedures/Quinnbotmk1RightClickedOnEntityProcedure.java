package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hatsmpcustomitemsandblocks.item.QbaicoreItem;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class Quinnbotmk1RightClickedOnEntityProcedure extends HatSmpModElements.ModElement {
	public Quinnbotmk1RightClickedOnEntityProcedure(HatSmpModElements instance) {
		super(instance, 97);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure Quinnbotmk1RightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Quinnbotmk1RightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(QbaicoreItem.block, (int) (1)).getItem())) {
			if ((entity instanceof TameableEntity) && (sourceentity instanceof PlayerEntity)) {
				((TameableEntity) entity).setTamed(true);
				((TameableEntity) entity).setTamedBy((PlayerEntity) sourceentity);
			}
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(QbaicoreItem.block, (int) (1));
				((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) sourceentity).container.func_234641_j_());
			}
		}
	}
}
