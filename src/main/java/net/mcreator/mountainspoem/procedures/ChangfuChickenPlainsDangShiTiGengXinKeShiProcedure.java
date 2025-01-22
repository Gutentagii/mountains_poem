package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ChangfuChickenPlainsEntity;

public class ChangfuChickenPlainsDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals("IKUN")) {
			if (entity instanceof ChangfuChickenPlainsEntity animatable)
				animatable.setTexture("changfu_ikun");
		} else {
			if (entity instanceof ChangfuChickenPlainsEntity animatable)
				animatable.setTexture("changfu_chicken");
		}
	}
}
