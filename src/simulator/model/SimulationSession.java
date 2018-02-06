package simulator.model;
import java.util.*;

public class SimulationSession {
	private ArrayList<SimulationResult> simulationResult = new ArrayList<SimulationResult>();
	private int sessionCount = 0;

	public SimulationSession() {
		sessionCount = 0;
	}

	public void storeSimulationResult(SimulationResult result) {
		simulationResult.add(result);
		sessionCount++;
	}
}