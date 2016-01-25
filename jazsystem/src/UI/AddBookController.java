package UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Application.Address;
import Application.Author;
import Application.Book;
import Application.Copy;
import Application.Member;
import DataAccess.DataAccess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AddBookController {
	private Stage m_dialogStage;
	private Book m_book;
	private boolean okClicked = false;
	
	@FXML
	private TextField TitleField;
	@FXML
	private TextField ISBNField;
	@FXML
	private TextField CopySumField;
	@FXML
	private TextField MaxdayBorrow;
	@FXML
	private DatePicker Publicationdate;
	@FXML
	private TextArea CredentialsArea;
	@FXML
	private TextArea ShortBioArea;
	@FXML
	private TextField FirstNameField;
	@FXML
	private TextField LastNameField;
	@FXML
	private TextField PhoneNumberField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField StateField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField ZipField;
	@FXML
	private Label authorListArea;
	
	
	private List <Author> authors= new ArrayList<Author>();
	private String authorslist="";
	public void setDialogStage(Stage dialogStage) {
		this.m_dialogStage = dialogStage;
	}

	public void clearInputField(){
		ISBNField.clear();
		TitleField.clear();
		Publicationdate.getEditor().clear();
		CopySumField.clear();
		MaxdayBorrow.clear();
		authorListArea.setText("");
		SetAuthorasNull();
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

			m_book = new Book(ISBNField.getText(),Publicationdate.getValue(),TitleField.getText(),
					authors,null,true,21);
			okClicked = true;
			DataAccess DA =new DataAccess();
			DA.saveBook(m_book.getISBN(), m_book);
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
	
	@FXML
	private void handleAddAuthor() {
//		System.out.println("handleAddAuthor");
		//m_dialogStage.close();
		if(isInputValidofAuthor()){
			Address address = new Address(streetField.getText(),cityField.getText(),
					streetField.getText(),Integer.parseInt(ZipField.getText()));
			
			Author author = new Author(FirstNameField.getText(),LastNameField.getText(),
					PhoneNumberField.getText(),
					address,CredentialsArea.getText(),ShortBioArea.getText());		
			authors.add(author);
			authorslist+=FirstNameField.getText()+" "+LastNameField.getText()+"\n";
			System.out.println(authorslist);
			authorListArea.setText(authorslist);
			SetAuthorasNull();
		}
	}
	
	private void SetAuthorasNull(){
		//String errorMessage = "";
		FirstNameField.clear();
		LastNameField.clear();
		CredentialsArea.clear();
		ShortBioArea.clear();
		PhoneNumberField.clear();
		streetField.clear();
		StateField.clear();
		ZipField.clear();
		cityField.clear();
	}
	private boolean isInputValidofAuthor(){
		String errorMessage = "";
		if (FirstNameField.getText() == null || FirstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (LastNameField.getText() == null || LastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
	
		if (CredentialsArea.getText() == null || CredentialsArea.getText().length() <= 5) {
			errorMessage += "No valid Credentials!\n";
		}
		if (ShortBioArea.getText() == null || ShortBioArea.getText().length() <=10) {
			errorMessage += "No valid Bio!\n";
		}
		
		if (PhoneNumberField.getText() == null || PhoneNumberField.getText().length() ==0) {
			errorMessage += "No valid phone number!\n";
		}		
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		
		if (StateField.getText() == null || StateField.getText().length() == 0) {
			errorMessage += "No valid State!\n";
		}
		if (ZipField.getText() == null || ZipField.getText().length() == 0) {
			errorMessage += "No valid Zip code!\n";
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
	private boolean isInputValid() {

		String errorMessage = "";
		if(authorListArea.getText() == null || authorListArea.getText().length()==0){
			errorMessage += "No valid Authors information!\n";
		}
		if (ISBNField.getText() == null || ISBNField.getText().length() == 0) {
			errorMessage += "No valid ISBN!\n";
		}
		if (TitleField.getText() == null || TitleField.getText().length() == 0) {
			errorMessage += "No valid book title!\n";
		}
		if (CopySumField.getText() == null || CopySumField.getText().length() == 0) {
			errorMessage += "No valid book copy sum !\n";
		}
		if (MaxdayBorrow.getText() == null || MaxdayBorrow.getText().length() == 0) {
			errorMessage += "No valid max day of borrow!\n";
		}
		
		if (Publicationdate.getValue()== null) {
			errorMessage += "No valid Publiction date!\n";
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
