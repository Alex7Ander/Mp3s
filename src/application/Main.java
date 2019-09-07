package application;
	
import java.io.IOException;

import guiPack.Showable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application implements Showable {
	private Stage stage;
	@Override
	public void start(Stage primaryStage) { 
		stage = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setTitle("Mp3s");
			stage.setResizable(false);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			MainController ctrl = (MainController) loader.getController();
			ctrl.setMyWindow(this);
		}
		catch(IOException ioExp) {
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void show() {
		stage.show();
		
	}

	@Override
	public void close() {
		Platform.exit();	
	}
}
