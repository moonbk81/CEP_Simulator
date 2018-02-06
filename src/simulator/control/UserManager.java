package simulator.control;
import java.util.*;

import simulator.control.interfaces.IUserManager;
import simulator.model.UserProfile;

public class UserManager implements IUserManager {
	private ArrayList<UserProfile> userProfiles;
	private SimulatorProxy proxy;
	public UserManager(SimulatorProxy si) {
		userProfiles = new ArrayList<>();
		this.proxy = si;
	}

	/* (non-Javadoc)
	 * @see IUserManager#isRegistered(java.lang.String)
	 */
	public boolean isRegistered(String id) {
		if (userProfiles.size() < 1) {
			return false;
		}
		for (int i = 0; i < userProfiles.size(); i++) {
			if (userProfiles.get(i).getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void registerProfile(UserProfile profile) {
		if (userProfiles != null) {
			userProfiles.add(profile);
			System.out.println("added name:" +userProfiles.get(0).getUserId());
		}
	}

	public void deleteProfile(int index) {
		if (userProfiles != null && !userProfiles.isEmpty()) {
			userProfiles.remove(index);
		}
		
	}

	public void modifyProfile(int index, UserProfile profile) {
		if (userProfiles != null && !userProfiles.isEmpty()) {
			userProfiles.set(index, profile);
		}
		
	}

	public UserProfile retrieveProfile(int index) {
		UserProfile up = null;
		if (userProfiles != null && !userProfiles.isEmpty()) {
			up = userProfiles.get(index);
		}
		return up;
	}

	public ArrayList<UserProfile> getUserProfiles() {
		return userProfiles;
	}
}