package simulator.control;

import simulator.control.interfaces.ISimulationManager;
import simulator.model.ArchitectureDescription;
import simulator.model.EventData;
import simulator.model.SystemProfile;

import java.util.LinkedList;
import java.util.Queue;

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

	private Queue<EventData> eventQueue;

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
        // prepare event queue
        eventQueue = new LinkedList<>();
        proxy.getExecutionManager().designSimulationMethod();
        setState(SIMULATION_STATE.SIMULATION_STATE_START);
        proxy.getQualityManager().startMonitoringService();
        proxy.getExecutionManager().executeEventService(archDescription, systemProfile);
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

    @Override
    public Queue<EventData> getEventQueue() {
        return eventQueue;
    }

    public void setState(SIMULATION_STATE state) {
        this.state = state;
    }
}