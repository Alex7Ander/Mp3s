package GeneralPack;

import guiPack.Showable;
import guiPack.WindowController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GeneralWindowController extends WindowController{

	private GeneralWindow myWindow;
	
	@FXML
	private AnchorPane mainAnchorPane;
	
	@Override
	public void setMyWindow(Showable win) {
		this.myWindow = (GeneralWindow) win;		
	}

}
