package simulator.control;

import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

public class ResultBuilder {
    //private SimulationResult simulationResult;
    private ArchitectureDescription architectDescription;
    private SystemProfile systemProfile;
    private int totalComplexity;
    private int totalMemoryConsumption;

    public ResultBuilder setArchitectureDescription(ArchitectureDescription ad) {
        this.architectDescription = ad;
        return this;
    }

    public ResultBuilder setSystemProfile(SystemProfile profile) {
        this.systemProfile = profile;
        return this;
    }

    public ResultBuilder setTotalComplexity(int complexity) {
        this.totalComplexity = complexity;
        return this;
    }

    public ResultBuilder setTotalMemoryConsumption(int memory) {
        this.totalMemoryConsumption = memory;
        return this;
    }

    public SimulationResult build() {
        SimulationResult simulationResult = new SimulationResult(architectDescription, systemProfile,
                                                            totalComplexity, totalMemoryConsumption);
        return simulationResult;
    }

}
