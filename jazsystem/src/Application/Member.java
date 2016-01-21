package Application;

import java.io.Serializable;

public class Member extends Person implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1537736727478429134L;
	private int memberID;
	private CheckOutRecord checkoutrecord;
	

	public Member(int memberID,String firstname, String lastname, String phone, Address address,CheckOutRecord checkoutrecord) {
		super(firstname, lastname, phone, address);
		this.checkoutrecord = checkoutrecord;
		this.memberID=memberID;
	}


	public CheckOutRecord getCheckoutrecord() {
		return checkoutrecord;
	}
	public int getMemberID() {
		return this.memberID;
	}

}
