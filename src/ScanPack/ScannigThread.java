package ScanPack;

import java.io.File;
import java.util.ArrayList;

import MusicPack.SongBox;

public class ScannigThread implements Runnable{

	private Thread myThr;
	private ArrayList<File> resultOfScaning;
	private File initialDir;
	private boolean working;
	private SongBox box;
	
	public ScannigThread(File InitialDir, SongBox Box){
		myThr = new Thread(this, "ScanningThread");
		initialDir = InitialDir;
		resultOfScaning = new ArrayList<File>();
		working = false;
		box = Box;
	}
	
	@Override
	public void run() {
		this.resultOfScaning = FilesScaner.scan(initialDir.getAbsolutePath(), box);	
		working = false;
	}
	
	public void start() {
		myThr.start();
		working = true;
	}
	
	public void join() throws InterruptedException {
		myThr.join();
	}
	
	public void interrupt() {
		myThr.interrupt();
	}
	
	public boolean isWorking() {
		return working;
	}
	
	public ArrayList<File> returnResOfScaning() {
		return this.resultOfScaning;
	}
	
}