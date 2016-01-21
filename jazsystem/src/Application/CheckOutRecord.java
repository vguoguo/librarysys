package Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 3655031571906080109L;
private List<CheckOutEntry> checkoutentries;
public  CheckOutRecord(){
	this.checkoutentries=new ArrayList<CheckOutEntry>();
}
public  CheckOutRecord(List<CheckOutEntry> checkoutentries){
	this.checkoutentries=checkoutentries;
}
public void addCheckOutEntry(CheckOutEntry checkoutentry){
	checkoutentries.add(checkoutentry);
}
public boolean removeCheckOutEntry(CheckOutEntry checkoutentry){
	return checkoutentries.remove(checkoutentry);
}


public List<CheckOutEntry> getCheckoutentries() {
	return checkoutentries;
}
public void setCheckoutentries(List<CheckOutEntry> checkoutentries) {
	this.checkoutentries = checkoutentries;
}

}
