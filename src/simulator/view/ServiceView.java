package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.Component;
import simulator.model.Service;

import java.util.List;

public class ServiceView extends ProfileView {
    public ServiceView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void registerCommand() {

    }

    @Override
    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<Service> services = getProxy().getServiceManager().getServiceProfiles();

        for (Service service : services) {
            sb.append(
                    "Service event id: " + service.getEventId() +
                            "\tservice components: ");
            for (Component component : service.getComponents()) {
                sb.append(component.getComponent() + ", ");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
