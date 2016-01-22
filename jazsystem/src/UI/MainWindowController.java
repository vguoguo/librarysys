package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainWindowController {
	@FXML
	private TextField itemIdField;

	@FXML
	private ChoiceBox<String> isbnORissn;

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
		boolean SubmitClicked = mainApp.showEditMemberDialog();
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
