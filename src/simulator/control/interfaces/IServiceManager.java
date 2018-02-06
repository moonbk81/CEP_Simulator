package simulator.control.interfaces;
import simulator.model.Service;

import java.util.List;

public interface IServiceManager {
	void registerProfile(Service profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Service profile);
	Service retrieveProfile(int index);

    List<Service> getServiceProfiles();
}