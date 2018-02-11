package simulator.control.interfaces;

import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

public interface IQualityManager {
	void startMonitoringService();
	void stopMonitoringService();
	void pauseMonitoringService();
	void retrieveServiceQuality();
	void setResultLevel(int level);

	// For observer, it is subject interface
	public void addMonitor(IMonitor monitor);
	public void deleteMonitor(IMonitor monitor);
	public void notifyMonitor(SimulationResult result);
}