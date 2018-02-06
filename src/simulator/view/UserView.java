package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.UserProfile;

import java.util.List;

import static simulator.view.SimulatorCmdUI.scanner;

public class UserView extends ProfileView {
    public UserView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    public void registerCommand() {
        System.out.println("Please sign on");
        System.out.println("Enter user id: ");
        String userId = scanner.next();

        System.out.println("Enter user name: ");
        String userName = scanner.next();

        System.out.println("Enter email: ");
        String email = scanner.next();

        System.out.println("Enter contact number: ");
        String contactNumber = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        proxy.signOn(userId, userName, email, contactNumber, password);
    }

    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<UserProfile> users = getProxy().getUserManager().getUserProfiles();

        for (UserProfile user : users) {
            sb.append(
                    "User name: " + user.getUserName() +
                            "\tUser ID: " + user.getUserId() +
                            "\tEmail: " + user.getUserEmail() +
                            "\tContact: " + user.getContactNumber() +
                            "\r\n"
            );
        }

        return sb.toString();
    }
}
