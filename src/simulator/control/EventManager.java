package simulator.control;
import java.util.*;

import simulator.control.interfaces.IEventManager;
import simulator.model.EventProfile;

public class EventManager implements IEventManager {
	private ArrayList<EventProfile> eventProfiles;
	private SimulatorProxy proxy;
	
	public EventManager(SimulatorProxy si) {
		eventProfiles = new ArrayList<EventProfile>();
		this.proxy = si;
	}

	public void registerProfile(EventProfile profile) {
		if (eventProfiles != null) {
			eventProfiles.add(profile);
		}
		
	}

	public void deleteProfile(int index) {
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			eventProfiles.remove(index);
		}
	}

	public void modifyProfile(int index, EventProfile profile) {
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			eventProfiles.set(index, profile);
		}
	}

	public EventProfile retrieveProfile(int index) {
		EventProfile eventProfile = null;
		if (eventProfiles != null && !eventProfiles.isEmpty()) {
			eventProfile = eventProfiles.get(index);
		}
		return eventProfile;
	}

	@Override
	public List<EventProfile> getEventProfiles() {
		return eventProfiles;
	}
}