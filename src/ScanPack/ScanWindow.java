package ScanPack;

import java.io.IOException;

import guiPack.Window;
import guiPack.WindowController;
import javafx.stage.Stage;

public class ScanWindow extends Window {

	private static ScanWindow instanceScanWindow;
	
	private ScanWindow() {
		super("Сканирование", "ScanForm.fxml");
	}
	
	public static ScanWindow getScanWindow() {
		if (instanceScanWindow == null) {
			instanceScanWindow = new ScanWindow();
		}
		return instanceScanWindow;
	}

	@Override
	public WindowController getControllerClass() {
		return this.loader.getController();
	}
	
	public Stage getStage() {
		return this.stage;
	}

}
