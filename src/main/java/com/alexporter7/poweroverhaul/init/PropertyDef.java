package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.properties.Properties;
import com.alexporter7.poweroverhaul.api.properties.PropertyList;

public class PropertyDef {

    public static final Properties<Integer> DIESEL_GEN_PROPS =
        new Properties.PropertyBuilder<Integer>()
            .addProperty(PropertyList.Generator.TEMP_OFF, 75)
            .addProperty(PropertyList.Generator.TEMP_IDLE, 190)
            .addProperty(PropertyList.Generator.TEMP_MAX, 230)
            .addProperty(PropertyList.Generator.TARGET_RPM_WARM_UP, 1200)
            .addProperty(PropertyList.Generator.TARGET_RPM_IDLE, 750)
            .addProperty(PropertyList.Generator.RPM_STEP_MIN, 20)
            .addProperty(PropertyList.Generator.RPM_STEP_MAX, 30)
            .addProperty(PropertyList.Generator.TEMP_STEP_OFF_CHANCE, 3)
            .addProperty(PropertyList.Generator.TEMP_STEP_OFF_MIN, 1)
            .addProperty(PropertyList.Generator.TEMP_STEP_OFF_MAX, 2)
            .addProperty(PropertyList.Generator.TEMP_STEP_WARM_UP_CHANCE, 3)
            .addProperty(PropertyList.Generator.TEMP_STEP_WARM_UP_MIN, 1)
            .addProperty(PropertyList.Generator.TEMP_STEP_WARM_UP_MAX, 3)
            .build();


}
