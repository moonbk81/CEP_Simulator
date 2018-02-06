package simulator.control;
import java.util.*;

import simulator.control.interfaces.IAdapterManager;
import simulator.model.Adapter;

public class AdapterManager implements IAdapterManager {
	private ArrayList<Adapter> adapterProfiles;
	SimulatorProxy proxy;
	
	public AdapterManager(SimulatorProxy si) {
		adapterProfiles = new ArrayList<Adapter>();
		this.proxy = si;
	}
	
	public void registerProfile(Adapter profile) {
		if (adapterProfiles != null) {
			adapterProfiles.add(profile);
		}
	}

	public void deleteProfile(int index) {
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapterProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, Adapter profile) {
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapterProfiles.set(index, profile);
		}
	}

	public Adapter retrieveProfile(int index) {
		Adapter adapter = null;
		if (adapterProfiles != null && !adapterProfiles.isEmpty()) {
			adapter = adapterProfiles.get(index);
		}
		return adapter;
	}

	@Override
	public List<Adapter> getAdapterProfiles() {
		return adapterProfiles;
	}
}