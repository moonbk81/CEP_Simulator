package simulator.control.interfaces;
public interface IAdministrationManager {
	boolean logIn(String id, String pwd);
	void logOut();
	void signOn(String id, String name, String email, String number, String pwd);
	void retrieveSession();
}