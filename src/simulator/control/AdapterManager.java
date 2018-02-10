package simulator.control;
import java.util.*;

import simulator.control.interfaces.IAdapterManager;
import simulator.model.AdapterProfile;

public class AdapterManager implements IAdapterManager {
	private ArrayList<AdapterProfile> adapterProfiles;
	SimulatorProxy proxy;

    public AdapterManager(SimulatorProxy si) {
        adapterProfiles = new ArrayList<>();
        this.proxy = si;
    }

    public void registerProfile(AdapterProfile profile) {
        if (adapterProfiles != null) {
            adapterProfiles.add(profile);
        }
	}

	public void deleteProfile(int index) {
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapterProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, AdapterProfile profile) {
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapterProfiles.set(index, profile);
		}
	}

	public AdapterProfile retrieveProfile(int index) {
		AdapterProfile adapterProfile = null;
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapterProfile = adapterProfiles.get(index);
		}
		return adapterProfile;
	}

	@Override
	public List<AdapterProfile> getAdapterProfiles() {
		return adapterProfiles;
	}
}