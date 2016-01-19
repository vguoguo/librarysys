package DataAccess;

import java.io.IOException;
import java.io.ObjectOutputStream;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.Book;

public class DataAccessFacade implements DataAccess {
	static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"src"+separator+"Storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	@Override
	public void saveBook(String name, Book book) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(book);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
		
	}
	@Override
	public Book readBook(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
