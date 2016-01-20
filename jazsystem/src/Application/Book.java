package Application;



public class Book extends Item {
/**
	 * 
	 */
	private static final long serialVersionUID = 3301463621028266684L;
private int bookID;
private int ISBN;
public int getBookID() {
	return bookID;
}
public void setBookID(int bookID) {
	this.bookID = bookID;
}
public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}
public Book(int bookID, int iSBN) {
	super();
	this.bookID = bookID;
	ISBN = iSBN;
}
public Book(int iSBN) {
	super();
	this.bookID = 0;
	ISBN = iSBN;
}
public Book() {
	super();
	this.bookID = 0;
	this.ISBN = 0;
}


}
