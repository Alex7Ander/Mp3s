package guiPack;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Window implements Showable{

	protected Parent root;
	protected Stage stage;
	protected Scene scene;
	protected String title;
	protected String fxmlFile;
	protected FXMLLoader loader;
	protected WindowController controller;
	
	public Window(String Title, String FXMLFile) {
		this.title = Title;
		this.fxmlFile = FXMLFile;
		try {
			this.loader = new FXMLLoader(getClass().getResource(fxmlFile));
			this.root = loader.load();
			this.scene = new Scene(root);
			this.stage = new Stage();
			stage.setScene(scene);
			stage.setTitle(title);
		}
		catch(IOException ioExp) {
			
		}
		
	}
	
	public void show() {
		stage.show();
	}
	
	public void close() {
		stage.close();
	}
	
	public abstract WindowController getControllerClass();
}
