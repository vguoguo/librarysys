package UI;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	private Logger logger = Logger.getLogger(Main.class.getName());

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		primaryStage.setTitle("jaz Library System");
		primaryStage.setScene(new Scene(root, 500, 350));
		primaryStage.setResizable(false);
		primaryStage.show();
//		logger.log(Level.INFO, "test logging...");
	}

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
}
