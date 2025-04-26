package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.enums.Components;
import com.alexporter7.poweroverhaul.api.material.ComponentType;
import com.alexporter7.poweroverhaul.blocks.MaterialBlock;
import com.alexporter7.poweroverhaul.items.MaterialItem;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;
import com.alexporter7.poweroverhaul.api.material.Component;


public class ComponentDef {

    public static final ComponentType BLOCK = new ComponentType(Components.ComponentType.BLOCK,
        (material, component) ->
            ModRegistry.BLOCKS.put(component.getRegistryName(), new MaterialBlock(material)));
    public static final ComponentType ORE = new ComponentType(Components.ComponentType.ORE, ((material, component) ->
            ModRegistry.BLOCKS.put(component.getRegistryName(), new MaterialBlock(material))));
    public static final ComponentType ITEM = new ComponentType(Components.ComponentType.ITEM, ((material, component) ->
            ModRegistry.ITEMS.put(component.getRegistryName(), new MaterialItem(material, component))));

    public static final ComponentType ENGINE_COMPONENT =
        new ComponentType(Components.ComponentType.ENGINE_COMPONENT, (material, component) ->
            ModRegistry.ITEMS.put(component.getRegistryName(), new EngineComponentItem(material, component)));
    public static final ComponentType ENGINE_COMPONENT_RENDER =
        new ComponentType(Components.ComponentType.ENGINE_COMPONENT_RENDER, (
        (material, component) -> {

        }));


    public static final Component STORAGE_BLOCK = new Component(Components.Component.BLOCK, BLOCK);
    public static final Component ORE_BLOCK = new Component(Components.Component.ORE_BLOCK, ORE);

    public static final Component INGOT = new Component(Components.Component.INGOT, ITEM);
    public static final Component DUST = new Component(Components.Component.DUST, ITEM);

    public static final Component ENGINE_HEAD =
        new Component(Components.Component.ENGINE_HEAD, ENGINE_COMPONENT_RENDER);
    public static final Component ENGINE_BLOCK =
        new Component(Components.Component.ENGINE_BLOCK, ENGINE_COMPONENT_RENDER);
    public static final Component ENGINE_PISTON =
        new Component(Components.Component.ENGINE_PISTON, ITEM);

}
