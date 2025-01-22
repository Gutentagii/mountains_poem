package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.HuHorseEntity;

public class HuHorseYouJiShiTiShiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_APPLE) == false) {
			if (sourceentity.isShiftKeyDown()) {
				if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) == false) {
					if (sourceentity instanceof Player _player)
						_player.closeContainer();
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt5 && _livEnt5.isBaby()) == false && ((entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_iron")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_saddle") || (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_gold")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_diamond")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_netherite")
						|| (entity instanceof HuHorseEntity animatable ? animatable.getTexture() : "null").equals("water_horse_blood_copper"))) {
					sourceentity.startRiding(entity);
				}
			}
		}
	}
}
