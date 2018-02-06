package simulator.control;

import simulator.control.interfaces.ISimulationManager;
import simulator.model.ArchitectureDescription;
import simulator.model.Component;
import simulator.model.Service;
import simulator.model.SystemProfile;

public class SimulationManager implements ISimulationManager {
	private SimulatorProxy interactor = null;
	private SystemProfile systemProfile;
	private ArchitectureDescription archDescription;

    public SimulationManager() {
    	System.out.println("SimulationManager!");
    }
    

    public SimulationManager(SimulatorProxy interactor) {
		super();
		this.interactor = interactor;
	}


	public void chooseArchitectureDescription() {
    	System.out.println("choose Architecture Description!");
    	Service service = interactor.getServiceManager().retrieveProfile(0);
    	System.out.println("Retrieved service event id " + service.getEventId() + "component " + 
    							service.getComponents(0).getComponent().getName());
    	Component component = interactor.getComponentManager().retrieveProfile(0);
    	System.out.println("Retrieve component name: " + component.getComponent().getName());
    	archDescription = new ArchitectureDescription();
    }

    public void chooseSystemProfile() {
    	System.out.println("choose SystemProfile");
    	systemProfile = interactor.getSystemManager().retrieveProfile(0);
    }

    public void startSimulation() {
    	interactor.getExecutionManager().designSimulationMethod();
    	interactor.getExecutionManager().executeEventService(archDescription, systemProfile);
        interactor.getQualityManager().startMonitoringService();
    }

    public void stopSimulation() {

    }

    public void pauseSimulation() {

    }

    public void reportSimulation() {

    }
}