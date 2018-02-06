package simulator.control;
import java.util.*;

import simulator.control.interfaces.IEventManager;
import simulator.model.Event;

public class EventManager implements IEventManager {
	private ArrayList<Event> eventProfiles;
	private SimulatorProxy proxy;
	
	public EventManager(SimulatorProxy si) {
		eventProfiles = new ArrayList<Event>();
		this.proxy = si;
	}

	public void registerProfile(Event profile) {
		if (eventProfiles != null) {
			eventProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			eventProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, Event profile) {
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			eventProfiles.set(index, profile);
		}
	}

	public Event retrieveProfile(int index) {
		Event event = null;
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			event = eventProfiles.get(index);
		}
		return event;
	}

	@Override
	public List<Event> getEventProfiles() {
		return eventProfiles;
	}
}