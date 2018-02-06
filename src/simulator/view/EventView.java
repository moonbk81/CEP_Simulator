package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.Event;

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
        List<Event> events = getProxy().getEventManager().getEventProfiles();

        for (Event event : events) {
            sb.append(
                    "Event id: " + event.getEventId() +
                            "\tEvent condition: " + event.isEventCondition() +
                            "\r\n"
            );
        }
        return sb.toString();
    }
}
