package simulator.control.interfaces;

import simulator.model.SimulationResult;

public interface IQualityManager {
	void startMonitoringService();
	void stopMonitoringService();
	void pauseMonitoringService();
	void retrieveServiceQuality();
	SimulationResult consistResultByVisualLevel();
	SimulationResult consistResultByUserPreference();
	void setResultLevel(int level);
}