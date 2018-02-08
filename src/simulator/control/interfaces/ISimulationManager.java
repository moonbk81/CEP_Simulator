package simulator.control.interfaces;
public interface ISimulationManager {
    void chooseArchitectureDescription(int index);

    void chooseSystemProfile(int index);

    void startSimulation();

    void stopSimulation();

    void pauseSimulation();

    void reportSimulation();
}