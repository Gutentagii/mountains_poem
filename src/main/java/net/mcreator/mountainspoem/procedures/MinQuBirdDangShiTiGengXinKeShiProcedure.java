package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.MinQuBirdEntity;

public class MinQuBirdDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals("\u041F\u0440\u0438\u0437\u043C\u0430\u0440\u0438\u043D") || (entity.getDisplayName().getString()).equals("Prizmarin")
				|| (entity.getDisplayName().getString()).equals("\u043F\u0440\u0438\u0437\u043C\u0430\u0440\u0438\u043D") || (entity.getDisplayName().getString()).equals("prizmarin")) {
			if (entity instanceof MinQuBirdEntity animatable)
				animatable.setTexture("mingqu2");
		} else {
			if (entity instanceof MinQuBirdEntity animatable)
				animatable.setTexture("mingqu");
		}
	}
}
