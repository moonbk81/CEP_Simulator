package simulator.view;

import simulator.control.SimulatorProxy;

public class AllProfileFactory extends ProfileFactory {
    public AllProfileFactory(SimulatorProxy proxy) {
        super();
        this.proxy = proxy;
    }

    @Override
    ProfileView createProfileView(String object) {
        switch (object) {
            case "user" : return new UserView(proxy);
            case "system" : return new SystemView(proxy);
            case "source" : return new SourceView(proxy);
            case "adapter" : return new AdapterView(proxy);
            case "event" : return new EventView(proxy);
            case "service" : return new ServiceView(proxy);
            case "component" : return new ComponentView(proxy);
        }
        return null;
    }
}
