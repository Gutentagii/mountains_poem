package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.init.MountainsPoemModMobEffects;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;

public class BoshileatherWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.BOYI_LEATHER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MountainsPoemModItems.BOYI_LEATHER.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MountainsPoemModMobEffects.BOYI_BLESSING.get(), 200, 2));
		}
	}
}
