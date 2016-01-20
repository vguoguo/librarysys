package Application;

import java.util.HashMap;

public class AccountMap {
	private HashMap<String, AccountEntry> accountMap = new HashMap<>();

	public AccountEntry getEntry(String username){
		if(accountMap.containsKey(username)) {
	        return accountMap.get(username);
		}
		else
			return null;
	}

}
