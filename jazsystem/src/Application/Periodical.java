package Application;

import java.time.LocalDate;
import java.util.List;

public class Periodical extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2783593937556159287L;
	private LocalDate releasedate;
	private String ISSN;
	
	public Periodical() {
		super();
		this.releasedate = null;
		this.ISSN = "0";
	}
	
	public Periodical(String ISSN, LocalDate publicationdate, String title, List<Copy> copies,
			boolean isavailable, int max_day_borrow) {
		super("P"+ISSN, publicationdate, title, null, copies, isavailable, max_day_borrow);
		this.ISSN = ISSN;
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
