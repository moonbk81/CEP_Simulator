package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.ComponentProfile;

import java.util.List;

public class ComponentView extends ProfileView {
    public ComponentView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void registerCommand() {

    }

    @Override
    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<ComponentProfile> components = getProxy().getComponentManager().getComponentProfiles();

        for (ComponentProfile component : components) {
            sb.append(
                    "Component complexity: " + component.getComplexity() +
                            "\tcomplexity range: " + component.getComplexityRange() +
                            "\tmemory consumption: " + component.getMemoryResource() +
                            "\tmemory consumption range: " + component.getMemoryRange() +
                            "\r\n"
            );
        }
        return sb.toString();
    }
}
