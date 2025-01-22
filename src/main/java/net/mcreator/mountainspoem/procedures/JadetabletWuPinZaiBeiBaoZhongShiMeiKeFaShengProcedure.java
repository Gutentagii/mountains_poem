package net.mcreator.mountainspoem.procedures;

public class JadetabletWuPinZaiBeiBaoZhongShiMeiKeFaShengProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getMaxDamage() <= itemstack.getDamageValue()) {
			itemstack.shrink(1);
		}
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mountains_poem:lucky_tool"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
