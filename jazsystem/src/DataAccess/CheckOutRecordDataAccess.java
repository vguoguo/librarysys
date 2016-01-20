package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.CheckOutRecord;



public class CheckOutRecordDataAccess {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"CheckOutRecord";
	
	public void saveAuthor(int recordkey, CheckOutRecord checkoutrecord) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(recordkey));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(checkoutrecord);
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
	
	public CheckOutRecord readAuthor(int recordkey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		CheckOutRecord checkoutrecord = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(recordkey));
			in = new ObjectInputStream(Files.newInputStream(path));
			checkoutrecord = (CheckOutRecord)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return checkoutrecord;
	}
}
