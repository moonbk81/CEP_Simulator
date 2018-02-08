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
}