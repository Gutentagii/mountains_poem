package net.mcreator.mountainspoem.procedures;

import net.mcreator.mountainspoem.entity.ZuoCowEntity;

public class ZuoCowShiTiChuShiShengChengShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("mountains_poem:is_taiga")))) {
			if (entity instanceof ZuoCowEntity animatable)
				animatable.setTexture("zuo_cow_black");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_savanna")))) {
			if (entity instanceof ZuoCowEntity animatable)
				animatable.setTexture("zuo_cow_flower");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_hill")))) {
			if (entity instanceof ZuoCowEntity animatable)
				animatable.setTexture("zuo_cow_brown");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mountains_poem:pan_forest"))) {
			if (entity instanceof ZuoCowEntity animatable)
				animatable.setTexture("zuo_cow_brown");
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_snowy")))) {
			if (entity instanceof ZuoCowEntity animatable)
				animatable.setTexture("zuo_cow_white");
		}
	}
}
