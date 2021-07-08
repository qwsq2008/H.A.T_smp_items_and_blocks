package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class BlastBreakBlockProcedure extends HatSmpModElements.ModElement {
	public BlastBreakBlockProcedure(HatSmpModElements instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HatSmpMod.LOGGER.warn("Failed to load dependency x for procedure BlastBreakBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HatSmpMod.LOGGER.warn("Failed to load dependency y for procedure BlastBreakBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HatSmpMod.LOGGER.warn("Failed to load dependency z for procedure BlastBreakBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HatSmpMod.LOGGER.warn("Failed to load dependency world for procedure BlastBreakBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getHarvestLevel()) <= 1)) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
	}
}
