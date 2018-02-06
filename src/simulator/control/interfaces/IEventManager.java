package simulator.control.interfaces;
import simulator.model.Event;

import java.util.List;

public interface IEventManager {
	void registerProfile(Event profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Event profile);
	Event retrieveProfile(int index);

    List<Event> getEventProfiles();
}