package simulator.control;
import java.util.*;

import simulator.control.interfaces.IServiceManager;
import simulator.model.ServiceProfile;

public class ServiceManager implements IServiceManager {
	private ArrayList<ServiceProfile> serviceProfiles;
	private SimulatorProxy proxy;

	public ServiceManager(SimulatorProxy si) {
		serviceProfiles = new ArrayList<>();
		this.proxy = si;
	}

	public void registerProfile(ServiceProfile profile) {
		if (serviceProfiles != null) {
			serviceProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			serviceProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, ServiceProfile profile) {
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			serviceProfiles.set(index, profile);
		}
	}

	public ServiceProfile retrieveProfile(int index) {
		ServiceProfile serviceProfile = null;
		if (serviceProfiles != null && !serviceProfiles.isEmpty()) {
			serviceProfile = serviceProfiles.get(index);
		}
		return serviceProfile;
	}

	@Override
	public List<ServiceProfile> getServiceProfiles() {
		return serviceProfiles;
	}
}