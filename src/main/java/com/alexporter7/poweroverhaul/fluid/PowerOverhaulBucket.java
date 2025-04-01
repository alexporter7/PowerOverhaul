package com.alexporter7.poweroverhaul.fluid;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class PowerOverhaulBucket extends ItemBucket {

    public PowerOverhaulBucket(Block block) {
        super(block);
        this.setContainerItem(Items.bucket);
        this.maxStackSize = 1;
    }

}
