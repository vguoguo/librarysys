package UI;

import Application.Address;
import Application.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainWindowController {
	@FXML
	private TextField itemIdSearchField;

	@FXML
	private ChoiceBox<String> isbnChoicebox;
	
	@FXML
	private Label accountNameLabel;
	
	@FXML
	private Label adminRoleLabel;
	
	@FXML
	private Label libRoleLabel;
	
	@FXML
	private Button addBookButton;
	
	@FXML
	private Button addPeriodicalButton;
	
	@FXML
	private Button beginCheckoutButton;
	
	

	private Main mainApp;
	private Stage loginStage;
	private Stage mainStage;


	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	public void setLoginStage(Stage loginStage) {
		this.loginStage = loginStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	@FXML
	public void handleLogoutButton(ActionEvent event){
		mainStage.hide();
		loginStage.show();
	}
	
	@FXML
	public void handleAddMemberButton(){
		System.out.println("call Add_Member");
		Application.Member tempPerson;// = new Member();
	//	mainpage.getPersonData().add(tempPerson);
		boolean SubmitClicked = mainApp.showEditMemberDialog(null);
	}

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
	
}
