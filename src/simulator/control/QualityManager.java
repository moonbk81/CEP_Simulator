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
    private SimulatorProxy proxy;

    private ArchitectureDescription resultAd;
    private SystemProfile resultSysProfile;
    private ArrayList<IMonitor> monitorList;

    private IMonitor resultMonitor;

    public QualityManager(SimulatorProxy si) {
    	System.out.println("Quality Manager");
    	this.proxy = si;
    	monitorList = new ArrayList<>();
        resultMonitor = new ResultMonitor();
    }

    public void startMonitoringService() {
    	System.out.println("Start monitoring event service");
    	addMonitor(resultMonitor);
    }

    public void stopMonitoringService() {
    	System.out.println("Stop monitoring event service");
    	deleteMonitor(resultMonitor);
    }

	public void pauseMonitoringService() {
		System.out.println("Pause monitoring event service");
	}

	public void retrieveServiceQuality() {
		System.out.println("Retrieve monitoring event service");

	}

    @Override
    public void setResultLevel(int level) {
        resultMonitor.setResultLevel(level);
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
    public void notifyMonitor(SimulationResult result) {
        System.out.println("Notify to monitor");
        for (int i = 0; i < monitorList.size(); i++) {
            IMonitor monitor = monitorList.get(i);
            ArchitectureDescription ad = result.getArchitectDescription();
            monitor.update(ad.getEventProfile().getEventId(), result.getTotalComplexity(), result.getTotalMemoryConsumption(),
                            ad, result.getSystemProfile());
        }
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