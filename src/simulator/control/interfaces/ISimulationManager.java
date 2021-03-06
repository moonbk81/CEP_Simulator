package simulator.control.interfaces;

import simulator.control.SimulationManager;
import simulator.control.SimulationManager.SIMULATION_STATE;
import simulator.model.EventData;

import java.util.Queue;

public interface ISimulationManager {
    void chooseArchitectureDescription(int index);

    void chooseSystemProfile(int index);

    void startSimulation();

    void stopSimulation();

    void pauseSimulation();

    void reportSimulation();

    void setState(SIMULATION_STATE state);

    SIMULATION_STATE getState();

    Queue<EventData> getEventQueue();
}