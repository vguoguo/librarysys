package Application;

import java.time.LocalDate;
import java.util.List;

public class Periodical extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2783593937556159287L;
	private int periodicalID;
	private LocalDate releasedate;
	private String ISSN;
	
	public Periodical() {
		super();
		this.periodicalID=0;
		this.releasedate = null;
		this.ISSN = "0";
	}
	public Periodical(LocalDate releasedate, String iSSN) {
		super();
		this.releasedate = releasedate;
		this.ISSN = iSSN;
	}
	public Periodical(int periodicalID, LocalDate releasedate, String iSSN) {
		super();
		this.periodicalID = periodicalID;
		this.releasedate = releasedate;
		this.ISSN = iSSN;
	}
	public Periodical(String ISSN, LocalDate publicationdate, String title, List<Author> authors, List<Copy> copies,
			boolean isavailable, int max_day_borrow) {
		super("P"+ISSN, publicationdate, title, authors, copies, isavailable, max_day_borrow);
		this.ISSN = ISSN;
	}
	
	public int getPeriodicalID() {
		return periodicalID;
	}
	public void setPeriodicalID(int periodicalID) {
		this.periodicalID = periodicalID;
	}
	public LocalDate getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}
	public String getISSN() {
		return ISSN;
	}

}
