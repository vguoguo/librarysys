package UI;

import Application.Address;
import Application.CheckOutRecord;
import Application.Member;
import DataAccess.DataAccess;
//import DataAccess.MemberDataAccess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class EditMemberController {
	private Stage m_dialogStage;
	private Member m_member;
	
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
			IdField.setText(Integer.toString(m_member.getMemberID()));
			System.out.println(m_member.getFirstname());
			FirstNameField.setText(m_member.getFirstname());
			LastNameField.setText(m_member.getLastname());
			PhonenumberField.setText(m_member.getPhone());
			StateField.setText(m_member.getAddress().getState());
			streetField.setText(m_member.getAddress().getStreet());
			ZipField.setText(Integer.toString(m_member.getAddress().getZip()));
			cityField.setText(m_member.getAddress().getCity());	
	
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
			DataAccess MDA =new DataAccess();
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
	private boolean isInputValid() {
		String errorMessage = "";
		if (IdField.getText() == null || IdField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (FirstNameField.getText() == null || FirstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (LastNameField.getText() == null || LastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (PhonenumberField.getText() == null || PhonenumberField.getText().length() == 0) {
			errorMessage += "No valid Phone number!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		if (StateField.getText() == null || StateField.getText().length() == 0) {
			errorMessage += "No valid State!\n";
		}
		if (ZipField.getText() == null || ZipField.getText().length() == 0) {
			errorMessage += "No valid zip code!\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(ZipField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid zip code (must be an integer)!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(m_dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}


}
