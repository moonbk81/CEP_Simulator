package simulator.control;
import java.util.*;

import simulator.control.adapter.Adapter;
import simulator.control.interfaces.IAdapterManager;
import simulator.model.AdapterProfile;
import simulator.model.SourceProfile.SourceEnum;

public class AdapterManager implements IAdapterManager {
	private ArrayList<AdapterProfile> adapterProfiles;
	private Map<SourceEnum, Adapter> adapterMap;
	SimulatorProxy proxy;

    public AdapterManager(SimulatorProxy si) {
        adapterProfiles = new ArrayList<>();
        adapterMap = new HashMap<>();
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

	@Override
	public void prepareAdapter() {
    	AbstractAdapterFactory adapterFactory = new AdapterFactory();
		for (int i = 0; i < adapterProfiles.size(); i++) {
			AdapterProfile profile = retrieveProfile(i);
			SourceEnum srcType = profile.getSourceType();
			adapterMap.put(srcType, adapterFactory.createAdapter(srcType));
		}
	}
}