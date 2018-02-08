package simulator.control;

import simulator.control.interfaces.ISimulationManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SystemProfile;

public class SimulationManager implements ISimulationManager {
	private SimulatorProxy proxy;
	private SystemProfile systemProfile;
	private ArchitectureDescription archDescription;

    public SimulationManager() {
    	System.out.println("SimulationManager!");
    }
    

    public SimulationManager(SimulatorProxy proxy) {
		super();
		this.proxy = proxy;
	}


	public void chooseArchitectureDescription(int index) {
    	archDescription = new ArchitectureDescription(proxy.getSourceManager().retrieveProfile(index),
													  proxy.getAdapterManager().retrieveProfile(index),
                                                      proxy.getEventManager().retrieveProfile(index),
                                                      proxy.getServiceManager().retrieveProfile(index),
                                                      proxy.getComponentManager().retrieveProfile(index));
    }

    public void chooseSystemProfile(int index) {
        System.out.println("choose SystemProfile");
        systemProfile = proxy.getSystemManager().retrieveProfile(index);
    }

    public void startSimulation() {
        proxy.getExecutionManager().designSimulationMethod();
        proxy.getExecutionManager().executeEventService(archDescription, systemProfile);
        proxy.getQualityManager().startMonitoringService();
    }

    public void stopSimulation() {

    }

    public void pauseSimulation() {

    }

    public void reportSimulation() {

    }
}