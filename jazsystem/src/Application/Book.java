package Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Publication implements Serializable{
private String title;
List<Author> authorsList;
List<BookCopy> bookCopyList;

public Book() {
	super();
	this.title = "";
	this.authorsList = new ArrayList<Author>();
	this.bookCopyList = new ArrayList<BookCopy>();
}
public Book(String title) {
	super();
	this.title = title;
	this.authorsList = new ArrayList<Author>();
	this.bookCopyList = new ArrayList<BookCopy>();
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public void addBookCopy(BookCopy bookcopy){
	
}
public List<BookCopy> getBookCopyList(){
	return this.bookCopyList;
}
}
