package application;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import GeneralPack.GeneralWindow;
import guiPack.Showable;
import guiPack.WindowController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainController extends WindowController{
	//
	@FXML
	private AnchorPane pane;
	
	private Main myWindow;
	double opacityValue = 0.1;
	@FXML
	private void initialize() {
		this.pane.setOpacity(this.opacityValue);
		Timer timer = new Timer();
		ShowTimerTask showTask = new ShowTimerTask();
		timer.schedule(showTask, 100);
		try {
			GeneralWindow genWin = new GeneralWindow();
			genWin.show();
		}
		catch(IOException ioExp) {
			System.out.println(ioExp.getStackTrace());
		}
		myWindow.close();
	}
	
	class ShowTimerTask extends TimerTask{
		
		double opacityValue = 0.1;
		@Override
		public void run() {
			initProgram();
		}
		
		private synchronized void initProgram() {
			while(this.opacityValue < 1.0){
				pane.setOpacity(this.opacityValue);
				this.opacityValue += 0.1; 
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
		
	}

	@Override
	public void setMyWindow(Showable win) {
		myWindow = (Main)win;		
	}

}
