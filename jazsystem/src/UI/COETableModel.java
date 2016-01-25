package UI;

import javafx.beans.property.SimpleStringProperty;

public class COETableModel {
	private final SimpleStringProperty checkoutDate = new SimpleStringProperty(
			"");
	private final SimpleStringProperty dueDate = new SimpleStringProperty("");
	private final SimpleStringProperty itemId = new SimpleStringProperty("");
	private final SimpleStringProperty title = new SimpleStringProperty("");
	private final SimpleStringProperty copyId = new SimpleStringProperty("");
	private final SimpleStringProperty retDate = new SimpleStringProperty("");

	public COETableModel(){
		this("", "", "", "", "", "");
	}
	
	public COETableModel(String checkoutDate, String dueDate, String itemId, String title, String copyId, String retDate) {
		setCheckoutDate(checkoutDate);
		setDueDate(dueDate);
		setItemId(itemId);
		setTitle(title);
		setCopyId(copyId);
		setRetDate(retDate);
	}

	public String getCheckoutDate() {
		return checkoutDate.get();
	}

	public void setCheckoutDate(String str) {
		checkoutDate.set(str);
	}
    public String getDueDate() {
        return dueDate.get();
    }
    public void setDueDate(String str) {
    	dueDate.set(str);
    }
    public String getItemId() {
        return itemId.get();
    }
    public void setItemId(String str) {
    	itemId.set(str);
    }
    
    public String getTitle() {
        return title.get();
    }
    public void setTitle(String str) {
    	title.set(str);
    }
    public String getCopyId() {
        return copyId.get();
    }
    public void setCopyId(String str) {
    	copyId.set(str);
    }
    public String getRetDate() {
        return retDate.get();
    }
    public void setRetDate(String str) {
    	retDate.set(str);
    }
    
}
