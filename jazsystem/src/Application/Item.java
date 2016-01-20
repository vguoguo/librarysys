package Application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Item implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -8481021002349726268L;
	private int itemID;
	private LocalDate publicationdate;
	private String title;
	private List<Author> authors;
	private List<Copy> copies;
	private int number_of_copies;
	private boolean isavailable;
	private int max_day_borrow;



	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
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
	public int getNumber_of_copies() {
		return number_of_copies;
	}
	public void setNumber_of_copies(int number_of_copies) {
		this.number_of_copies = number_of_copies;
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
