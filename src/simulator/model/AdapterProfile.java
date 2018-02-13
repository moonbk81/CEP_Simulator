package simulator.model;

import simulator.model.SourceProfile.SourceEnum;

public class AdapterProfile extends Profile {
    private SourceEnum sourceType;
    private int complexity;
    private int memoryConsumption;

    public AdapterProfile() {
    }

    public AdapterProfile(SourceEnum sourceType, int complexity, int memoryConsumption) {
        this.sourceType = sourceType;
        this.complexity = complexity;
        this.memoryConsumption = memoryConsumption;
    }

    public SourceEnum getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceEnum sourceType) {
        this.sourceType = sourceType;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }


}