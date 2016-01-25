package UI;

import Application.AccountEntry;
import Application.Address;
import Application.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainWindowController {
	@FXML
	private Label accountNameLabel;
	
	@FXML
	private Label adminRoleLabel;
	
	@FXML
	private Label libRoleLabel;
	
	@FXML
	private ChoiceBox<String> isbnChoicebox;
	
	@FXML
	private TextField itemIdSearchField;
	
	@FXML
	private Button searchItemButton;

	@FXML
	private Button beginCheckoutButton;
	
	@FXML
	private Button addBookButton;
	
	@FXML
	private Button addPeriodicalButton;
	
	@FXML
	private Button addCopyButton;
	
	@FXML
	private Button searchMemberButton;
	
	@FXML
	private Button showRecordButton;
	
	@FXML
	private Button editMemberButton;
	
	@FXML
	private Button addMemberButton;

	@FXML
	private TextField memberIdSearchField;
	@FXML
	private TextField memberFirstnameField;
	@FXML
	private TextField memberLastnameField;
	@FXML
	private TextField memberIdShowField;
	@FXML
	private TextField memberStreetField;
	@FXML
	private TextField memberCityField;
	@FXML
	private TextField memberStateField;
	@FXML
	private TextField memberZipField;
	@FXML
	private TextField memberPhoneField;
	
	
	private Main mainApp;
	private Stage loginStage;
	private Stage mainStage;
	private Alert alert = new Alert(AlertType.ERROR);


	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	public void setLoginStage(Stage loginStage) {
		this.loginStage = loginStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	public void initRole(AccountEntry account){
		accountNameLabel.setText(account.getUsername());
		if (! account.isAdmin())
			disableAdminButtons();
		if (! account.isLibrarian())
			disableLibrarianButtons();
	}
	
	private void disableLibrarianButtons(){
		libRoleLabel.setDisable(true);
		beginCheckoutButton.setDisable(true);
		showRecordButton.setDisable(true);
	}
	
	private void disableAdminButtons(){
		adminRoleLabel.setDisable(true);
		addBookButton.setDisable(true);
		addPeriodicalButton.setDisable(true);
		addCopyButton.setDisable(true);
		editMemberButton.setDisable(true);
		addMemberButton.setDisable(true);
	}
	
	private void enableButtons(){
		libRoleLabel.setDisable(false);
		beginCheckoutButton.setDisable(false);
		showRecordButton.setDisable(false);
		adminRoleLabel.setDisable(false);
		addBookButton.setDisable(false);
		addPeriodicalButton.setDisable(false);
		addCopyButton.setDisable(false);
		editMemberButton.setDisable(false);
		addMemberButton.setDisable(false);
	}
	
	@FXML
	public void handleLogoutButton(ActionEvent event){
		mainStage.hide();
		loginStage.show();
		enableButtons();
	}
	
	@FXML
	public void handleSearchMember(ActionEvent event){
		String idText = memberIdSearchField.getText();

		showAlert("Error", "Invalid member ID", "Member ID is digits and cannot be empty!");
	}
	
	@FXML
	public void handleAddMemberButton(){
		System.out.println("call Add_Member");
		Application.Member tempPerson;// = new Member();
	//	mainpage.getPersonData().add(tempPerson);
		boolean SubmitClicked = mainApp.showEditMemberDialog(null);
	}

	@FXML
	public void handleEditMemberButton(){
		System.out.println("call Edit_Member");
//test code			
		Address address = new Address("4th","fairfeld","iowa",52557);
		Member tempPerson = new Member(1001,"abd","def","10086",address,null);
//test code				// String phone, Address address,CheckOutRecord checkoutrecord) {
					
	//	mainpage.getPersonData().add(tempPerson);
		boolean SubmitClicked = mainApp.showEditMemberDialog(tempPerson);
	}
	
	@FXML
	public void handleAddBookButton(){
		System.out.println("call Add_Book");
		boolean SubmitClicked = mainApp.showAddBookDialog(/*tempBook*/);
	}
	
	@FXML
	public void handleAddPeriodicalButton(){
		System.out.println("call Add_Periodical");
		boolean SubmitClicked = mainApp.showAddPeriodicalDialog(/*tempBook*/);
	}
	
	
	private void showAlert(String title, String header, String content){
		alert.initOwner(mainStage);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
}
