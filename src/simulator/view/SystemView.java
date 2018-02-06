package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.SystemProfile;

import java.util.List;

import static simulator.view.SimulatorCmdUI.scanner;

public class SystemView extends ProfileView {
    public SystemView(SimulatorProxy proxy) {
        this.proxy = proxy;

    }

    public void registerCommand() {
        System.out.println("Please input system profile");
        System.out.println("Enter system name");
        String name = scanner.next();

        System.out.println("Enter system id");
        int id = scanner.nextInt();

        System.out.println("Enter core number of system");
        int core = scanner.nextInt();

        System.out.println("Enter max memory capability");
        int maxCapa = scanner.nextInt();

        System.out.println("Don't input processor, it is set as 1 by default");

        proxy.registerSystemProfile(name, id, core, maxCapa);
    }

    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<SystemProfile> systems = getProxy().getSystemManager().getSystemProfiles();

        for (SystemProfile system : systems) {
            sb.append(
                    "System name: " + system.getName() +
                            "\tSystem ID: " + system.getId() +
                            "\tCore num: " + system.getCoreNums() +
                            "\tMax Capa: " + system.getMaxMemoryCapa() +
                            "\r\n"
            );
        }

        return sb.toString();
    }
}
