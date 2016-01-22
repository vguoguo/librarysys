package UI;

import java.awt.TextArea;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Application.Author;
import Application.Book;
import Application.Copy;
import Application.Periodical;
import DataAccess.DataAccess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPeriodicalController {

	private Stage m_dialogStage;
	private Periodical m_periodical;
	private boolean okClicked = false;
	
	@FXML
	private TextField TitleField;
	@FXML
	private TextField ISSNField;
	@FXML
	private TextField CopySumField;
	@FXML
	private TextField MaxDayBorrow;
	@FXML
	private DatePicker PubDatePicker;
	@FXML
	private DatePicker ReleseDatePicker;

	public void setDialogStage(Stage dialogStage) {
		this.m_dialogStage = dialogStage;
	}

/*
	public void setBook(Book m_book) {
		this.m_book = m_book;

		//IdField.setText(Integer.toString(m_book.getMemberID()));
		NameField.setText(m_book.getLastName());
		streetField.setText(m_book.getStreet());
		ZipField.setText(Integer.toString(m_book.getPostalCode()));
		cityField.setText(m_book.getCity());
		
	}*/
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {	
			System.out.println("handleOk");
		//	m_book.setMemberID(Integer.parseInt(IdField.getText()));
		//	m_book.setISBN(Integer.parseInt(ISBNField.getText()));
			//m_book.setTitle(TitleField.getText());
			//m_book.setIsavailable(true);
			System.out.println("handleOk  copynum");

			int copynum = Integer.parseInt(CopySumField.getText());
			List<Copy> copys= new ArrayList<Copy>();
			for(int i=0; i<copynum; i++){
				Copy periodicalCopy = new Copy(true,i,ISSNField.getText());
				copys.add(periodicalCopy);
			}
			System.out.println("handleOk  Periodical");

			m_periodical = new Periodical(ISSNField.getText(),PubDatePicker.getValue(),
								TitleField.getText(),copys,true,21);

			okClicked = true;
			DataAccess DA =new DataAccess();
			DA.savePeriodical(m_periodical.getISSN(), m_periodical);
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
		//return true;
				
		String errorMessage = "";
		
		if (TitleField.getText() == null || TitleField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (ISSNField.getText() == null || ISSNField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (CopySumField.getText() == null || CopySumField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		if (MaxDayBorrow.getText() == null || MaxDayBorrow.getText().length() == 0) {
			errorMessage += "No valid State!\n";
		}
		if (PubDatePicker.getValue() == null ) {
			errorMessage += "No valid postal code!\n";
		}
		if (ReleseDatePicker.getValue() == null) {
			errorMessage += "No valid Release Date!\n";
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
