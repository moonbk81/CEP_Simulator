package simulator.view;

import simulator.control.SimulatorProxy;

public abstract class ProfileView {
    protected SimulatorProxy proxy;
    public ProfileView() {
    }
    public SimulatorProxy getProxy() {
        return proxy;
    }
    public abstract void registerCommand();
    public abstract String retrieveCommand();
}
