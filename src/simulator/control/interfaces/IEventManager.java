package simulator.control.interfaces;
import simulator.model.EventProfile;

import java.util.List;

public interface IEventManager {
	void registerProfile(EventProfile profile);
	void deleteProfile(int index);
	void modifyProfile(int index, EventProfile profile);
	EventProfile retrieveProfile(int index);

    List<EventProfile> getEventProfiles();
}