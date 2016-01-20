package Application;

import java.util.HashMap;

public class AccountList {
	private HashMap<String, AccountEntry> accountList = new HashMap<>();

	public AccountEntry getEntry(String username){
		if(accountList.containsKey(username)) {
	        return accountList.get(username);
		}
		else
			return null;
	}

}
