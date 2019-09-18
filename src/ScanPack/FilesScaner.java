package ScanPack;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class FilesScaner {
	
	public static void scan(String path, ObservableList<String> listOfFiles, ArrayList<File> result) {
		File dir = new File(path);
		if (dir.isDirectory()) {
			for (File includedFile : dir.listFiles()) {
				if (includedFile.isDirectory() && !includedFile.isHidden()) {
					FilesScaner.scan(includedFile.getAbsolutePath(), listOfFiles, result);
					System.out.println(includedFile.getAbsolutePath());
				}
				else {
					String name = includedFile.getName();
					if (name.contains(".mp3")) {
						result.add(includedFile);
						listOfFiles.add(includedFile.getName());
					}
				}
			}			
		}
	}
	
	static class ExtentionFilter implements FileFilter{
		private String extention;
		
		ExtentionFilter(String anyExtention){
			extention  = anyExtention;
		}
		
		@Override
		public boolean accept(File filePath) {
			String currentExtention = getExtention(filePath);
			return currentExtention.equals(extention);
		}		
		
		private String getExtention(File pathName) {
			String fileName = pathName.getName();
			int index = fileName.lastIndexOf('.');
			if (index > 0 && index < fileName.length()-1) {
				return fileName.substring(index+1).toLowerCase();
			}
			else {
				return "";
			}
		}
	}

}
