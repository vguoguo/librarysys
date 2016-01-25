package UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Application.AccountEntry;
import Application.AccountMap;
import Application.Author;
import Application.Book;
import Application.CheckOutEntry;
import Application.CheckOutRecord;
import Application.Copy;
import Application.Item;
import Application.Member;
import Application.Periodical;
import DataAccess.AccountMapDataAccess;
import DataAccess.DataAccess;

public class SystemController {

	/*
	 * Login
	 */
	public boolean checkUserName(String username) {
		AccountMap accountmap = new AccountMapDataAccess().readAccountMap();
		return accountmap.contains(username);
	}

	public AccountEntry getUserAuthentification(String username, String password) {
		AccountMap accountmap = new AccountMapDataAccess().readAccountMap();
		AccountEntry account = accountmap.getEntry(username);
		if (account.getPassword().equals(password)) {
			return account;
		} else {
			return null;
		}
	}

	/*
	 * search member
	 */
	public Member searchMember(int memberID) {
		return new DataAccess().readMember(memberID);
	}

	public CheckOutRecord getMemberCheckOutRecord(Member member) {
		return member.getCheckoutrecord();
	}

	/*
	 * add new member
	 */
	public void saveMember(Member member) {
		new DataAccess().saveMember(member.getMemberID(), member);
	}

	/*
	 * generate memberID
	 */
	public int generateMemberID() {
		return new DataAccess().generateMemberID();
	}

	/*
	 * Add Book
	 */
	public void addBook(Book book) {
		new DataAccess().saveBook(book.getItemID(), book);
	}

	/*
	 * search Book
	 */
	public Book searchBook(String itemID) {
		return new DataAccess().readBook(itemID);
	}

	public int numberBookAvailabale(Book book) {
		List<Copy> copieslist = book.getCopies();
		int i = 0;
		for (Copy a : copieslist) {
			if (a.isAvailable()) {
				i++;
			}
		}
		return i;
	}

	/*
	 * Check out Book
	 */
	/** getfirst copy available **/
	public Copy getfirst_Bookcopy_available(Book book) {
		for (Copy a : book.getCopies()) {
			if (a.isAvailable()) {
				return a;
			}
		}
		return null;
	}

	/** xheck if its the only copy available: after **/
	public boolean isIt_more_OneCopy(Book book) {
		int i = 0;
		for (Copy a : book.getCopies()) {
			if (a.isAvailable()) {
				i++;
			}
		}
		if (i >= 2) {
			return true;
		} else {
			return false;
		}
	}

	/** check Book **/
	public boolean CheckOutBook(Member member, Book book) {
		if (!isIt_more_OneCopy(book)) {
			book.setIsavailable(false);
		}
		Copy copy = getfirst_Bookcopy_available(book);
		copy.setItemID(book.getItemID());
		copy.setAvailable(false);
		CheckOutEntry checkoutentry = new CheckOutEntry(LocalDate.now(),
				LocalDate.now().plusDays(book.getMax_day_borrow()), null,
				false, copy);

		member.getCheckoutrecord().addCheckOutEntry(checkoutentry);
		DataAccess data = new DataAccess();
		data.saveMember(member.getMemberID(), member);
		data.saveBook(book.getItemID(), book);
		return true;
	}

	/*
	 * Add Periodical
	 */
	public void addPeriodical(Periodical periodical) {
		new DataAccess().savePeriodical(periodical.getItemID(), periodical);
	}

	/*
	 * search periodical
	 */
	public Periodical searchPeriodical(String itemID) {
		return new DataAccess().readPeriodical(itemID);
	}

	public int numberPeriodicalAvailabale(Periodical periodical) {
		List<Copy> copieslist = periodical.getCopies();
		int i = 0;
		for (Copy a : copieslist) {
			if (a.isAvailable()) {
				i++;
			}
		}
		return i;
	}

	/*
	 * Check out Periodical
	 */
	/** getfirst copy available **/
	public Copy getfirst_Periodicalcopy_available(Periodical periodical) {
		for (Copy a : periodical.getCopies()) {
			if (a.isAvailable()) {
				return a;
			}
		}
		return null;
	}

	/** xheck if its the only copy available: after **/
	public boolean isIt_more_OneCopy(Periodical periodical) {
		int i = 0;
		for (Copy a : periodical.getCopies()) {
			if (a.isAvailable()) {
				i++;
			}
		}
		if (i >= 2) {
			return true;
		} else {
			return false;
		}
	}

	/** check out periodical **/
	public boolean Checkout(Member member, Periodical periodical) {
		if (!isIt_more_OneCopy(periodical)) {
			periodical.setIsavailable(false);
		}
		Copy copy = getfirst_Periodicalcopy_available(periodical);
		copy.setItemID(periodical.getItemID());
		copy.setAvailable(false);
		CheckOutEntry checkoutentry = new CheckOutEntry(LocalDate.now(),
				LocalDate.now().plusDays(periodical.getMax_day_borrow()), null,
				false, copy);

		member.getCheckoutrecord().addCheckOutEntry(checkoutentry);
		DataAccess data = new DataAccess();
		data.saveMember(member.getMemberID(), member);
		data.savePeriodical(periodical.getItemID(), periodical);
		return true;
	}

	/*
	 * search Author
	 */
	public Author searchAuthor(int authorID) {
		return new DataAccess().readAuthor(authorID);
	}

	/*
	 * add new Author
	 */
	public void saveAuthor(Author author) {
		new DataAccess().saveAuthor(author.getAuthorkey(), author);
	}

	/*
	 * generate AuthorID
	 */
	public int generateAuthorID() {
		return new DataAccess().generateAuthorID();
	}

	/*
	 * Print member checkout record
	 */
	public void printMemberCheckout(int memberID) {
		Member member = new DataAccess().readMember(memberID);
		System.out.println("<****Check Out record for the member #" + memberID
				+ " " + member.getFirstname() + " " + member.getLastname()
				+ "****>");
		System.out.println();
		String tit = "       Title";
		int addSpaceNumber = 19 - tit.length();
		for (int j = 0; j < addSpaceNumber; j++) {
			tit += " ";
		}
		System.out.println("######### |  Book/Periodical (ID) | " + tit
				+ " |  Checkout  | Due Date() | Returned | Returned Date");

		System.out.println();
		int i = 0;
		ArrayList<CheckOutEntry> checkoutentry = (ArrayList<CheckOutEntry>) member
				.getCheckoutrecord().getCheckoutentries();
		String b = new String();
		String ISXN = new String();
		String title = new String();
		Item book = new Book();
		Item periodical = new Periodical();
		for (CheckOutEntry a : checkoutentry) {
			i++;

			b = a.getCopy().getItemID();
			ISXN = (String) b.subSequence(1, b.length());
			if (b.charAt(0) == 'B') {
				b = "| ISBN : " + ISXN;
				book = searchBook("B" + ISXN);
				title = book.getTitle();
			} else if (b.charAt(0) == 'P') {
				b = "| ISSN : " + ISXN;
				periodical = searchPeriodical("P" + ISXN);
				title = periodical.getTitle();
			}

			addSpaceNumber = 20 - title.length();
			for (int j = 0; j < addSpaceNumber; j++) {
				title += " ";
			}
			System.out.println("Entry " + i + " : " + b + "   | " + title
					+ "| " + a.getM_CheckoutDate() + " | " + a.getM_DueDate()
					+ " | " + (a.isIsreturned() ? "   YES   " : "   NO   ")
					+ " | " + ((a.getDatereturned()==null) ? "" : a.getDatereturned()));
		}
	}

}
