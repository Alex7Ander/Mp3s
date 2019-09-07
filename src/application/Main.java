package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mp3s");
			primaryStage.setResizable(false);
			primaryStage.show();
		}
		catch(IOException ioExp) {
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
