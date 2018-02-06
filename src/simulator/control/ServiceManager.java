package simulator.control;
import java.util.*;

import simulator.control.interfaces.IServiceManager;
import simulator.model.Service;

public class ServiceManager implements IServiceManager {
	private ArrayList<Service> serviceProfiles;
	private SimulatorProxy proxy;

	public ServiceManager(SimulatorProxy si) {
		serviceProfiles = new ArrayList<>();
		this.proxy = si;
	}

	public void registerProfile(Service profile) {
		if (serviceProfiles != null) {
			serviceProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			serviceProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, Service profile) {
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			serviceProfiles.set(index, profile);
		}
	}

	public Service retrieveProfile(int index) {
		Service service = null;
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			service = serviceProfiles.get(index);
		}
		return service;
	}

	@Override
	public List<Service> getServiceProfiles() {
		return serviceProfiles;
	}
}