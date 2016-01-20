package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.CheckOutEntry;


public class CheckOutEntryDataAccess {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"CheckOutEntry";
	
	public void saveAuthor(int entrykey, CheckOutEntry checkoutentry) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(entrykey));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(checkoutentry);
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
	
	public CheckOutEntry readAuthor(int entrykey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		CheckOutEntry checkoutentry = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(entrykey));
			in = new ObjectInputStream(Files.newInputStream(path));
			checkoutentry = (CheckOutEntry)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return checkoutentry;
	}
}
