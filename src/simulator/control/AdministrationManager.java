package simulator.control;
import simulator.control.interfaces.IAdministrationManager;
import simulator.model.UserProfile;

public class AdministrationManager implements IAdministrationManager {
	private SimulatorProxy proxy;
	public AdministrationManager(SimulatorProxy si) {
		System.out.println("Create AdministrationMaanger");
		this.proxy = si;
	}

	public boolean logIn(String id, String pwd) {
		if (proxy.getUserManager().isRegistered(id)) {
			System.out.println("Logged in");
			return true;
		} else {
			System.out.println("no user information");
		}
		return false;
	}
	public void logOut() {
		System.out.println("Logged out");
	}

	public void signOn(String id, String name, String email, String number, String pwd) {
		UserProfile profile = new UserProfile(id, name, email, number, pwd);
		proxy.getUserManager().registerProfile(profile);
	}
	public void retrieveSession() {

	}
}