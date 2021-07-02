package net.mcreator.hatsmpcustomitemsandblocks.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

import java.util.Map;

@HatSmpModElements.ModElement.Tag
public class CreateCommandExecutedProcedure extends HatSmpModElements.ModElement {
	public CreateCommandExecutedProcedure(HatSmpModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HatSmpMod.LOGGER.warn("Failed to load dependency entity for procedure CreateCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (_ent instanceof PlayerEntity) {
				Scoreboard _sc = ((PlayerEntity) _ent).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("create");
				if (_so == null) {
					_so = _sc.addObjective("create", ScoreCriteria.DUMMY, new StringTextComponent("create"), ScoreCriteria.RenderType.INTEGER);
				}
				Score _scr = _sc.getOrCreateScore(((PlayerEntity) _ent).getScoreboardName(), _so);
				_scr.setScorePoints((int) 1);
			}
		}
	}
}
