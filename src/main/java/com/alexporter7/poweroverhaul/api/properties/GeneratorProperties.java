package com.alexporter7.poweroverhaul.api.properties;

public class GeneratorProperties {

    private int engineOffTemp;
    private int engineIdleTemp;
    private int engineMaxTemp;

    private int engineWarmUpTargetRpm;
    private int engineIdleTargetRpm;

    private int[] engineTargetRpmStep;
    private int[] engineOffTempStep;
    private int[] engineWarmUpTempStep;

    public GeneratorProperties(GeneratorPropertyBuilder builder) {

    }

    public int getEngineOffTemp() {
        return engineOffTemp;
    }

    public void setEngineOffTemp(int engineOffTemp) {
        this.engineOffTemp = engineOffTemp;
    }

    public int getEngineIdleTemp() {
        return engineIdleTemp;
    }

    public void setEngineIdleTemp(int engineIdleTemp) {
        this.engineIdleTemp = engineIdleTemp;
    }

    public int getEngineMaxTemp() {
        return engineMaxTemp;
    }

    public void setEngineMaxTemp(int engineMaxTemp) {
        this.engineMaxTemp = engineMaxTemp;
    }

    public int getEngineWarmUpTargetRpm() {
        return engineWarmUpTargetRpm;
    }

    public void setEngineWarmUpTargetRpm(int engineWarmUpTargetRpm) {
        this.engineWarmUpTargetRpm = engineWarmUpTargetRpm;
    }

    public int getEngineIdleTargetRpm() {
        return engineIdleTargetRpm;
    }

    public void setEngineIdleTargetRpm(int engineIdleTargetRpm) {
        this.engineIdleTargetRpm = engineIdleTargetRpm;
    }

    public int[] getEngineTargetRpmStep() {
        return engineTargetRpmStep;
    }

    public void setEngineTargetRpmStep(int[] engineTargetRpmStep) {
        this.engineTargetRpmStep = engineTargetRpmStep;
    }

    public int[] getEngineOffTempStep() {
        return engineOffTempStep;
    }

    public void setEngineOffTempStep(int[] engineOffTempStep) {
        this.engineOffTempStep = engineOffTempStep;
    }

    public int[] getEngineWarmUpTempStep() {
        return engineWarmUpTempStep;
    }

    public void setEngineWarmUpTempStep(int[] engineWarmUpTempStep) {
        this.engineWarmUpTempStep = engineWarmUpTempStep;
    }

}
