package simulator.control;

import simulator.control.interfaces.IQualityManager;
import simulator.model.SimulationResult;

public class QualityManager implements IQualityManager {
    private SimulatorProxy proxy;
    private int level = 0;

    public QualityManager(SimulatorProxy si) {
    	System.out.println("Quality Manager");
    	this.proxy = si;
    }

    public void startMonitoringService() {
    	System.out.println("Start monitoring event service");
    }

    public void stopMonitoringService() {
    	System.out.println("Stop monitoring event service");
    }

	public void pauseMonitoringService() {
		System.out.println("Pause monitoring event service");
	}

	public void retrieveServiceQuality() {
		System.out.println("Retrieve monitoring event service");

	}

    @Override
    public SimulationResult consistResultByVisualLevel() {
        ResultBuilder resultBuilder = new ResultBuilder();

        switch (getLevel()) {
            case 1:
                return resultBuilder
                            .setArchitectureDescription(ad)
                            .setSystemProfile(profile)
                            .build();
            case 2:
                return resultBuilder
                            .setTotalComplexity(compexity)
                            .setTotalMemoryConsumption(memory)
                            .build();
            case 3:
                return resultBuilder
                            .setArchitectureDescription(ad)
                            .setSystemProfile(profile)
                            .setTotalComplexity(complexity)
                            .setTotalMemoryConsumption(memory)
                            .build();
            default:
                return resultBuilder.build();
        }
    }

    @Override
    public void setResultLevel(int level) {
        setLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}