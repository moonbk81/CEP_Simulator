package simulator.control;

import simulator.control.interfaces.ISimulationManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SystemProfile;

public class SimulationManager implements ISimulationManager {
    public enum SIMULATION_STATE {
        SIMULATIOIN_STATE_STOP,
        SIMULATION_STATE_START,
        SIMULATION_STATE_PAUSE,
        SIMULATION_STATE_RESULT,
        SIMULATION_STATE_UNKNOWN
    };

    private SimulatorProxy proxy;
	private SystemProfile systemProfile;
	private ArchitectureDescription archDescription;
	private SIMULATION_STATE state;

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
        setState(SIMULATION_STATE.SIMULATION_STATE_START);
        proxy.getQualityManager().startMonitoringService();
    }

    public void stopSimulation() {
        setState(SIMULATION_STATE.SIMULATIOIN_STATE_STOP);
    }

    public void pauseSimulation() {
        setState(SIMULATION_STATE.SIMULATION_STATE_PAUSE);
    }

    public void reportSimulation() {
        setState(SIMULATION_STATE.SIMULATION_STATE_RESULT);
    }

    public SIMULATION_STATE getState() {
        return state;
    }

    public void setState(SIMULATION_STATE state) {
        this.state = state;
    }
}