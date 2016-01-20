package Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 3655031571906080109L;
private Member member;
private List<CheckOutEntry> checkoutentries;
public  CheckOutRecord(){
	this.member=new Member();
	this.checkoutentries=new ArrayList<CheckOutEntry>();
}
public  CheckOutRecord(Member member ){
	this.member=member;
	this.checkoutentries=new ArrayList<CheckOutEntry>();
}
public void addCheckOutEntry(CheckOutEntry checkoutentry){
	checkoutentries.add(checkoutentry);
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public List<CheckOutEntry> getCheckoutentries() {
	return checkoutentries;
}
public void setCheckoutentries(List<CheckOutEntry> checkoutentries) {
	this.checkoutentries = checkoutentries;
}

}
