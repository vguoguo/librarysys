package Application;

import java.time.LocalDate;
import java.util.List;

public class Book extends Item {
/**
	 * 
	 */
	private static final long serialVersionUID = 3301463621028266684L;

private int ISBN;
public Book(int ISBN, LocalDate publicationdate, String title, List<Author> authors, List<Copy> copies,
		boolean isavailable, int max_day_borrow) {
	super("B"+String.valueOf(ISBN), publicationdate, title, authors, copies, isavailable, max_day_borrow);
	this.ISBN = ISBN;
}

public Book() {
	super();
	this.ISBN = 0;
}

public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}


}
