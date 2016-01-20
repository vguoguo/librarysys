package DataAccess;

import Application.Author;
import Application.Book;
import Application.Copy;
import Application.Member;
import Application.Periodical;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


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
