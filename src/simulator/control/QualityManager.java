package simulator.control;

import simulator.control.interfaces.IMonitor;
import simulator.control.interfaces.IQualityManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class QualityManager implements IQualityManager {
    private final int RESULT_LEVEL1     = 1;
    private final int RESULT_LEVEL2      = 2;
    private final int RESULT_LEVEL_ALL              = 3;

    private SimulatorProxy proxy;
    private int level = 0;
    private ArchitectureDescription resultAd;
    private SystemProfile resultSysProfile;
    private ArrayList<IMonitor> monitorList;

    public QualityManager(SimulatorProxy si) {
    	System.out.println("Quality Manager");
    	this.proxy = si;
    	monitorList = new ArrayList<>();
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
            case RESULT_LEVEL1:
                return resultBuilder
                            .setArchitectureDescription(ad)
                            .setSystemProfile(profile)
                            .build();
            case RESULT_LEVEL2:
                return resultBuilder
                            .setTotalComplexity(compexity)
                            .setTotalMemoryConsumption(memory)
                            .build();
            case RESULT_LEVEL_ALL:
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
    public SimulationResult consistResultByUserPreference() {
        return null;
    }

    @Override
    public void setResultLevel(int level) {
        setLevel(level);
    }

    @Override
    public void addMonitor(IMonitor monitor) {
        monitorList.add(monitor);
    }

    @Override
    public void deleteMonitor(IMonitor monitor) {
        if (monitorList.indexOf(monitor) <= 0) {
            monitorList.remove(monitor);
        }
    }

    @Override
    public void notifyMonitor() {
        System.out.println("Notify to monitor");
        for (int i = 0; i < monitorList.size(); i++) {
            IMonitor monitor = monitorList.get(i);
            monitor.update(1,2,3);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public class MonitorData extends Observable {
        private int eventId;
        private int complexity;
        private int consumption;

        public MonitorData () {

        }

        public void setEvaluateEventService(int id, int complexity, int consumption) {
            this.eventId = id;
            this.complexity = complexity;
            this.consumption = consumption;
            evaluateEventService();
        }

        public void evaluateEventService() {
            setChanged();
            notifyObservers();
        }

        public int getEventId() {
            return eventId;
        }

        public int getComplexity() {
            return complexity;
        }

        public int getConsumption() {
            return consumption;
        }

        public void setEventId(int eventId) {
            this.eventId = eventId;
        }

        public void setComplexity(int complexity) {
            this.complexity = complexity;
        }

        public void setConsumption(int consumption) {
            this.consumption = consumption;
        }
    }
}