
package net.mcreator.mountainspoem.world.teleporter;

import com.google.common.collect.ImmutableSet;
import net.mcreator.mountainspoem.init.MountainsPoemModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Function;
import java.util.Optional;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheUnderTeleporter implements ITeleporter {
	public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("the_under_portal", Vec3i::compareTo, 300);
	public static Holder<PoiType> poi = null;

	@SubscribeEvent
	public static void registerPointOfInterest(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.POI_TYPES, registerHelper -> {
			PoiType poiType = new PoiType(ImmutableSet.copyOf(MountainsPoemModBlocks.THE_UNDER_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1);
			registerHelper.register("the_under_portal", poiType);
			poi = ForgeRegistries.POI_TYPES.getHolder(poiType).get();
		});
	}

	private final ServerLevel level;
	private final BlockPos entityEnterPos;

	public TheUnderTeleporter(ServerLevel worldServer, BlockPos entityEnterPos) {
		this.level = worldServer;
		this.entityEnterPos = entityEnterPos;
	}

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */
	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */
	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */
	@Override
	public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel server, float yaw, Function<Boolean, Entity> repositionEntity) {
		PortalInfo portalinfo = getPortalInfo(entity, server);
		if (entity instanceof ServerPlayer player) {
			player.setServerLevel(server);
			server.addDuringPortalTeleport(player);
			player.connection.teleport(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, portalinfo.xRot);
			player.connection.resetPosition();
			CriteriaTriggers.CHANGED_DIMENSION.trigger(player, currentWorld.dimension(), server.dimension());
			return entity;
		} else {
			Entity entityNew = entity.getType().create(server);
			if (entityNew != null) {
				entityNew.restoreFrom(entity);
				entityNew.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, entityNew.getXRot());
				entityNew.setDeltaMovement(portalinfo.speed);
				server.addDuringTeleport(entityNew);
			}
			return entityNew;
		}
	}

	private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
		WorldBorder worldborder = server.getWorldBorder();
		double d0 = DimensionType.getTeleportationScale(entity.level().dimensionType(), server.dimensionType());
		BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
		return this.getExitPortal(entity, blockpos1, worldborder).map(repositioner -> {
			BlockState blockstate = entity.level().getBlockState(this.entityEnterPos);
			Direction.Axis direction$axis;
			Vec3 vector3d;
			if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
				BlockUtil.FoundRectangle teleportationrepositioner$result = BlockUtil.getLargestRectangleAround(this.entityEnterPos, direction$axis, 21, Direction.Axis.Y, 21, pos -> entity.level().getBlockState(pos) == blockstate);
				vector3d = TheUnderPortalShape.getRelativePosition(teleportationrepositioner$result, direction$axis, entity.position(), entity.getDimensions(entity.getPose()));
			} else {
				direction$axis = Direction.Axis.X;
				vector3d = new Vec3(0.5, 0, 0);
			}
			return TheUnderPortalShape.createPortalInfo(server, repositioner, direction$axis, vector3d, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
		}).orElse(new PortalInfo(entity.position(), Vec3.ZERO, entity.getYRot(), entity.getXRot()));
	}

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> optional = this.findPortalAround(pos, false, worldBorder);
		if (entity instanceof ServerPlayer) {
			if (optional.isPresent()) {
				return optional;
			} else {
				Direction.Axis direction$axis = entity.level().getBlockState(this.entityEnterPos).getOptionalValue(NetherPortalBlock.AXIS).orElse(Direction.Axis.X);
				return this.createPortal(pos, direction$axis);
			}
		} else {
			return optional;
		}
	}

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
		BlockState blockstate = this.level.getBlockState(pos);
		return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
	}
}
