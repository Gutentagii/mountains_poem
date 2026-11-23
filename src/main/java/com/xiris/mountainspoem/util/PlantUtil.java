package com.xiris.mountainspoem.util;

import net.minecraft.world.level.block.*;

public class PlantUtil {
    public static PlantType getPlantType(Block block) {
        if (!(block instanceof CropBlock) && block != Blocks.PITCHER_CROP) {
            if (block instanceof SaplingBlock || block instanceof FlowerBlock)
                return PlantType.PLAINS;
            else if (block == Blocks.DEAD_BUSH)
                return PlantType.DESERT;
            else if (block == Blocks.LILY_PAD)
                return PlantType.WATER;
            else if (block == Blocks.RED_MUSHROOM)
                return PlantType.CAVE;
            else if (block == Blocks.BROWN_MUSHROOM)
                return PlantType.CAVE;
            else if (block == Blocks.NETHER_WART)
                return PlantType.NETHER;
            else
                return PlantType.PLAINS;
        } else
            return PlantType.CROP;
    }
}
