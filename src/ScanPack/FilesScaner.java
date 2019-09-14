package ScanPack;

import java.io.File;
import java.util.ArrayList;

import MusicPack.SongBox;

public class FilesScaner {
	
	public static ArrayList<File> scan(String path, SongBox box) {
		ArrayList<File> result = new ArrayList<File>();
		File dir = new File(path);
		if (dir.isDirectory()) {
			for (File includedFile : dir.listFiles()) {
				if (includedFile.isDirectory() && !includedFile.isHidden() ) {
					System.out.println(includedFile.getAbsolutePath());
					ArrayList<File> tempresult = FilesScaner.scan(includedFile.getAbsolutePath(), box);
					result.addAll(tempresult);
				}
				else {
					String name = includedFile.getName();
					if (name.contains(".mp3")) {
						result.add(includedFile);
						box.add(includedFile);
					}
				}
			}
		}
		return result;
	}

}  