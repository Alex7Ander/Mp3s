package GeneralPack;

import java.io.IOException;

import guiPack.Window;
import guiPack.WindowController;
import javafx.application.Platform;

public class GeneralWindow extends Window{

	private GeneralWindowController myController;
	public GeneralWindow() throws IOException{
		super("Mp3s", "GeneralForm.fxml");
		myController = this.loader.getController();
		myController.setMyWindow(this);
	}

	@Override
	public WindowController getControllerClass() {
		return myController;
	}
	
	@Override
	public void close() {
		Platform.exit();
	}
}
