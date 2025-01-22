package net.mcreator.mountainspoem.procedures;

public class VinesArmorsXiongJiaShiJianMeiYouXiKeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep((float) 0.7);
		if (entity.isOnFire() && (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) == false) {
			{
				ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
				if (_ist.hurt(4, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			entity.setSecondsOnFire((int) 0.5);
		}
	}
}
