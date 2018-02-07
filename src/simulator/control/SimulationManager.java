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


	public void chooseArchitectureDescription() {
    	archDescription = new ArchitectureDescription(proxy.getSourceManager().retrieveProfile(0),
													  proxy.getAdapterManager().retrieveProfile(0),
                                                      proxy.getEventManager().retrieveProfile(0),
                                                      proxy.getServiceManager().retrieveProfile(0),
                                                      proxy.getComponentManager().retrieveProfile(0));
    }

    public void chooseSystemProfile() {
    	System.out.println("choose SystemProfile");
    	systemProfile = proxy.getSystemManager().retrieveProfile(0);
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