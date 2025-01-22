package net.mcreator.mountainspoem.procedures;

public class ChangfudedonghuawwengjianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
	}
}
