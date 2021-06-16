package net.mcreator.hatsmpcustomitemsandblocks.world;

import net.mcreator.hatsmpcustomitemsandblocks.HatSmpMod;

@HatSmpModElements.ModElement.Tag
public class ArmorcorruptionGameRule extends HatSmpModElements.ModElement {

	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("armorcorruption", GameRules.Category.PLAYER,
			create(false));

	public ArmorcorruptionGameRule(HatSmpModElements instance) {
		super(instance, 18);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
