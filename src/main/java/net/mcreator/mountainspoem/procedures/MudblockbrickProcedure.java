package net.mcreator.mountainspoem.procedures;

public class MudblockbrickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
