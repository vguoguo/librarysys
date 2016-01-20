package Application;

public class Person {
private String firstname;
private String lastname;
private int phone;
private Address address;

public Person() {
	super();
	this.firstname = "";
	this.lastname = "";
	this.phone = 0;
	this.address=new Address();
}
public Person(String firstname, String lastname, int phone) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.phone = phone;
	this.address=new Address();
}
public Person(String firstname, String lastname, int phone, Address address) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.phone = phone;
	this.address = address;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

}
