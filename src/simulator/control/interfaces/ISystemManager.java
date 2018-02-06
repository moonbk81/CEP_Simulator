package simulator.control.interfaces;
import java.util.ArrayList;
import java.util.List;

import simulator.model.SystemProfile;
import simulator.model.UserProfile;

public interface ISystemManager {
	void deleteProfile(int index);
	void modifyProfile(int index, SystemProfile profile);
	SystemProfile retrieveProfile(int index);

    void registerProfile(String name, int id, int core, int maxCapa);

    List<SystemProfile> getSystemProfiles();

    void registerProfile(SystemProfile sysProfile);
}