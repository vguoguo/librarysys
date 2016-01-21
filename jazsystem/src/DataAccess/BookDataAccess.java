package DataAccess;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.Book;

public class BookDataAccess  {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"Book";
	//public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	public void saveBook(int ISBN, Book book) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(ISBN));
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
	
	public Book readBook(int ISBN) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Book book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(ISBN));
			File f = new File(OUTPUT_DIR);
			if (!f.exists()){
				System.out.println("Book doesnt exist");
				return null;
				
			}
			in = new ObjectInputStream(Files.newInputStream(path));
			book = (Book)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return book;
	}
}
