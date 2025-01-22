package net.mcreator.mountainspoem.procedures;

public class ChaosXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.clearFire();
		{
			Entity _ent = entity;
			_ent.setYRot(0);
			_ent.setXRot(40);
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		entity.setSecondsOnFire(1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 3, 2, false, false));
	}
}
