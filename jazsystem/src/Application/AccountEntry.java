package Application;

import java.io.Serializable;

public class AccountEntry implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1269620392729880133L;
	private int userID;
	private String username;
	private String password;
	private boolean isAdmin;
	private boolean isLibrarian;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isLibrarian() {
		return isLibrarian;
	}
	public void setLibrarian(boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}

}
