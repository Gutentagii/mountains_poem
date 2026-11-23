package com.xiris.mountainspoem.event;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.block.TheUnderPortalBlock;
import com.xiris.mountainspoem.init.*;
import com.xiris.mountainspoem.util.BlockStateUtil;
import com.xiris.mountainspoem.world.inventory.ZunBottlesMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = "mountains_poem", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvents {

    //斧
    private static boolean Axe(Item item) {
        return item == Items.WOODEN_AXE ||
                item == Items.STONE_AXE ||
                item == Items.IRON_AXE ||
                item == Items.GOLDEN_AXE ||
                item == Items.DIAMOND_AXE ||
                item == Items.NETHERITE_AXE;
    }

    private static Block HaveBlock(Block original) {
        if (original == MountainsPoemModBlocks.JIANG_LOG.get()) return MountainsPoemModBlocks.STRIPPED_JIANG_LOG.get();
        if (original == MountainsPoemModBlocks.JIANG_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_JIANG_WOOD.get();
        if (original == MountainsPoemModBlocks.YAN_LOG.get()) return MountainsPoemModBlocks.STRIPPED_YAN_LOG.get();
        if (original == MountainsPoemModBlocks.YAN_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_YAN_WOOD.get();
        if (original == MountainsPoemModBlocks.HUANG_GUAN_LOG.get()) return MountainsPoemModBlocks.STRIPPED_HUANG_GUAN_LOG.get();
        if (original == MountainsPoemModBlocks.HUANG_GUAN_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_HUANG_GUAN_WOOD.get();
        if (original == MountainsPoemModBlocks.SHATANG_LOG.get()) return MountainsPoemModBlocks.STRIPPED_SHATANG_LOG.get();
        if (original == MountainsPoemModBlocks.SHATANG_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_SHA_TANG_WOOD.get();
        if (original == MountainsPoemModBlocks.PAN_LOG.get()) return MountainsPoemModBlocks.STRIPPED_PAN_LOG.get();
        if (original == MountainsPoemModBlocks.PAN_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_PAN_WOOD.get();
        if (original == MountainsPoemModBlocks.PEACH_BLOSSOM_LOG.get()) return MountainsPoemModBlocks.STRIPPED_PEACH_BLOSSOM_LOG.get();
        if (original == MountainsPoemModBlocks.PEACH_BLOSSOM_WOOD.get()) return MountainsPoemModBlocks.STRIPPED_PEACH_BLOSSOM_WOOD.get();
        return null;
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        ItemStack stack = player.getMainHandItem();
        Block clickedBlock = world.getBlockState(pos).getBlock();

        if (Axe(stack.getItem())) {
            Block strippedBlock = HaveBlock(clickedBlock);
            if (strippedBlock != null) {
                world.setBlockAndUpdate(pos, strippedBlock.withPropertiesOf(world.getBlockState(pos)));
                player.swing(InteractionHand.MAIN_HAND);

                if (!player.isCreative()) {
                    if (stack.hurt(1, RandomSource.create(), null)) {
                        stack.shrink(1);
                        stack.setDamageValue(0);
                    }
                }
                event.setCanceled(true);
                return;
            }
        }

        if (world.getBlockState(pos).is(BlockTags.CONVERTABLE_TO_MUD) && stack.getItem() == MountainsPoemModItems.WATER_COPPER_JUE.get()) {
            stack.shrink(1);
            world.setBlock(pos, BlockStateUtil.copyWithBlock(world.getBlockState(pos), Blocks.MUD), 3);
            player.getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.COPPER_JUE.get()));
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
            return;
        }

        if (stack.getItem() == MountainsPoemModItems.THE_UNDER.get()) {
            BlockPos placePos = pos.relative(event.getFace());
            TheUnderPortalBlock.portalSpawn(world, placePos);
            Vec3 vec3 = Vec3.atCenterOf(placePos);
            player.swing(InteractionHand.MAIN_HAND, true);

            if (world instanceof ServerLevel _level) {
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_P.get(), vec3.x, vec3.y, vec3.z, 5, 1, 1, 1, 1);
                _level.sendParticles(MountainsPoemModParticleTypes.THE_UNDER_WORLD.get(), vec3.x, vec3.y, vec3.z, 5, 1, 1, 1, 1);
            }

            world.playSound(null, vec3.x, vec3.y, vec3.z, MountainsPoemModSounds.THE_UNDER_PORTAL_AMBIENT.get(), player.getSoundSource(), 1, 1);
            event.setCanceled(true);
            return;
        }

        if (stack.getItem() instanceof HoeItem && world.getBlockState(pos).is(MountainsPoemModBlocks.LUSH_DIRT.get())) {
            world.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
            if (world instanceof ServerLevel _level)
                _level.addFreshEntity(new ItemEntity(_level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.WHEAT_SEEDS)));
            if (!player.isCreative()) {
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
            }
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
            return;
        }

        if (stack.getItem() instanceof HoeItem && world.getBlockState(pos).is(MountainsPoemModBlocks.LUSH_GRASS_BLOCK.get())) {
            world.setBlock(pos, MountainsPoemModBlocks.LUSH_DIRT.get().defaultBlockState(), 3);
            if (!player.isCreative()) {
                if (stack.hurt(1, RandomSource.create(), null)) {
                    stack.shrink(1);
                    stack.setDamageValue(0);
                }
            }
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
            return;
        }

        if ((stack.getItem() instanceof ShovelItem || stack.getItem() instanceof HoeItem)) {
            if (world.getBlockState(pos).is(MountainsPoemModBlocks.DIRT_WITH_RONG_GRASS_TUBERS.get())) {
                world.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
                if (world instanceof ServerLevel serverWorld) {
                    LootParams params = new LootParams.Builder(serverWorld)
                            .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                            .withParameter(LootContextParams.BLOCK_STATE, world.getBlockState(pos))
                            .create(LootContextParamSets.BLOCK);
                    serverWorld.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "blocks/dirt_with_rong_grass_tubers"))
                            .getRandomItems(params).forEach(s -> serverWorld.addFreshEntity(new ItemEntity(serverWorld, pos.getX(), pos.getY(), pos.getZ(), s)));
                }
                if (!player.isCreative()) {
                    if (stack.hurt(1, RandomSource.create(), null)) {
                        stack.shrink(1);
                        stack.setDamageValue(0);
                    }
                }
                player.swing(InteractionHand.MAIN_HAND, true);
                event.setCanceled(true);
                return;
            }
        }

        if (world.getBlockState(pos).is(MountainsPoemModBlocks.FRUITFUL_YAN_LEAVES.get())) {
            world.setBlock(pos, MountainsPoemModBlocks.YAN_LEAVES.get().defaultBlockState(), 3);
            if (world instanceof ServerLevel serverWorld) {
                LootParams params = new LootParams.Builder(serverWorld)
                        .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .withParameter(LootContextParams.BLOCK_STATE, world.getBlockState(pos))
                        .withParameter(LootContextParams.TOOL, player.getMainHandItem())
                        .create(LootContextParamSets.BLOCK);
                serverWorld.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "blocks/fruitful_yan_leaves"))
                        .getRandomItems(params).forEach(s -> serverWorld.addFreshEntity(new ItemEntity(serverWorld, pos.getX(), pos.getY(), pos.getZ(), s)));
            }
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
            return;
        }

        if (world.getBlockState(pos).is(MountainsPoemModBlocks.FRUITFUL_SHATANG_LEAVES.get())) {
            world.setBlock(pos, MountainsPoemModBlocks.SHATANG_LEAVES.get().defaultBlockState(), 3);
            if (world instanceof ServerLevel serverWorld) {
                LootParams params = new LootParams.Builder(serverWorld)
                        .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .withParameter(LootContextParams.BLOCK_STATE, world.getBlockState(pos))
                        .create(LootContextParamSets.BLOCK);
                serverWorld.getServer().getLootData().getLootTable(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "blocks/fruitful_shatang_leaves"))
                        .getRandomItems(params).forEach(s -> serverWorld.addFreshEntity(new ItemEntity(serverWorld, pos.getX(), pos.getY(), pos.getZ(), s)));
            }
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
            return;
        }

        if (!player.isShiftKeyDown() && world.getBlockState(pos).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "zun_bottle"))) && player instanceof ServerPlayer) {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("ZunBottles");
                }
                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new ZunBottlesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                }
            });
            player.swing(InteractionHand.MAIN_HAND, true);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource damagesource = event.getSource();

        if (EnchantmentHelper.getTagEnchantmentLevel(MountainsPoemModEnchantments.CONTROL_OF_WATER_HORSES.get(),
                ((damagesource.getEntity() instanceof LivingEntity _livEnt) ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
            Vec3 _center = entity.position();
            List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15), e -> true)
                    .stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound)
                if ((entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == damagesource.getEntity()
                        && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "water_horse"))))
                    if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "water_horse"))))
                        if (entityiterator instanceof Mob _entity)
                            _entity.setTarget(entity);
        }
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level world = player.level();
        ItemStack stack = player.getMainHandItem();

        if (stack.getItem() == MountainsPoemModItems.THE_UNDER.get()) {
            Vec3 vec3 = player.getEyePosition(1.0F).add(player.getLookAngle().scale(1.5D));
            player.swing(InteractionHand.MAIN_HAND, true);

            if (world instanceof ServerLevel _level) {
                _level.sendParticles(MountainsPoemModParticleTypes.SACRIFICE_P.get(), vec3.x, vec3.y, vec3.z, 5, 1, 1, 1, 1);
                _level.sendParticles(MountainsPoemModParticleTypes.THE_UNDER_WORLD.get(), vec3.x, vec3.y, vec3.z, 5, 1, 1, 1, 1);

                Entity entity = MountainsPoemModEntities.SOUL_SHARD.get().create(_level);
                if (entity != null) {
                    entity.moveTo(vec3.x, vec3.y, vec3.z, 0, 0);
                    _level.addFreshEntity(entity);
                }
            }

            world.playSound(null, vec3.x, vec3.y, vec3.z,
                    MountainsPoemModSounds.THE_UNDER_PORTAL_AMBIENT.get(),
                    player.getSoundSource(), 1, 1);

            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onInteractEntity(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity entity = event.getTarget();
        Level world = player.level();
        Vec3 pos = entity.position();

        Map<Predicate<EntityType<?>>, Item> itemMap = new LinkedHashMap<>();
        itemMap.put(type -> type.is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("forge", "chicken"))), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_CHICKEN.get());
        itemMap.put(type -> type.is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("forge", "piglin"))), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_PIGLIN.get());
        itemMap.put(type -> type.is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("forge", "ender_dragon"))), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_ENDER_DRAGON.get());
        itemMap.put(type -> type == MountainsPoemModEntities.LEI.get(), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_LEI.get());
        itemMap.put(type -> type == MountainsPoemModEntities.LONG_CHI.get(), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_LONG_CHI.get());
        itemMap.put(type -> type == MountainsPoemModEntities.ZHENG.get(), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_ZHENG.get());
        itemMap.put(type -> type == MountainsPoemModEntities.ZHI.get(), MountainsPoemModItems.ENGRAVED_XUAN_SHELLS_ZHI.get());

        if (player.getMainHandItem().is(MountainsPoemModItems.TEETH_GRAVER.get()) && player.getOffhandItem().is(MountainsPoemModItems.XUAN_SHELLS.get())) {
            for (Map.Entry<Predicate<EntityType<?>>, Item> entry : itemMap.entrySet()) {
                if (entry.getKey().test(entity.getType())) {
                    player.getOffhandItem().shrink(1);
                    if (world instanceof ServerLevel _level)
                        _level.addFreshEntity(new ItemEntity(_level, pos.x, pos.y, pos.z, new ItemStack(entry.getValue())));
                    world.playSound(null, pos.x, pos.y, pos.z, MountainsPoemModSounds.CARVED_SHELLS.get(), player.getSoundSource(), 1, 1);
                    if (!player.isCreative()) {
                        ItemStack stack = player.getMainHandItem();
                        if (stack.hurt(1, RandomSource.create(), null)) {
                            stack.shrink(1);
                            stack.setDamageValue(0);
                        }
                    }
                    player.swing(InteractionHand.MAIN_HAND, true);
                    event.setCanceled(true);
                    return;
                }
            }
        }

        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("forge", "milkable")))) {
            if (player.getMainHandItem().getItem() == MountainsPoemModItems.COPPER_JUE.get()) {
                player.getMainHandItem().shrink(1);
                player.getInventory().placeItemBackInInventory(new ItemStack(MountainsPoemModItems.MILK_COPPER_JUE.get()));
                player.swing(InteractionHand.MAIN_HAND, true);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity living = event.getEntity();
        if (living.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("forge", "ghosts")))) {
            if (living.level() instanceof ServerLevel _level && _level.random.nextFloat() < 0.55F)
                MountainsPoemModEntities.SOUL_SHARD.get().spawn(_level, living.blockPosition(), MobSpawnType.MOB_SUMMONED);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END)
            ArmorAnimationFactory.animatedArmors(event.player);
        if (event.phase == TickEvent.Phase.START)
            ItemAnimationFactory.animatedItems(event.player);
    }
}