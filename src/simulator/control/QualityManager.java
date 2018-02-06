package simulator.control;

import simulator.control.interfaces.IQualityManager;

/**
 * 
 */
public class QualityManager implements IQualityManager {

    private SimulatorProxy proxy;

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


}