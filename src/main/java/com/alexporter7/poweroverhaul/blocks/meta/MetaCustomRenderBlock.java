package com.alexporter7.poweroverhaul.blocks.meta;

import net.minecraft.block.material.Material;

public class MetaCustomRenderBlock extends MetaPowerOverhaulBlock {

    public MetaCustomRenderBlock(Material material) {
        super(material);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
