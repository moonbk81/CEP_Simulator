package simulator.control.interfaces;
import simulator.model.ArchitectureDescription;
import simulator.model.SystemProfile;

public interface IExecutionManager {
	void designSimulationMethod();
	void executeEventService(ArchitectureDescription ad, SystemProfile profile);

}