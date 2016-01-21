package Application;

import java.io.Serializable;

public class Copy implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -5735500249647242863L;
private boolean available;
private int copiID;
private String ItemID;
public Copy(boolean available, int copiID,String ItemID) {
	super();
	this.available = available;
	this.copiID = copiID;
	this.setItemID(ItemID);
}

public Copy() {
	super();
	this.available=true;
	this.copiID=0;
	
}
public boolean isAvailable() {
	return available;
}

public void setAvailable(boolean available) {
	this.available = available;
}

public int getCopiID() {
	return copiID;
}

public void setCopiID(int copiID) {
	this.copiID = copiID;
}



public String getItemID() {
	return ItemID;
}

public void setItemID(String itemID) {
	ItemID = itemID;
}



}
