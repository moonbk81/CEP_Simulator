package simulator.control.interfaces;

import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

public interface IMonitor {
    public void update(int eventId, int complexity, int consumption, ArchitectureDescription ad, SystemProfile profile);
    // notify

    SimulationResult consistResultByVisualLevel();
    SimulationResult consistResultByUserPreference();
    void setResultLevel(int level);
}
