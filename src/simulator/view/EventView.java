package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.EventProfile;

import java.util.List;

public class EventView extends ProfileView {
    public EventView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void registerCommand() {

    }

    @Override
    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<EventProfile> eventProfiles = getProxy().getEventManager().getEventProfiles();

        for (EventProfile eventProfile : eventProfiles) {
            sb.append(
                    "EventProfile id: " + eventProfile.getEventId() +
                            "\tEventProfile condition: " + eventProfile.isEventCondition() +
                            "\r\n"
            );
        }
        return sb.toString();
    }
}
