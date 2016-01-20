package Application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Logger;


public class AccountMap  implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6136307103175364853L;
	private Logger logger = Logger.getLogger(AccountMap.class.getName());

	private HashMap<String, AccountEntry> accountMap = new HashMap<>();



	public HashMap<String, AccountEntry> getAccountMap() {
		return accountMap;
	}



	public void setAccountMap(HashMap<String, AccountEntry> accountMap) {
		this.accountMap = accountMap;
	}



	public AccountEntry getEntry(String username){
		if(accountMap.containsKey(username))
	        return accountMap.get(username);
		else
			return null;
	}

	public boolean addEntry(AccountEntry ae){
		String username = ae.getUsername();
		if(accountMap.containsKey(username))
			return false;

		accountMap.put(username, ae);
		return true;
	}

}
