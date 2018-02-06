package simulator.control;

import simulator.control.interfaces.IExecutionManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SystemProfile;

/**
 * 
 */
public class ExecutionManager implements IExecutionManager {

    private SimulatorProxy interactor;

	/**
     * Default constructor
     * @param interactorImpl 
     */
    public ExecutionManager(SimulatorProxy si) {
    	this.interactor = si;
    }

    public void designSimulationMethod() {
    	System.out.println("Design simulation method!");
    }

    public void executeEventService(ArchitectureDescription ad, SystemProfile profile) {
    	System.out.println("Execute Event Service!");
    	System.out.println("profile name: " + profile.getName());
    	System.out.println("profile id: " + profile.getId());
    	estimateEventServiceSimulation();

    }

    private void estimateEventServiceSimulation() {
    	System.out.println("Estimate computing load, memory usage");
    }

}