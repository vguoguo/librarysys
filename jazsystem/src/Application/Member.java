package Application;

import java.io.Serializable;

public class Member implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1537736727478429134L;
private int memberID;
private CheckOutRecord checkoutrecord;

public Member() {
	super();
	this.memberID = 0;
	this.checkoutrecord=new CheckOutRecord();
}
public Member(int memberID) {
	super();
	this.memberID = memberID;
}
public Member(int memberID,CheckOutRecord checkoutrecord) {
	super();
	this.memberID = memberID;
	this.checkoutrecord=checkoutrecord;
}
public CheckOutRecord getCheckoutrecord() {
	return checkoutrecord;
}
public void setCheckoutrecord(CheckOutRecord checkoutrecord) {
	this.checkoutrecord = checkoutrecord;
}


public int getMemberID() {
	return memberID;
}

public void setMemberID(int memberID) {
	this.memberID = memberID;
}

}
