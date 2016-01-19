package DataAccess;

import Application.Author;
import Application.Book;
import Application.BookCopy;
import Application.Member;
import Application.Periodical;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Book book=new Book( "mois je sui le titre");
book.addBookCopy(new BookCopy());
BookDataAccess bda=new BookDataAccess();
bda.saveBook(1, book);
System.out.println(bda.readBook(1).getTitle()+"  is teh title ");

Member member=new Member();
MemberDataAccess MDA =new MemberDataAccess();
MDA.saveMember(1, member);

Author author =new Author();
AuthorDataAccess ADA=new AuthorDataAccess();
ADA.saveAuthor(1, author);

Periodical periodical=new Periodical();
periodicalDataAccess PDA =new periodicalDataAccess();
PDA.savePeriodival(1, periodical);

	}

}
