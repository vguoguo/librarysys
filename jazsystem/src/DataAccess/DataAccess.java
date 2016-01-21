package DataAccess;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import Application.Book;
import Application.Member;
import Application.Periodical;

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
			File f = new File(OUTPUT_DIR+"Member");
			if (!f.exists()){
				System.out.println("member doesnt exist");
				return null;
				
			}
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
	public void savePeriodival(String periodicalkey, Periodical periodical) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Periodical", periodicalkey);
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
	
	public Periodical readPeriodical(String periodicalkey) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Periodical periodical = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Periodical", periodicalkey);
			in = new ObjectInputStream(Files.newInputStream(path));
			File f = new File(OUTPUT_DIR+"Periodical");
			if (!f.exists()){
				System.out.println("periodical doesnt exist");
				return null;
				
			}
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
	
	public void saveBook(String ISBN, Book book) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Book", ISBN);
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
	
	public Book readBook(String ISBN) {
		// TODO Auto-generated method stub
		ObjectInputStream in = null;
		Book book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"Book", ISBN);
			File f = new File(OUTPUT_DIR+"Book");
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
