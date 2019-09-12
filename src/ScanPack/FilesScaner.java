package ScanPack;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;

public class FilesScaner {
	
	public static HashMap<String, String> scan(String path) {
		HashMap<String, String> result = new HashMap<String, String>();
		File dir = new File(path);
		if (dir.isDirectory()) {
			for (File includedFile : dir.listFiles()) {
				if (includedFile.isDirectory()) {
					HashMap<String, String> tempresult = FilesScaner.scan(includedFile.getAbsolutePath());
					result.putAll(tempresult);
				}
				else {
					String name = includedFile.getName();
					if (name.contains(".mp3")) {
						result.put(name, includedFile.getAbsolutePath());
					}
				}
			}			
		}
		return result;
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
