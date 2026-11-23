package com.xiris.mountainspoem.item;

import com.xiris.mountainspoem.MountainsPoemMod;
import com.xiris.mountainspoem.init.MountainsPoemModBlocks;
import com.xiris.mountainspoem.init.MountainsPoemModItems;
import com.xiris.mountainspoem.init.MountainsPoemModSounds;
import com.xiris.mountainspoem.util.BlockStateUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChiselItem extends AxeItem {
    public ChiselItem(Tier tier, float f, float g, Properties properties) {
        super(tier, f, g, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        LevelAccessor world = context.getLevel();
        double x = context.getClickedPos().getX();
        double y = context.getClickedPos().getY();
        double z = context.getClickedPos().getZ();
        LivingEntity entity = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockPos pos = BlockPos.containing(x, y, z);
        if (world.getBlockState(pos).is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(MountainsPoemMod.MOD_ID, "zun_bottle")))) {
            if (itemstack.hurt(1, RandomSource.create(), null)) {
                itemstack.shrink(1);
                itemstack.setDamageValue(0);
            }
            Map<Item, Block> blockMap = new LinkedHashMap<>();
            blockMap.put(MountainsPoemModItems.BOYI_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_BOYI.get());
            blockMap.put(MountainsPoemModItems.CHANGFU_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHANGFU.get());
            blockMap.put(MountainsPoemModItems.PIGLIN_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_PIGLIN.get());
            blockMap.put(MountainsPoemModItems.CHICKEN_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_CHICKEN.get());
            blockMap.put(MountainsPoemModItems.LEI_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LEI.get());
            blockMap.put(MountainsPoemModItems.LONG_CHI_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_LONG_CHI.get());
            blockMap.put(MountainsPoemModItems.ZHENG_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHENG.get());
            blockMap.put(MountainsPoemModItems.ENDER_DRAGON_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ENDER_DRAGON.get());
            blockMap.put(MountainsPoemModItems.SOUTH_MOUNTAINS_GOD_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_SOUTH_MOUNTAINS_GOD.get());
            blockMap.put(MountainsPoemModItems.ZHI_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE_ZHI.get());
            blockMap.put(MountainsPoemModItems.BLANK_TOTEM_SCROLLS.get(), MountainsPoemModBlocks.COPPER_ZUN_BOTTLE.get());
            ItemStack stack = entity.getOffhandItem();
            for (Map.Entry<Item, Block> entry : blockMap.entrySet())
                if (stack.is(entry.getKey())) {
                    BlockStateUtil.replaceBlock(world, BlockPos.containing(x, y, z), entry.getValue(), true);
                    break;
                }
            if (world instanceof Level _level)
                ((Level) world).playSound(null, x, y, z, MountainsPoemModSounds.BRONZE_SHAPING.get(), SoundSource.NEUTRAL, 1, 1);
        }
        return InteractionResult.SUCCESS;
    }
}
