package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class PlayerOneField extends PlayerField {

	// ------------------------------ CONSTRUCTOR ------------------------------ //
	
	public PlayerOneField(int width , int height) {
		super(width , height);
		X = width /20;
		for (int i = 0 ; i <5 ; i++) {
			SimulationManager.getY().add((i+1)*(this.height/15) + i*(this.height/8) );
		}
		
		SimulationManager.setXP1(X);
	}

	// ------------------------------ METHOD ------------------------------ //
	
	public int getZ() {
		return -5000;
	}
	
	public void draw(GraphicsContext gc) {
		
		double w = gc.getCanvas().getWidth();
		double h = gc.getCanvas().getHeight();
		
		if(SimulationManager.getWonLane1()=="1") {
			gc.drawImage(RenderableHolder.getDoorOpen(),w/20 , (0+1)*(h/15)-20 + 0*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(),w/20+w/11.5 , (0+1)*(h/15)+7.5 + 0*(h/8) , w/25 , h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(),w/20 , (0+1)*(h/15)-20 + 0*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(),w/20+w/11.5 , (0+1)*(h/15)+7.5 + 0*(h/8) , w/25 , h/8);
		}
		if(SimulationManager.getWonLane2()=="1") {
			gc.drawImage(RenderableHolder.getDoorOpen(),w/20 , (1+1)*(h/15)-20 + 1*(h/8) , w/12 , h/6);
			gc.drawImage(RenderableHolder.getSwitchOn(),w/20+w/11.5 , (1+1)*(h/15)+7.5 + 1*(h/8) , w/25 , h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(),w/20 , (1+1)*(h/15)-20 + 1*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(),w/20+w/11.5 , (1+1)*(h/15)+7.5 + 1*(h/8) , w/25 , h/8);
		}
		if(SimulationManager.getWonLane3()=="1") {
			gc.drawImage(RenderableHolder.getDoorOpen(),w/20 , (2+1)*(h/15)-20 + 2*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(),w/20+w/11.5 , (2+1)*(h/15)+7.5 + 2*(h/8) , w/25 , h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(),w/20 , (2+1)*(h/15)-20 + 2*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(),w/20+w/11.5 , (2+1)*(h/15)+7.5 + 2*(h/8) , w/25 , h/8);
		}
		if(SimulationManager.getWonLane4()=="1") {
			gc.drawImage(RenderableHolder.getDoorOpen(),w/20 , (3+1)*(h/15)-20 + 3*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(),w/20+w/11.5 , (3+1)*(h/15)+7.5 + 3*(h/8) , w/25 , h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(),w/20 , (3+1)*(h/15)-20 + 3*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(),w/20+w/11.5 , (3+1)*(h/15)+7.5 + 3*(h/8) , w/25 , h/8);
		}
		if(SimulationManager.getWonLane5()=="1") {
			gc.drawImage(RenderableHolder.getDoorOpen(),w/20 , (4+1)*(h/15)-20 + 4*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(),w/20+w/11.5 , (4+1)*(h/15)+7.5 + 4*(h/8) , w/25 , h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(),w/20 , (4+1)*(h/15)-20 + 4*(h/8) , w/12 , h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(),w/20+w/11.5 , (4+1)*(h/15)+7.5 + 4*(h/8) , w/25 , h/8);
		}
		

	}

}
