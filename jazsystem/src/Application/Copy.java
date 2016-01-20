package Application;

public class Copy {
private boolean available;
private int copiID;

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

public Copy(boolean available, int copiID) {
	super();
	this.available = available;
	this.copiID = copiID;
}

public Copy() {
	super();
	this.available=true;
	this.copiID=0;
	
}



}
