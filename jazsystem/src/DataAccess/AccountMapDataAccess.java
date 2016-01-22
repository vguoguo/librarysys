package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.AccountMap;


public class AccountMapDataAccess {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator+"AccountMap";
	public static final String file="Login";
	public void saveAccountMap( AccountMap accountmap) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, file);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(accountmap);
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
	
	public AccountMap readAccountMap() {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		AccountMap accountmap = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, file);
			in = new ObjectInputStream(Files.newInputStream(path));
			accountmap = (AccountMap)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return accountmap;
	}
}
