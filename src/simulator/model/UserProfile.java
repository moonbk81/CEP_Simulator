package simulator.model;

import java.util.*;

/**
 * 
 */
public class UserProfile {
    private String userId = "";
    private String userName = "";
    private String userEmail = "";
    private String contactNumber = "";
    private String userPassword = "";
    private ArrayList<SimulationSession> simulationSession = new ArrayList<SimulationSession>();

    public UserProfile() {
    	System.out.println("User Profile Data Created");
    }

    public UserProfile(String id, String name, String email, String contact, String passwd) {
    	this.userId = id;
    	this.userName = name;
    	this.userEmail = email;
    	this.contactNumber = contact;
    	this.userPassword = passwd;

    	System.out.println("Create User Profile with new informataion");
    }

    public void setUserId(String id) {
    	this.userId = id;
    }

    public String getUserId() {
    	return this.userId;
    }

    public void setUserName(String name) {
    	this.userName = name;
    }

    public String getUserName() {
    	return this.userName;
    }

    public void setUserEmail(String email) {
    	this.userEmail = email;
    }

    public String getUserEmail() {
    	return this.userEmail;
    }

    public void setContactNumber(String contact) {
    	this.contactNumber = contact;
    }

    public String getContactNumber()  {
    	return this.contactNumber;
    }

    public void setUserPassword(String passwd) {
    	this.userPassword = passwd;
    }

    public String getUserPassword() {
    	return this.userPassword;
    }
}