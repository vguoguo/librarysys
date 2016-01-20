package Application;

import java.io.Serializable;

public class Author extends Person implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 335649839413030563L;
private int authorID;
private String credential;
private String bio;
public int getAuthorID() {
	return authorID;
}
public void setAuthorID(int authorID) {
	this.authorID = authorID;
}
public String getCredential() {
	return credential;
}
public void setCredential(String credential) {
	this.credential = credential;
}
public String getBio() {
	return bio;
}
public void setBio(String bio) {
	this.bio = bio;
}
public Author(int authorID, String credential, String bio) {
	super();
	this.authorID = authorID;
	this.credential = credential;
	this.bio = bio;
}
public Author() {
	super();
}

}
