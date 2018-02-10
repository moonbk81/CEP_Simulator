package simulator.control.interfaces;
import simulator.model.ComponentProfile;

import java.util.List;

public interface IComponentManager {
	void registerProfile(ComponentProfile profile);
	void deleteProfile(int index);
	void modifyProfile(int index, ComponentProfile profile);
	ComponentProfile retrieveProfile(int index);

    List<ComponentProfile> getComponentProfiles();
}