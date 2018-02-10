package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.ComponentProfile;
import simulator.model.ServiceProfile;

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
        List<ServiceProfile> serviceProfiles = getProxy().getServiceManager().getServiceProfiles();

        for (ServiceProfile serviceProfile : serviceProfiles) {
            sb.append(
                    "ServiceProfile event id: " + serviceProfile.getEventId() +
                            "\tserviceProfile components: ");
            for (ComponentProfile component : serviceProfile.getComponents()) {
                sb.append(component.getComponent() + ", ");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
