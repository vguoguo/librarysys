package Application;

public class Address {
String street;
String city;
String state;
int Zip;
public Address() {
	super();
	this.street = "";
	this.city = "";
	this.state = "";
	this.Zip = 0;
}
public Address(String street, String city, String state, int zip) {
	super();
	this.street = street;
	this.city = city;
	this.state = state;
	Zip = zip;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getZip() {
	return Zip;
}
public void setZip(int zip) {
	Zip = zip;
}

}
