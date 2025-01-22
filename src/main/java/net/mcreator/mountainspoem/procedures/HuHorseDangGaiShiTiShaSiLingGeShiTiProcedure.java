package net.mcreator.mountainspoem.procedures;

public class HuHorseDangGaiShiTiShaSiLingGeShiTiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if ((entity.getControllingPassenger()) instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:adventure/kill_a_mob"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}
