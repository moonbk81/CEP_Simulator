package simulator.control;
import java.util.*;

import simulator.control.interfaces.ISystemManager;
import simulator.model.SystemProfile;

public class SystemManager implements ISystemManager {
	private ArrayList<SystemProfile> systemProfiles;
	private SimulatorProxy proxy;

	public SystemManager(SimulatorProxy si) {
		this.proxy = si;
		systemProfiles = new ArrayList<SystemProfile>();
	}

	public void registerProfile(String name, int id, int coreNum, int maxCapa) {
		SystemProfile profile = new SystemProfile(name, id, coreNum, maxCapa, 1);
		registerProfile(profile);
	}

	@Override
	public void registerProfile(SystemProfile sysProfile) {
		if (systemProfiles != null) {
			systemProfiles.add(sysProfile);
		}
	}

	public void deleteProfile(int index) {
		if (systemProfiles != null && !systemProfiles.isEmpty()) {
			systemProfiles.remove(index);
		}
	}
	public void modifyProfile(int index, SystemProfile profile) {
		if (systemProfiles != null && !systemProfiles.isEmpty()) {
			systemProfiles.set(index, profile);
		}
	}
	public SystemProfile retrieveProfile(int index) {
		SystemProfile sp = null;
		if (systemProfiles != null && !systemProfiles.isEmpty()) {
			sp = systemProfiles.get(index);
		}
		return sp;
	}

	@Override
	public ArrayList<SystemProfile> getSystemProfiles() {
		return systemProfiles;
	}
}