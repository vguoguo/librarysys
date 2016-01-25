package UI;

import Application.Address;
import Application.CheckOutRecord;
import Application.Member;
import DataAccess.DataAccess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class EditMemberController {
	private Stage m_dialogStage;
	private Member m_member;
	private DataAccess MDA =new DataAccess();
	

	@FXML
	private Label headerLabel;
	@FXML
	private Label IdLabel;
	@FXML
	private TextField IdField;
	@FXML
	private TextField FirstNameField;
	@FXML
	private TextField LastNameField;
	@FXML
	private TextField PhonenumberField;
	
	@FXML
	private TextField streetField;
	@FXML
	private TextField StateField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField ZipField;
	private boolean okClicked = false;
	
	public void setDialogStage(Stage dialogStage) {
		this.m_dialogStage = dialogStage;
	}


	public void setmember(Member m_member) {
		this.m_member = m_member;
		if(m_member!=null){
			headerLabel.setText("Edit member information");
			IdField.setText(Integer.toString(m_member.getMemberID()));
//			IdLabel.setDisable(false);
			IdField.setDisable(true);
//			System.out.println(m_member.getFirstname());
			FirstNameField.setText(m_member.getFirstname());
			LastNameField.setText(m_member.getLastname());
			PhonenumberField.setText(m_member.getPhone());
			StateField.setText(m_member.getAddress().getState());
			streetField.setText(m_member.getAddress().getStreet());
			ZipField.setText(Integer.toString(m_member.getAddress().getZip()));
			cityField.setText(m_member.getAddress().getCity());	
	
		}
		else{
			headerLabel.setText("Add member information");
//			IdLabel.setDisable(true);
			IdField.setDisable(true);
			IdField.setText(Integer.toString(MDA.getNextMemberId()));
			FirstNameField.setText("");
			LastNameField.setText("");
			PhonenumberField.setText("");
			StateField.setText("");
			streetField.setText("");
			ZipField.setText("");
			cityField.setText("");	
		}
		//int memberID,String firstname, String lastname, String phone, Address address,CheckOutRecord checkoutrecord) {
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			Address address = new Address(streetField.getText(),cityField.getText(),
					StateField.getText(),Integer.parseInt(ZipField.getText()));
			
			m_member= new Member(Integer.parseInt(IdField.getText())
					, FirstNameField.getText(), LastNameField.getText(),PhonenumberField.getText(),
					address,  null);

			okClicked = true;
			
			//Member member=new Member();
			MDA.saveMember(m_member.getMemberID(), m_member);
			m_dialogStage.close();
		}
	}
	public boolean isOkClicked() {
		return okClicked;
	}
	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		m_dialogStage.close();
	}
	
	private boolean isDigitRule(String numStr){
		for (int i=0; i<numStr.length(); i++) {
			if (! Character.isDigit(numStr.charAt(i)))
				return false;
		}
		return true;
	}
	
	private boolean isLetterRule(String letterStr){
		for (int i=0; i<letterStr.length(); i++) {
			if (! Character.isLetter(letterStr.charAt(i)))
				return false;
		}
		return true;
	}
	
	private boolean isUpperCaseRule(String upperCaseStr){
		for (int i=0; i<2; i++) {
			if (! Character.isUpperCase(upperCaseStr.charAt(i)))
				return false;
		}
		return true;
	}
	
	
	
	private boolean isInputValid() {
		if (("".compareTo(IdField.getText()) == 0)
				|| ("".compareTo(FirstNameField.getText()) == 0)
				|| ("".compareTo(LastNameField.getText()) == 0)
				|| ("".compareTo(PhonenumberField.getText()) == 0)
				|| ("".compareTo(streetField.getText()) == 0)
				|| ("".compareTo(cityField.getText()) == 0)
				|| ("".compareTo(StateField.getText()) == 0)
				|| ("".compareTo(ZipField.getText()) == 0)) {
			return showErrorMsg("All fields must be nonempty!");
		}
		
		if (! isDigitRule(IdField.getText())){
			return showErrorMsg("Member ID must be digit!");
		}
		
		if (! isDigitRule(PhonenumberField.getText())){
			return showErrorMsg("Phone number must be digit!");
		}
		
		if (PhonenumberField.getText().length() != 10){
			return showErrorMsg("Phone number must be 10 digits!");
		}
		
		
		if (! isDigitRule(ZipField.getText())){
			return showErrorMsg("Zip number must be digit!");
		}
		
		if (ZipField.getText().length() != 5){
			return showErrorMsg("Zip number must be 5 digits!");
		}
		
		if (! isLetterRule(FirstNameField.getText())){
			return showErrorMsg("Firstname may not contain spaces or characters other than a-z, A-Z!");
		}
		
		if (! isLetterRule(LastNameField.getText())){
			return showErrorMsg("Lastname may not contain spaces or characters other than a-z, A-Z!");
		}

		if ((StateField.getText().length() != 2) || (! isUpperCaseRule(StateField.getText())))
			return showErrorMsg("State must have exactly two characters in the range A-Z!");


		return true;
	}
	
	private boolean showErrorMsg(String errorMessage){
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(m_dialogStage);
		alert.setTitle("Invalid Fields");
		alert.setHeaderText("Please correct invalid fields");
		alert.setContentText(errorMessage);

		alert.showAndWait();

		return false;
	}

}
