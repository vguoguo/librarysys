package Application;

import java.io.Serializable;

public class Author extends Person implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 335649839413030563L;
	int authorkey;
	private String credential;
	private String bio;

	public int getAuthorkey() {
		return authorkey;
	}

	public void setAuthorkey(int authorkey) {
		this.authorkey = authorkey;
	}

	public Author() {
		super();
	}

	public Author(String credential, String bio) {
		super();
		this.credential = credential;
		this.bio = bio;
	}

	public Author(String firstname, String lastname, String phone, Address address, String credential, String bio) {
		super(firstname, lastname, phone, address);
		this.credential = credential;
		this.bio = bio;
	}
	public Author(int authorkey,String firstname, String lastname, String phone, Address address, String credential, String bio) {
		super(firstname, lastname, phone, address);
		this.authorkey=authorkey;
		this.credential = credential;
		this.bio = bio;
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

}
