
package net.mcreator.mountainspoem.block;

import net.mcreator.mountainspoem.world.teleporter.TheUnderTeleporter;
import net.mcreator.mountainspoem.world.teleporter.TheUnderPortalShape;
import net.mcreator.mountainspoem.init.MountainsPoemModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public class TheUnderPortalBlock extends NetherPortalBlock {
	public TheUnderPortalBlock() {
		super(BlockBehaviour.Properties.of().noCollission().randomTicks().pushReaction(PushReaction.BLOCK).strength(-1.0F).sound(SoundType.GLASS).lightLevel(s -> 0).noLootTable());
	}

	@Override
	public void randomTick(@NotNull BlockState blockstate, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
	}

	public static void portalSpawn(Level world, BlockPos pos) {
		Optional<TheUnderPortalShape> optional = TheUnderPortalShape.findEmptyPortalShape(world, pos, Direction.Axis.X);
		if (optional.isPresent()) {
			optional.get().createPortalBlocks();
		}
	}

	@Override /* failed to load code for net.minecraft.world.level.block.NetherPortalBlock */
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull RandomSource random) {
		for (int i = 0; i < 4; i++) {
			double px = pos.getX() + random.nextFloat();
			double py = pos.getY() + random.nextFloat();
			double pz = pos.getZ() + random.nextFloat();
			double vx = (random.nextFloat() - 0.5) / 2.;
			double vy = (random.nextFloat() - 0.5) / 2.;
			double vz = (random.nextFloat() - 0.5) / 2.;
			int j = random.nextInt(4) - 1;
			if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
				px = pos.getX() + 0.5 + 0.25 * j;
				vx = random.nextFloat() * 2 * j;
			} else {
				pz = pos.getZ() + 0.5 + 0.25 * j;
				vz = random.nextFloat() * 2 * j;
			}
			world.addParticle((SimpleParticleType) (MountainsPoemModParticleTypes.THE_UNDER_WORLD.get()), px, py, pz, vx, vy, vz);
		}
		if (random.nextInt(110) == 0)
			world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(("mountains_poem:the_under_portal_ambient")))), SoundSource.BLOCKS, 0.5f,
					random.nextFloat() * 0.4f + 0.8f);
	}

	@Override
	public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Entity entity) {
		if (entity.canChangeDimensions() && !entity.level().isClientSide()) {
			if (entity.isOnPortalCooldown()) {
				entity.setPortalCooldown();
			} else if (entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mountains_poem:the_under"))) {
				entity.setPortalCooldown();
				teleportToDimension(entity, pos, ResourceKey.create(Registries.DIMENSION, new ResourceLocation("mountains_poem:the_under")));
			} else {
				entity.setPortalCooldown();
				teleportToDimension(entity, pos, Level.OVERWORLD);
			}
		}
	}

	private void teleportToDimension(Entity entity, BlockPos pos, ResourceKey<Level> destinationType) {
		entity.changeDimension(Objects.requireNonNull(Objects.requireNonNull(entity.getServer()).getLevel(destinationType)), new TheUnderTeleporter(entity.getServer().getLevel(destinationType), pos));
	}
}
