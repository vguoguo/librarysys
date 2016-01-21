package DataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.Member;

public class DataAccess {
	public static final String separator=System.getProperty("file.separator"); 
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ separator+"doc"+separator+"Storage"+separator;
	
	public void saveMember(int memberkey, Member member) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Member", String.valueOf(memberkey));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
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
	
	public Member readMember(int memberkey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Member member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Member", String.valueOf(memberkey));
			in = new ObjectInputStream(Files.newInputStream(path));
			member = (Member)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return member;
	}
	
	
	
	
	
}
