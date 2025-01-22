package net.mcreator.mountainspoem.procedures;

public class PestilenceDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep((float) (entity.getStepHeight() - 0.5));
		entity.setAirSupply(0);
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
	}
}
