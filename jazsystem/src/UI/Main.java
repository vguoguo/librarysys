package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {

	@Override
	public void start(Stage loginStage) throws Exception {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent loginPane = loginLoader.load();
		LoginController loginController = loginLoader.getController();
		FXMLLoader mainWindowLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		Parent mainPane = mainWindowLoader.load();

		loginStage.setTitle("jaz Library System");
		loginStage.setScene(new Scene(loginPane, 500, 350));
		loginStage.setResizable(false);
		Stage mainStage = new Stage();
		mainStage.setTitle("Welcome to jaz Library System");
		mainStage.setScene(new Scene(mainPane, 800, 600));
		mainStage.setResizable(false);
		loginController.setLoginStage(loginStage);
		loginController.setMainStage(mainStage);
		loginStage.show();
	}

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
}
