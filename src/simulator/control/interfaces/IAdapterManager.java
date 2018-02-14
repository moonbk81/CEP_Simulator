package simulator.control.interfaces;
import simulator.model.AdapterProfile;

import java.util.List;

public interface IAdapterManager {
	void registerProfile(AdapterProfile profile);
	void deleteProfile(int index);
	void modifyProfile(int index, AdapterProfile profile);
	AdapterProfile retrieveProfile(int index);

    List<AdapterProfile> getAdapterProfiles();
    void prepareAdapter();
}