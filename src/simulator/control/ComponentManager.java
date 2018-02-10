package simulator.control;
import java.util.*;

import simulator.control.interfaces.IComponentManager;
import simulator.model.ComponentProfile;

public class ComponentManager implements IComponentManager {
	private ArrayList<ComponentProfile> componentProfiles;
	private SimulatorProxy proxy;

	public ComponentManager(SimulatorProxy si) {
		componentProfiles = new ArrayList<>();
		this.proxy = si;
	}

	public void registerProfile(ComponentProfile profile) {
		if (componentProfiles != null) {
			componentProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			componentProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, ComponentProfile profile) {
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			componentProfiles.set(index, profile);
		}
	}

	public ComponentProfile retrieveProfile(int index) {
		ComponentProfile component = null;
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			return componentProfiles.get(index);
		}
		return component;
	}

	@Override
	public List<ComponentProfile> getComponentProfiles() {
		return componentProfiles;
	}
}