package com.xiris.mountainspoem.block;

import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModParticleTypes;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import com.xiris.mountainspoem.world.teleporter.TheUnderPortalShape;
import com.xiris.mountainspoem.world.teleporter.TheUnderTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.Optional;

public class TheUnderPortalBlock extends NetherPortalBlock {
    private static final ResourceKey<Level> THE_UNDER = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath("mountains_poem", "the_under")
    );

    public TheUnderPortalBlock() {
        super(BlockBehaviour.Properties.of()
                .noCollission()
                .randomTicks()
                .pushReaction(PushReaction.BLOCK)
                .strength(-1.0F)
                .sound(SoundType.GLASS)
                .lightLevel(s -> 0)
                .noLootTable());
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Keep the_under portal blocks from spawning vanilla nether mobs.
    }

    public static boolean portalSpawn(Level level, BlockPos pos) {
        Optional<TheUnderPortalShape> optional = TheUnderPortalShape.findEmptyPortalShape(level, pos, Direction.Axis.X);
        if (optional.isEmpty()) {
            return false;
        }
        optional.get().createPortalBlocks();
        return true;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        Direction.Axis changedAxis = direction.getAxis();
        Direction.Axis portalAxis = state.getValue(AXIS);
        boolean horizontalMismatch = portalAxis != changedAxis && changedAxis.isHorizontal();
        if (!horizontalMismatch && !neighborState.is(this)
                && !(new TheUnderPortalShape(level, pos, portalAxis)).isComplete()) {
            return Blocks.AIR.defaultBlockState();
        }
        // Do not call NetherPortalBlock.updateShape here: it checks the vanilla
        // obsidian/nether_portal shape and would delete our portal blocks.
        return state;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        for (int i = 0; i < 4; i++) {
            double px = pos.getX() + random.nextFloat();
            double py = pos.getY() + random.nextFloat();
            double pz = pos.getZ() + random.nextFloat();
            double vx = (random.nextFloat() - 0.5D) / 2.0D;
            double vy = (random.nextFloat() - 0.5D) / 2.0D;
            double vz = (random.nextFloat() - 0.5D) / 2.0D;
            int j = random.nextInt(4) - 1;
            if (level.getBlockState(pos.west()).getBlock() != this
                    && level.getBlockState(pos.east()).getBlock() != this) {
                px = pos.getX() + 0.5D + 0.25D * j;
                vx = random.nextFloat() * 2.0D * j;
            } else {
                pz = pos.getZ() + 0.5D + 0.25D * j;
                vz = random.nextFloat() * 2.0D * j;
            }
            level.addParticle(MountainsPoemModParticleTypes.THE_UNDER_WORLD.get(), px, py, pz, vx, vy, vz);
        }
        if (random.nextInt(110) == 0) {
            level.playSound(null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(
                            ResourceLocation.fromNamespaceAndPath("minecraft", "block.portal.ambient"))),
                    SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide || !entity.canChangeDimensions()) {
            return;
        }
        if (entity.isOnPortalCooldown()) {
            entity.setPortalCooldown();
            return;
        }

        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        ResourceKey<Level> destinationKey = serverLevel.dimension() == THE_UNDER
                ? Level.OVERWORLD
                : THE_UNDER;
        ServerLevel destination = serverLevel.getServer().getLevel(destinationKey);
        if (destination == null) {
            return;
        }

        // Nether-portal-like behaviour: one portal pair, linked by the
        // destination portal search/creation in TheUnderTeleporter.
        entity.setPortalCooldown();
        entity.changeDimension(destination, new TheUnderTeleporter(destination, pos));
    }
}
