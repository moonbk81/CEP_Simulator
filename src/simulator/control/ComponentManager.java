package simulator.control;
import java.util.*;

import simulator.control.interfaces.IComponentManager;
import simulator.model.Component;

public class ComponentManager implements IComponentManager {
	private ArrayList<Component> componentProfiles;
	private SimulatorProxy proxy;

	public ComponentManager(SimulatorProxy si) {
		componentProfiles = new ArrayList<>();
		this.proxy = si;
	}

	public void registerProfile(Component profile) {
		if (componentProfiles != null) {
			componentProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			componentProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, Component profile) {
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			componentProfiles.set(index, profile);
		}
	}

	public Component retrieveProfile(int index) {
		Component component = null;
		if (componentProfiles != null && !componentProfiles.isEmpty()) {
			return componentProfiles.get(index);
		}
		return component;
	}

	@Override
	public List<Component> getComponentProfiles() {
		return componentProfiles;
	}
}