package Application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -8481021002349726268L;
	private String itemID;
	private LocalDate publicationdate;
	private String title;
	private List<Author> authors;
	private List<Copy> copies;
	private boolean isavailable;
	private int max_day_borrow;

	
	public Item() {
		super();
		this.itemID = "";
		this.title = "";
		this.authors = new ArrayList<Author>();
		this.copies = new ArrayList<Copy>();
		this.isavailable = true;
		this.max_day_borrow = 0;
	}
	public Item(String itemID, LocalDate publicationdate, String title, List<Author> authors, List<Copy> copies,
			boolean isavailable, int max_day_borrow) {
		super();
		this.itemID = itemID;
		this.publicationdate = publicationdate;
		this.title = title;
		this.authors = authors;
		this.copies=copies;
		this.copies = copies;
		this.isavailable = isavailable;
		this.max_day_borrow = max_day_borrow;
	}
	
	public void addCopy(Copy copy){
		this.copies.add(copy);
	}
	public void addAuthor(Author author){
		this.authors.add(author);
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public LocalDate getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(LocalDate publicationdate) {
		this.publicationdate = publicationdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Copy> getCopies() {
		return copies;
	}
	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public int getMax_day_borrow() {
		return max_day_borrow;
	}
	public void setMax_day_borrow(int max_day_borrow) {
		this.max_day_borrow = max_day_borrow;
	}

}
