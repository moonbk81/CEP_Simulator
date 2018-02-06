package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.Adapter;

import java.util.List;

public class AdapterView extends ProfileView {
    public AdapterView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void registerCommand() {

    }

    @Override
    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<Adapter> adapters = getProxy().getAdapterManager().getAdapterProfiles();

        for (Adapter adapter : adapters) {
            sb.append(
                    "Adapter complexity: " + adapter.getComplexity() +
                            "\tmemory consumption: " + adapter.getMemoryConsumption() +
                            "\tadapter source type: " + adapter.getSourceType() +
                            "\r\n"
            );
        }
        return sb.toString();
    }
}
