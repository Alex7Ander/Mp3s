package ScanPack;

import java.io.File;
import java.util.HashMap;

import guiPack.Showable;
import guiPack.WindowController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ScanWindowController extends WindowController {

	private ScanWindow myWindow;
	
	private String scanPath;
	private ObservableList<String> listOfFiles;

//Контроллы	
	@FXML
	private Button openDirBtn;

	@FXML
	private ListView<String> filesListView;
	
//Обработчики событий	
	@FXML
	private void initialize() {
		listOfFiles = FXCollections.observableArrayList();	
		filesListView.setItems(listOfFiles);
	}

	@FXML
	private void openDirBtnClick() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage directoryChooserStage = new Stage();
		File dir = directoryChooser.showDialog(directoryChooserStage);
		HashMap<String, String> filesResult = FilesScaner.scan(dir.getAbsolutePath());
		
		listOfFiles.clear();
		for(String fileName : filesResult.keySet()) {
			listOfFiles.add(fileName);
		}
		filesListView.setItems(listOfFiles);
	}
	
	@Override
	public void setMyWindow(Showable win) {
		myWindow = (ScanWindow) win;		
	}
	
}
