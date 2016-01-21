package DataAccess;

import java.time.LocalDate;

import Application.AccountEntry;
import Application.AccountMap;
import Application.Address;
import Application.Author;
import Application.Book;
import Application.CheckOutEntry;
import Application.CheckOutRecord;
import Application.Copy;
import Application.Item;
import Application.Member;
import Application.Periodical;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
Member member=new Member();
MemberDataAccess MDA =new MemberDataAccess();
MDA.saveMember(1, member);

Author author =new Author();
AuthorDataAccess ADA=new AuthorDataAccess();
ADA.saveAuthor(1, author);

Periodical periodical=new Periodical();
periodicalDataAccess PDA =new periodicalDataAccess();
PDA.savePeriodival(1, periodical);
*/
		
		
		Member member=new Member("abdel", "faddaoui", "0664596720", new Address("1000 N", "fairfield", "IOWA", 52557), 0123,
				new CheckOutRecord());	
		member.getCheckoutrecord().addCheckOutEntry(new CheckOutEntry(LocalDate.now(), LocalDate.now(),
				new Copy()));
		
		
		System.out.println(member.getLastname()+"**address**"+member.getAddress().getCity()+"**checkoutrecord**"+
				member.getCheckoutrecord().getCheckoutID()+"**checkout entry date**"+member.getCheckoutrecord().getCheckoutentries().get(0).getM_CheckoutDate()+"book int "+
				member.getCheckoutrecord().getCheckoutentries().get(0).getBookORperiodical().getItemID()); 
		
		MemberDataAccess MDA =new MemberDataAccess();
		MDA.saveMember(1, member);
		
		MemberDataAccess MD =new MemberDataAccess();
		Member membe=new Member();
		membe=MD.readMember(1);
		
		System.out.println(membe.getLastname()+"**address**"+membe.getAddress().getCity()+"**checkoutrecord**"+
				membe.getCheckoutrecord().getCheckoutID()+"**checkout entry date**"+membe.getCheckoutrecord().getCheckoutentries().get(0).getM_CheckoutDate()+"book int "+
				membe.getCheckoutrecord().getCheckoutentries().get(0).getBookORperiodical().getItemID()); 
		/*
		 * hard code interface user
		 */
		AccountEntry user1=new AccountEntry(1,"joy","mwhkqj2",true,true);
		AccountEntry user2=new AccountEntry(1,"zhithian","123kkiu",true,false);
		AccountEntry user3=new AccountEntry(1,"joy","1opiu",false,true);
		AccountMap map=new AccountMap();
		map.addEntry(user1);
		map.addEntry(user2);
		map.addEntry(user3);
		AccountMapDataAccess amda=new AccountMapDataAccess();
		amda.saveAccountMap("Login", map);
		System.out.println(map.getEntry("joy").getPassword());
		AccountMapDataAccess ama=new AccountMapDataAccess();
		ama.readAccountMap("Login");
		System.out.println(map.getEntry("joy").getPassword());
		/*
		 * harde code 
		 */
		
		
		/*
		 * harde code 
		 */
		
		
		/*
		 * harde code 
		 */
		
	}

}
