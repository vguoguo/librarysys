package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.Author;

public class AuthorDataAccess {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"Author";
	
	public void saveAuthor(int authorkey, Author author) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(authorkey));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(author);
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
	
	public Author readAuthor(int authorkey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Author book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(authorkey));
			in = new ObjectInputStream(Files.newInputStream(path));
			book = (Author)in.readObject();
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
