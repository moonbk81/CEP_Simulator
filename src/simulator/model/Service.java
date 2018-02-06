package simulator.model;

import java.util.*;

public class Service extends Profile {
	private int eventId;
	private ArrayList<Component> components;

    public Service() {
    	components = new ArrayList<>();
		eventId = -1;
    }

	public Service(int eventId, ArrayList<Component> components) {
		this.eventId = eventId;
    	this.components = components;
	}

	public Component getComponents(int componentId) {
		if (this.components != null && !this.components.isEmpty()) {
			return this.components.get(componentId);
		}
		return null;
	}

	public void addComponent(Component components) {
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

	public ArrayList<Component> getComponents() {
		return components;
	}
}