package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.LeiEntity;

public class LeiDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LeiEntity animatable ? animatable.getTexture() : "null").equals("lei_lion_2")) {
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
		}
	}
}
