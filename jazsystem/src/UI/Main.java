package UI;

import java.io.IOException;

import Application.Book;
import Application.Item;
import Application.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class Main extends Application {

	private Stage mainStage;
	private MainWindowController mainWindowController;
	private Stage editMemberDialogStage;
	private EditMemberController editMembercontroller;
	private Stage addBookDialogStage;
	private AddBookController addBookcontroller;
	private Stage addPeriodicalDialogStage;
	private AddPeriodicalController addPeriodicalcontroller;
	private Stage showRecordStage;
	private ShowRecordController showRecordController;
	
	
	@Override
	public void start(Stage loginStage) throws Exception {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent loginPane = loginLoader.load();
		LoginController loginController = loginLoader.getController();
		loginController.setMainApp(this);
		FXMLLoader mainWindowLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		Parent mainPane = mainWindowLoader.load();
		mainWindowController = mainWindowLoader.getController();
		mainWindowController.setMainApp(this);

		loginStage.setTitle("jaz Library System");
		loginStage.setScene(new Scene(loginPane, 500, 350));
		loginStage.setResizable(false);
		mainStage = new Stage();
		mainStage.setTitle("Welcome to jaz Library System");
		mainStage.setScene(new Scene(mainPane, 800, 600));
		mainStage.setResizable(false);
		loginController.setLoginStage(loginStage);
		loginController.setMainStage(mainStage);
		mainWindowController.setLoginStage(loginStage);
		mainWindowController.setMainStage(mainStage);
		mainWindowController.addListenerToIsbnChoicebox();
		mainWindowController.initAuthorListview();

		initEditMemberDialog();
		initAddBookDialog();
		initAddPeriodicalDialog();
		initShowRecordStage();

		loginController.usernameRequestFocus();
		loginStage.show();
	}

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
	
	private void initEditMemberDialog(/*Member member*/) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("EditMember.fxml"));
			
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			editMemberDialogStage = new Stage();
			editMemberDialogStage.setTitle("Member Info");
			editMemberDialogStage.initModality(Modality.WINDOW_MODAL);
			editMemberDialogStage.initOwner(mainStage);
			Scene scene = new Scene(page);
			editMemberDialogStage.setScene(scene);

			// Set the person into the controller.
			editMembercontroller = loader.getController();
			editMembercontroller.setDialogStage(editMemberDialogStage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean showEditMemberDialog(Member member){
		// Show the dialog and wait until the user closes it
		editMembercontroller.setmember(member);
		editMemberDialogStage.showAndWait();
		
		return editMembercontroller.isOkClicked();
	}
	
	private void initAddBookDialog(/*Book book*/) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("AddBook.fxml"));
			
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			addBookDialogStage = new Stage();
			addBookDialogStage.setTitle("Add Book");
			addBookDialogStage.initModality(Modality.WINDOW_MODAL);
			addBookDialogStage.initOwner(mainStage);
			Scene scene = new Scene(page);
			addBookDialogStage.setScene(scene);

			// Set the person into the controller.
			addBookcontroller = loader.getController();
			addBookcontroller.setDialogStage(addBookDialogStage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean showAddBookDialog(){
		// Show the dialog and wait until the user closes it
		addBookcontroller.clearInputField();
		addBookDialogStage.showAndWait();
		return addBookcontroller.isOkClicked();
	}
	
	private void initAddPeriodicalDialog(/*Book book*/) {
//		System.out.println("showAddPeriodicalDialog");
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("AddPeriodical.fxml"));
			
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			addPeriodicalDialogStage = new Stage();
			addPeriodicalDialogStage.setTitle("Add Periodical");
			addPeriodicalDialogStage.initModality(Modality.WINDOW_MODAL);
			addPeriodicalDialogStage.initOwner(mainStage);
			Scene scene = new Scene(page);
			addPeriodicalDialogStage.setScene(scene);

			// Set the person into the controller.
			addPeriodicalcontroller = loader.getController();
			addPeriodicalcontroller.setDialogStage(addPeriodicalDialogStage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showAddPeriodicalDialog(){
		// Show the dialog and wait until the user closes it
		
		addPeriodicalDialogStage.showAndWait();
		return addPeriodicalcontroller.isOkClicked();
	}

	private void initShowRecordStage() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("ShowRecord.fxml"));
			
			BorderPane page = (BorderPane) loader.load();

			// Create the dialog Stage.
			showRecordStage = new Stage();
			showRecordStage.setTitle("Member Checkout");
			showRecordStage.initModality(Modality.WINDOW_MODAL);
			showRecordStage.initOwner(mainStage);
			Scene scene = new Scene(page, 800, 600);
			showRecordStage.setScene(scene);
			showRecordStage.setResizable(false);

			// Set the person into the controller.
			showRecordController = loader.getController();
			showRecordController.setShowRecordStage(showRecordStage);
			showRecordController.initEntryTableView();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showShowRecordStage(Member member, Item item){		
		showRecordController.setMemberItem(member, item);
		showRecordStage.showAndWait();
	}
	
	
	public MainWindowController getMainWindowController() {
		return mainWindowController;
	}
	
}
