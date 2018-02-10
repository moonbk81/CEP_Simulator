package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.AdapterProfile;

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
        List<AdapterProfile> adapterProfiles = getProxy().getAdapterManager().getAdapterProfiles();

        for (AdapterProfile adapterProfile : adapterProfiles) {
            sb.append(
                    "AdapterProfile complexity: " + adapterProfile.getComplexity() +
                            "\tmemory consumption: " + adapterProfile.getMemoryConsumption() +
                            "\tadapterProfile source type: " + adapterProfile.getSourceType() +
                            "\r\n"
            );
        }
        return sb.toString();
    }
}
