package simulator.model;

import java.util.*;

public class ServiceProfile extends Profile {
	private int eventId;
	private ArrayList<ComponentProfile> components;

    public ServiceProfile() {
    	components = new ArrayList<>();
		eventId = -1;
    }

	public ServiceProfile(int eventId, ArrayList<ComponentProfile> components) {
		this.eventId = eventId;
    	this.components = components;
	}

	public ComponentProfile getComponents(int componentId) {
		if (this.components != null && !this.components.isEmpty()) {
			return this.components.get(componentId);
		}
		return null;
	}

	public void addComponent(ComponentProfile components) {
		if (this.components != null) {
			this.components.add(components);
		}
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public ArrayList<ComponentProfile> getComponents() {
		return components;
	}
}