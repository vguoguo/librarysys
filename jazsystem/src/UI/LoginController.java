package UI;

import java.awt.Color;

import Application.AccountEntry;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	private Main mainApp;
	private Stage loginStage;
	private Stage mainStage;
	
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	public void CrossClickButton(ActionEvent event){
		usernameField.setText("");
		usernameField.requestFocus();
	}
	public void CrossButton(ActionEvent event){
		passwordField.setText("");
		passwordField.requestFocus();
	}
	public void handleLoginButton(ActionEvent event){
		String red="-fx-border-color: #FF0000;";
		usernameField.setStyle("");
		passwordField.setStyle("");
		String username =usernameField.getText();
		String password=passwordField.getText();
		if(username.equals("") && password.equals("")){
			usernameField.setStyle(red);
			passwordField.setStyle(red);
			ErrorAlert("Error Dialog","Login Error","The Username & the password fields are empty");	
		}else{
			if(password.equals("")){
				passwordField.setStyle(red);
				ErrorAlert("Error Dialog","Login Error","The password field is empty");
			}else if(username.equals("")){
				usernameField.setStyle(red);
				ErrorAlert("Login Failed","Password Error","The username field is empty");
			}else{
				SystemController syscrtl=new SystemController();
				if(syscrtl.checkUserName(username)){
					 AccountEntry account=syscrtl.getUserAuthentification(username, password);
					 if(account==null){
						ErrorAlert("Login Failed ","Password Error","Retype the Password !");
						passwordField.setStyle(red);
					 }else{
						setRoleForMainStage(account);
						loginStage.hide();
						usernameField.clear();
						passwordField.clear();
						usernameField.requestFocus();
						mainStage.show();
					 }
				}else{
						usernameField.setStyle(red);
						ErrorAlert("Login Failed ","Login Error","Retype the Login !");
				}
			}
			
		}
	}
	
	private void setRoleForMainStage(AccountEntry account){
		MainWindowController mainWindowController = this.mainApp.getMainWindowController();
		mainWindowController.initRole(account);
	}
	
	public void ErrorAlert(String a,String b,String c){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(a);
		alert.setHeaderText(b);
		alert.setContentText(c);

		alert.showAndWait();
	}
	public void handleExitButton(ActionEvent event){
		Platform.exit();
	}

	public void setLoginStage(Stage loginStage) {
		this.loginStage = loginStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	public void usernameRequestFocus(){
		usernameField.requestFocus();
	}

}
