package DataAccess;

import Application.Book;
import Application.BookCopy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Book book=new Book( "mois je sui le titre");
book.addBookCopy(new BookCopy());
BookDataAccess bda=new BookDataAccess();
bda.saveBook(1, book);
System.out.println(bda.readBook(1).getTitle()+"  is teh title ");
	}

}
