package com.alexporter7.poweroverhaul.api.properties;

import com.alexporter7.poweroverhaul.api.properties.PropertyList.Generator;

public class GeneratorProperties {

    public final int engineOffTemp;
    public final int engineIdleTemp;
    public final int engineMaxTemp;

    public final int engineWarmUpTargetRpm;
    public final int engineIdleTargetRpm;

    public final int[] engineTargetRpmStep;
    public final int[] engineOffTempStep;
    public final int[] engineWarmUpTempStep;

    public GeneratorProperties(Properties<Integer> properties) {
        this.engineOffTemp = properties.getProperty(Generator.TEMP_OFF);
        this.engineIdleTemp = properties.getProperty(Generator.TEMP_IDLE);
        this.engineMaxTemp = properties.getProperty(Generator.TEMP_MAX);
        this.engineWarmUpTargetRpm = properties.getProperty(Generator.TARGET_RPM_WARM_UP);
        this.engineIdleTargetRpm = properties.getProperty(Generator.TARGET_RPM_IDLE);
        this.engineTargetRpmStep = new int[]{
            properties.getProperty(Generator.RPM_STEP_MIN),
            properties.getProperty(Generator.RPM_STEP_MAX)};
        this.engineOffTempStep = new int[]{
            properties.getProperty(Generator.TEMP_STEP_OFF_CHANCE),
            properties.getProperty(Generator.TEMP_STEP_OFF_MIN),
            properties.getProperty(Generator.TEMP_STEP_OFF_MAX)};
        this.engineWarmUpTempStep = new int[]{
            properties.getProperty(Generator.TEMP_STEP_WARM_UP_CHANCE),
            properties.getProperty(Generator.TEMP_STEP_WARM_UP_MIN),
            properties.getProperty(Generator.TEMP_STEP_WARM_UP_MAX)};

    }

}
