package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.Component;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.MaterialCustomRenderBlock;

public class EngineComponentBlock extends MaterialCustomRenderBlock {

    public EngineComponentBlock(PowerOverhaulMaterial material, Component component,
                                String internalBlockName) {
        super(material, component, internalBlockName);

    }

}
