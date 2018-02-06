package simulator.view;

import simulator.control.SimulatorProxy;

import java.util.Scanner;

public class SimulatorCmdUI {
    public static Scanner scanner = new Scanner(System.in);
    private SimulatorProxy proxy;
    private ProfileFactory factory;

    public SimulatorCmdUI(SimulatorProxy proxy) {
        super();
        this.proxy = proxy;
        factory = new AllProfileFactory(proxy);
        proxy.generateSampleData();
    }

    public String convertCommandToObject(int command) {
        if (command == 0) return "";
        else if (command % 7 == 1) return "user";
        else if (command % 7 == 2) return "system";
        else if (command % 7 == 3) return "source";
        else if (command % 7 == 4) return "adapter";
        else if (command % 7 == 5) return "event";
        else if (command % 7 == 6) return "component";
        else if (command % 7 == 0) return "service";
        return "";
    }

    public void start() {
        boolean quit = false;

        while (!quit) {
            int command = getMainMenuCommand();

            ProfileView view = factory.createProfileView(convertCommandToObject(command));

            if (command == 0) {
                quit = true;
                continue;
            }
            if (command < 8) {
                view.registerCommand();
            } else {
                System.out.println("Retrieve " + convertCommandToObject(command) + " profile");
                System.out.println(view.retrieveCommand());
                System.out.println("End of list");
            }
        }
        System.out.println("Bye");
    }

    public int getMainMenuCommand() {
        System.out.println("\r\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. Sign On");
        System.out.println("\t 2. Register System Profile");
        System.out.println("\t 3. Register Source Profile");
        System.out.println("\t 4. Register Adapter profile");
        System.out.println("\t 5. Register Event profile");
        System.out.println("\t 6. Register Component profile");
        System.out.println("\t 7. Register Service Profile");
        System.out.println("\t 8. Retrieve User Profile");
        System.out.println("\t 9. Retrieve System Profiles");
        System.out.println("\t 10. Retrieve Source Profiles");
        System.out.println("\t 11. Retrieve Adapter Profiles");
        System.out.println("\t 12. Retrieve Event Profiles");
        System.out.println("\t 13. Retrieve Component Profiles");
        System.out.println("\t 14. Retrieve Service Profiles");

        int command = scanner.nextInt();

        return command;
    }

}
