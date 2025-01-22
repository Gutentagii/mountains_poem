package net.mcreator.mountainspoem.procedures;

public class WoodenRingHeadKnifeShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.7) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 1) {
				{
					ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			entity.setAirSupply(0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, x, y, z, 5, 2, 2, 2, 1);
		}
	}
}
