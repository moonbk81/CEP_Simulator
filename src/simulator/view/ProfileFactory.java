package simulator.view;

import simulator.control.SimulatorProxy;

public abstract class ProfileFactory {
    protected SimulatorProxy proxy;
    abstract ProfileView createProfileView(String object);
}
