package net.mcreator.mountainspoem.procedures;

public class LushuLeatherGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getMaxDamage() < itemstack.getDamageValue()) {
			itemstack.shrink(1);
		}
	}
}
