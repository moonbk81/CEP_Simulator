package simulator.control.interfaces;
import simulator.model.ServiceProfile;

import java.util.List;

public interface IServiceManager {
	void registerProfile(ServiceProfile profile);
	void deleteProfile(int index);
	void modifyProfile(int index, ServiceProfile profile);
	ServiceProfile retrieveProfile(int index);

    List<ServiceProfile> getServiceProfiles();
}