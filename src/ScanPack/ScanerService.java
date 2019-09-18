package ScanPack;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ScanerService extends Service<Integer> {
	
	private ArrayList<File> result;
	private String initialPath;
	private ObservableList<String> listOfFiles;
	
	ScanerService(String InitalPath, ObservableList<String> ListOfFiles, ArrayList<File> Result){
		this.result = Result;
		this.initialPath = InitalPath;
		this.listOfFiles = ListOfFiles;
	}
	
	@Override
	protected Task<Integer> createTask() {
		return new Task<Integer>() {

			@Override
			protected Integer call() throws Exception {
				FilesScaner.scan(initialPath, listOfFiles, result);
				return 0;
			}			
		};
	}

}
