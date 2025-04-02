package com.alexporter7.poweroverhaul.api.properties;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class GeneratorPropertyBuilder {

    public int engineOffTemp;
    public int engineIdleTemp;
    public int engineMaxTemp;

    public int engineWarmUpTargetRpm;
    public int engineIdleTargetRpm;

    public int[] engineTargetRpmStep;
    public int[] engineOffTempStep;
    public int[] engineWarmUpTempStep;

    private GeneratorProperties generatorProperties;

    public GeneratorPropertyBuilder() {

    }

    public GeneratorPropertyBuilder setEngineOffTemp(int engineOffTemp) {
        this.engineOffTemp = engineOffTemp;
        return this;
    }

    public GeneratorPropertyBuilder setEngineIdleTemp(int engineIdleTemp) {
        this.engineIdleTemp = engineIdleTemp;
        return this;
    }

    public GeneratorPropertyBuilder setEngineMaxTemp(int engineMaxTemp) {
        this.engineMaxTemp = engineMaxTemp;
        return this;
    }

    public GeneratorPropertyBuilder setEngineWarmUpTargetRpm(int engineWarmUpTargetRpm) {
        this.engineWarmUpTargetRpm = engineWarmUpTargetRpm;
        return this;
    }

    public GeneratorPropertyBuilder setEngineIdleTargetRpm(int engineIdleTargetRpm) {
        this.engineIdleTargetRpm = engineIdleTargetRpm;
        return this;
    }

    public GeneratorPropertyBuilder setEngineTargetRpmStep(int minimumStep, int maximumStep) {
        this.engineTargetRpmStep = new int[]{minimumStep, maximumStep};
        return this;
    }

    public GeneratorPropertyBuilder setEngineOffTempStep(int percentChance, int minimumStep, int maximumStep) {
        this.engineOffTempStep = new int[]{percentChance, minimumStep, maximumStep};
        return this;
    }

    public GeneratorPropertyBuilder setEngineWarmUpStep(int percentChance, int minimumStep, int maximumStep) {
        this.engineWarmUpTempStep = new int[]{percentChance, minimumStep, maximumStep};
        return this;
    }

    private boolean validate() {
        return (
            Arrays.stream(
                new int[]{engineOffTemp, engineIdleTemp, engineMaxTemp,
                    engineWarmUpTargetRpm, engineIdleTargetRpm})
                .noneMatch(Objects::nonNull)
            && Arrays.stream(
                new int[][]{engineTargetRpmStep, engineOffTempStep, engineWarmUpTempStep})
                .noneMatch(Objects::nonNull));
    }

    public GeneratorProperties build() {
        if(!this.validate())
            throw new InvalidParameterException("Not all properties are defined");
        return new GeneratorProperties(this);
    }



}
