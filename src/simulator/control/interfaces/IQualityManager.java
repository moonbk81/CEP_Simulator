package simulator.control.interfaces;
public interface IQualityManager {
	void startMonitoringService();
	void stopMonitoringService();
	void pauseMonitoringService();
	void retrieveServiceQuality();
}