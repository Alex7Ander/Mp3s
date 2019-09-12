package GeneralPack;

import ScanPack.ScanWindow;
import guiPack.Showable;
import guiPack.WindowController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class GeneralWindowController extends WindowController{

	private GeneralWindow myWindow;

//контроллы
	@FXML
	private AnchorPane mainAnchorPane;
	
	@FXML
	private MenuItem openPlayListMenuItem;
	@FXML
	private MenuItem addPlayListMenuItem;
	@FXML
	private MenuItem editPlayListMenuItem;
	
	@FXML
	private MenuItem genresMenuItem;
	@FXML
	private MenuItem musiciansMenuItem;
	
	@FXML
	private MenuItem scanMenuItem;

//Обработчики событий
	@FXML
	private void initialize() {
		//
	}
	
	@FXML
	private void openPlayListMenuItemClick() {
		//
	}
	@FXML
	private void addPlayListMenuItemClick() {
		//
	}
	@FXML
	private void editPlayListMenuItemClick() {
		//
	}
	
	@FXML
	private void genresMenuItemClick() {
		//
	}
	@FXML
	private void musiciansMenuItemClick() {
		//
	}
	
	@FXML
	private void scanMenuItemClick() {
		ScanWindow.getScanWindow().show();
	}
//Методы, унаследованные от WindowController	
	@Override
	public void setMyWindow(Showable win) {
		this.myWindow = (GeneralWindow) win;		
	}

//Прочие методы
}
