package MusicPack;

import java.io.File;
import java.util.ArrayList;

public class SongBox {
	private ArrayList<File> songs;
	private int currentSize;
	public SongBox() {		
		songs = new ArrayList<File>();
		currentSize = songs.size();
	}
	
	public synchronized void add(File songFile) {
		songs.add(songFile);
		this.currentSize = songs.size();
		notify();
	}
	
	public synchronized File get() {
		while(songs.size() < 1) {
			try {
				wait();
			}
			catch(InterruptedException iExp){
				iExp.getStackTrace();
			}
		}
		File resFile = this.songs.get(songs.size() - 1);
		notify();
		return resFile;
	}
	
	public synchronized int size() {
		return this.songs.size();
	}
}

/*
 		while(this.currentSize == songs.size()) {
			try {
				wait();
			}
			catch(InterruptedException iExp){
				iExp.getStackTrace();
			}
		}
*/
