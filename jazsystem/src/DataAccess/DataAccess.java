package DataAccess;

import Application.Book;

public interface DataAccess {
	public void saveBook(String name, Book book);
	public Book readBook(String name);
}
