
package net.mcreator.mountainspoem.entity;

import net.mcreator.mountainspoem.procedures.PlagueBallDanSheWuJiZhongShiTiShiProcedure;
import net.mcreator.mountainspoem.procedures.PlagueBallDanSheWuJiZhongFangKuaiShiProcedure;
import net.mcreator.mountainspoem.procedures.PlagueBallDanSheWuFeiXingShiMeiKeFaShengProcedure;
import net.mcreator.mountainspoem.init.MountainsPoemModItems;
import net.mcreator.mountainspoem.init.MountainsPoemModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PlagueBallEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(MountainsPoemModItems.PLAGUE_HORN.get());

	public PlagueBallEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(MountainsPoemModEntities.PLAGUE_BALL.get(), world);
	}

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, Level world) {
		super(type, world);
	}

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PlagueBallEntity(EntityType<? extends PlagueBallEntity> type, LivingEntity entity, Level world) {
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
		PlagueBallDanSheWuJiZhongShiTiShiProcedure.execute(entityHitResult.getEntity());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		PlagueBallDanSheWuJiZhongFangKuaiShiProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		PlagueBallDanSheWuFeiXingShiMeiKeFaShengProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1.8f, 5.1, 10);
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 1.8f, 5.1, 10);
	}

	public static PlagueBallEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PlagueBallEntity entityarrow = new PlagueBallEntity(MountainsPoemModEntities.PLAGUE_BALL.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:fei_bull")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static PlagueBallEntity shoot(LivingEntity entity, LivingEntity target) {
		PlagueBallEntity entityarrow = new PlagueBallEntity(MountainsPoemModEntities.PLAGUE_BALL.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1.8f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5.1);
		entityarrow.setKnockback(10);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mountains_poem:fei_bull")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
