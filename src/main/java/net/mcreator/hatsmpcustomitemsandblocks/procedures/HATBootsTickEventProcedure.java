package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class HATBootsTickEventProcedure extends HatSmpModElements.ModElement {
	public HATBootsTickEventProcedure(HatSmpModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure HATBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 100, (int) 4, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 100, (int) 1, (false), (false)));
	}
}
