package ScanPack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import MusicPack.SongBox;
import guiPack.Showable;
import guiPack.WindowController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ScanWindowController extends WindowController {

	private ScanWindow myWindow;
	
	private ObservableList<String> listOfFiles;
	private ScannigThread scanThr;
	private boolean scaning;
//Контроллы	
	@FXML
	private Button openDirBtn;

	@FXML
	private ListView<String> filesListView;
	
	@FXML
	private ProgressIndicator progressIndicator;
	
//Обработчики событий	
	@FXML
	private void initialize() {
		listOfFiles = FXCollections.observableArrayList();	
		filesListView.setItems(listOfFiles);
		
		progressIndicator.setVisible(false);
		scaning = false;
	}

	@FXML
	private void openDirBtnClick() {
		if (this.scaning == false) {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			Stage directoryChooserStage = new Stage();
			File dir = directoryChooser.showDialog(directoryChooserStage);
			if (dir != null) {	
				
				SongBox box = new SongBox();
				
				this.scanThr = new ScannigThread(dir, box);
				this.scaning = true;
				this.openDirBtn.setText("Стоп");
				this.progressIndicator.setVisible(true);
				this.scanThr.start();				
				while(scanThr.isWorking()) {				
					this.listOfFiles.add(box.get().getName());
				}
				this.progressIndicator.setVisible(false);
				this.scaning = false;
				this.openDirBtn.setText("Открыть");
			}
		}
		else{
			this.scanThr.interrupt();
			this.scaning = false;
			this.openDirBtn.setText("Открыть");
		}		
	}
	
	@Override
	public void setMyWindow(Showable win) {
		myWindow = (ScanWindow) win;		
	}
	
}
