package simulator.control.interfaces;
import simulator.model.Component;

import java.util.List;

public interface IComponentManager {
	void registerProfile(Component profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Component profile);
	Component retrieveProfile(int index);

    List<Component> getComponentProfiles();
}