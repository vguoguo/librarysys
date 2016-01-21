package Application;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8499694457263021148L;
	private LocalDate m_CheckoutDate;
	private LocalDate m_DueDate;
	private LocalDate datereturned;
	private boolean isreturned;
	private Copy copy;
	private FineRecord finerecord;
	
	public CheckOutEntry(LocalDate m_CheckoutDate, LocalDate m_DueDate,
			Copy copy) {
		super();
		this.m_CheckoutDate = m_CheckoutDate;
		this.m_DueDate = m_DueDate;
		this.isreturned = false;
		this.copy = copy;
	}
	public CheckOutEntry(LocalDate m_CheckoutDate, LocalDate m_DueDate,  boolean isreturned,
			Copy copy) {
		super();
		this.m_CheckoutDate = m_CheckoutDate;
		this.m_DueDate = m_DueDate;
		this.isreturned = isreturned;
		this.copy = copy;
	}
	public CheckOutEntry(LocalDate m_CheckoutDate, LocalDate m_DueDate, LocalDate datereturned, boolean isreturned,
			Copy copy) {
		super();
		this.m_CheckoutDate = m_CheckoutDate;
		this.m_DueDate = m_DueDate;
		this.datereturned = datereturned;
		this.isreturned = isreturned;
		this.copy = copy;
	}
	public LocalDate getM_CheckoutDate() {
		return m_CheckoutDate;
	}
	public void setM_CheckoutDate(LocalDate m_CheckoutDate) {
		this.m_CheckoutDate = m_CheckoutDate;
	}
	public LocalDate getM_DueDate() {
		return m_DueDate;
	}
	public void setM_DueDate(LocalDate m_DueDate) {
		this.m_DueDate = m_DueDate;
	}
	public LocalDate getDatereturned() {
		return datereturned;
	}
	public void setDatereturned(LocalDate datereturned) {
		this.datereturned = datereturned;
	}
	public boolean isIsreturned() {
		return isreturned;
	}
	public void setIsreturned(boolean isreturned) {
		this.isreturned = isreturned;
	}
	public Copy getCopy() {
		return copy;
	}
	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	public FineRecord getFinerecord() {
		return finerecord;
	}
	public void setFinerecord(FineRecord finerecord) {
		this.finerecord = finerecord;
	}
	
	
	
	
}
