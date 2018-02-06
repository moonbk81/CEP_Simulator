package simulator.control.interfaces;
public interface ISimulationManager {
    void chooseArchitectureDescription();

    void chooseSystemProfile();

    void startSimulation();

    void stopSimulation();

    void pauseSimulation();

    void reportSimulation();
}