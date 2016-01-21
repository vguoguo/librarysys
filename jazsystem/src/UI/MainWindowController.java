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

	private Stage loginStage;
	private Stage mainStage;
	
	public void handleLogoutButton(ActionEvent event){
		loginStage.hide();
		mainStage.show();
	}
	
	public void setLoginStage(Stage loginStage) {
		this.loginStage = loginStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
}
