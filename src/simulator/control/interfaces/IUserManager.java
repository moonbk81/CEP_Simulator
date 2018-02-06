package simulator.control.interfaces;
import simulator.model.UserProfile;

import java.util.ArrayList;

public interface IUserManager {

	void registerProfile(UserProfile profile);
	void deleteProfile(int index);
	void modifyProfile(int index, UserProfile profile);
	UserProfile retrieveProfile(int index);

	boolean isRegistered(String id);
	ArrayList<UserProfile> getUserProfiles();
}