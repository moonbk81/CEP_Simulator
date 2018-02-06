package simulator.model;

import java.util.*;

/**
 * 
 */
public class Profile {
    public enum ProfileEnum {
        PROFILE_TYPE_EVENT_SOURCE,
        PROFILE_TYPE_EVENT_SERVICE,
        PROFILE_TYPE_EVENT,
        PROFILE_TYPE_ADAPTER,
        PROFILE_TYPE_COMPONENT,
        PROFILE_TYPE_SYSTEM
    }
    protected String profileName;
    protected int profileId;
    protected ProfileEnum type;
    
    public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public ProfileEnum getType() {
		return type;
	}
	public void setType(ProfileEnum type) {
		this.type = type;
	}
	


}