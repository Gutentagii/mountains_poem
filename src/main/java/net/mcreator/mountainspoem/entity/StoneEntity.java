
package net.mcreator.mountainspoem.entity;

import net.mcreator.mountainspoem.procedures.StoneDanSheWuJiZhongShiTiShiProcedure;
import net.mcreator.mountainspoem.procedures.StoneDanSheWuJiZhongFangKuaiShiProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class StoneEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.STONE);

	public StoneEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(MountainsPoemModEntities.STONE.get(), world);
	}

	public StoneEntity(EntityType<? extends StoneEntity> type, Level world) {
		super(type, world);
	}

	public StoneEntity(EntityType<? extends StoneEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public StoneEntity(EntityType<? extends StoneEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		StoneDanSheWuJiZhongShiTiShiProcedure.execute(this.level(), entityHitResult.getEntity());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		StoneDanSheWuJiZhongFangKuaiShiProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static StoneEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 0.6f, 0, 1);
	}

	public static StoneEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 0.6f, 0, 1);
	}

	public static StoneEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		StoneEntity entityarrow = new StoneEntity(MountainsPoemModEntities.STONE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.fall")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static StoneEntity shoot(LivingEntity entity, LivingEntity target) {
		StoneEntity entityarrow = new StoneEntity(MountainsPoemModEntities.STONE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.6f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(true);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.fall")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
