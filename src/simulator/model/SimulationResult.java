package simulator.model;

import java.util.*;

/**
 * 
 */
public class SimulationResult {
    private ArchitectureDescription architectDescription;
    private SystemProfile systemProfile;
    private int totalComplexity;
    private int totalMemoryConsumption;

    public SimulationResult() {

    }
    public SimulationResult(ArchitectureDescription architectDescription,
                            SystemProfile systemProfile,int totalComplexity, int totalMemoryConsumption) {
        this.architectDescription = architectDescription;
        this.systemProfile = systemProfile;
        this.totalComplexity = totalComplexity;
        this.totalMemoryConsumption = totalMemoryConsumption;
    }


    public int getTotalComplexity() {
        return totalComplexity;
    }

    public void setTotalComplexity(int totalComplexity) {
        this.totalComplexity = totalComplexity;
    }

    public int getTotalMemoryConsumption() {
        return totalMemoryConsumption;
    }

    public void setTotalMemoryConsumption(int totalMemoryConsumption) {
        this.totalMemoryConsumption = totalMemoryConsumption;
    }

    public ArchitectureDescription getArchitectDescription() {
        return architectDescription;
    }

    public SystemProfile getSystemProfile() {
        return systemProfile;
    }

    public void setArchitectDescription(ArchitectureDescription architectDescription) {
        this.architectDescription = architectDescription;
    }

    public void setSystemProfile(SystemProfile systemProfile) {
        this.systemProfile = systemProfile;
    }
}