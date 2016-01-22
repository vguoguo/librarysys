package UI;

import Application.Address;
import Application.Member;
import DataAccess.DataAccess;
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
	private TextField NameField;
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


	/*public void setmember(Member m_member) {
		this.m_member = m_member;

	//	IdField.setText(Integer.toString(m_member.getMemberID()));
		NameField.setText(m_member.getLastName());
		streetField.setText(m_member.getStreet());
		ZipField.setText(Integer.toString(m_member.getPostalCode()));
		cityField.setText(m_member.getCity());
		
	}*/
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {	
			Address address = new Address(streetField.getText(),cityField.getText(),
					StateField.getText(),Integer.parseInt(ZipField.getText()));
			
			m_member= new Member(Integer.parseInt(IdField.getText())
					, NameField.getText(), NameField.getText(),null, address,  null);

			okClicked = true;
			
			//Member member=new Member();
			DataAccess DA =new DataAccess();
			DA.saveMember(m_member.getMemberID(), m_member);
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

		if (NameField.getText() == null || NameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (IdField.getText() == null || IdField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid State!\n";
		}
		if (ZipField.getText() == null || ZipField.getText().length() == 0) {
			errorMessage += "No valid postal code!\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(ZipField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid postal code (must be an integer)!\n";
			}
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		/*if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
			errorMessage += "No valid birthday!\n";
		} else {
			if (!DateUtil.validDate(birthdayField.getText())) {
				errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
			}
		}*/

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
