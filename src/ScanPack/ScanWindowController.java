package ScanPack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import guiPack.Showable;
import guiPack.WindowController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ScanWindowController extends WindowController {

	private ScanWindow myWindow;
	
	private String scanPath;
	private ObservableList<String> listOfFiles;
	private ArrayList<File> mp3Files;
	
	@FXML
	private Button openDirBtn;
	@FXML
	private ProgressIndicator progress;
	@FXML
	private ListView<String> filesListView;
	
//
	@FXML
	private void initialize() {
		progress.setVisible(false);
		listOfFiles = FXCollections.observableArrayList();	
		mp3Files = new ArrayList<File>();
		filesListView.setItems(listOfFiles);
	}

	@FXML
	private void openDirBtnClick() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage directoryChooserStage = new Stage();
		File dir = directoryChooser.showDialog(directoryChooserStage);
		if (dir == null) {
			return;
		}		
		if(!dir.isDirectory()) {
			//Сообщение об ошибке!!! Вы выбрали не дирректорию
		}
		
		listOfFiles.clear();
		mp3Files.clear();
		ScanerService scanService = new ScanerService(dir.getAbsolutePath(), listOfFiles, mp3Files);
		scanService.setOnScheduled(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent arg0) {
				progress.setVisible(true);
			}			
		});
		scanService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent arg0) {
				progress.setVisible(false);
			}			
		});
		scanService.start();
	}
	
	@Override
	public void setMyWindow(Showable win) {
		myWindow = (ScanWindow) win;		
	}
	
}

