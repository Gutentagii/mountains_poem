package net.mcreator.mountainspoem.procedures;

public class HuaSnakeDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
			_entity.setTarget(_ent);
	}
}
