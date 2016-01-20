package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import Application.Periodical;

public class periodicalDataAccess {
	public static final String separator=System.getProperty("file.separator");
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"Periodical";
	
	public void savePeriodival(int periodicalkey, Periodical periodical) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(periodicalkey));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(periodical);
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
	
	public Periodical readMember(int periodicalkey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Periodical periodical = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, String.valueOf(periodicalkey));
			in = new ObjectInputStream(Files.newInputStream(path));
			periodical = (Periodical)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return periodical;
	}
}
