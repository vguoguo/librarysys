package Application;

import java.io.Serializable;

public class Member implements Serializable{
String name;

public Member() {
	super();
	this.name = "";
}
public Member(String name) {
	super();
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
