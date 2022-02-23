package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class PlayerTwoField extends PlayerField{

	// ------------------------------ CONSTRUCTOR ------------------------------ //
	
	public PlayerTwoField(int width , int height) {
		super(width , height);
		X = width - (width/20+ width/10);
		
		for (int i = 0 ; i <5 ; i++) {
			SimulationManager.getY().add((i+1)*(this.height/15) + i*(this.height/8) );
		}
		
		SimulationManager.setXP2(X);
	}

	// ------------------------------ METHOD ------------------------------ //
	
	public int getZ() {
		return Z;
	}
	
	public void draw(GraphicsContext gc) {
		
		double w = gc.getCanvas().getWidth();
		double h = gc.getCanvas().getHeight();
		
		if(SimulationManager.getWonLane1()=="2") {
			gc.drawImage(RenderableHolder.getDoorOpen(), w - (w/20+ w/10), (0+1)*(h/15)-20 + 0*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(), w - (w/20+ w/10)-w/23, (0+1)*(h/15)+7.5 + 0*(h/8) ,  w/25, h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(), w - (w/20+ w/10), (0+1)*(h/15)-20 + 0*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(), w - (w/20+ w/10)-w/23, (0+1)*(h/15)+7.5 + 0*(h/8) ,  w/25, h/8);
		}
		if(SimulationManager.getWonLane2()=="2") {
			gc.drawImage(RenderableHolder.getDoorOpen(), w - (w/20+ w/10), (1+1)*(h/15)-20 + 1*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(), w - (w/20+ w/10)-w/23, (1+1)*(h/15)+7.5 + 1*(h/8) ,  w/25, h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(), w - (w/20+ w/10), (1+1)*(h/15)-20 + 1*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(), w - (w/20+ w/10)-w/23, (1+1)*(h/15)+7.5 + 1*(h/8) ,  w/25, h/8);
		}
		if(SimulationManager.getWonLane3()=="2") {
			gc.drawImage(RenderableHolder.getDoorOpen(), w - (w/20+ w/10), (2+1)*(h/15)-20 + 2*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(), w - (w/20+ w/10)-w/23, (2+1)*(h/15)+7.5 + 2*(h/8) ,  w/25, h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(), w - (w/20+ w/10), (2+1)*(h/15)-20 + 2*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(), w - (w/20+ w/10)-w/23, (2+1)*(h/15)+7.5 + 2*(h/8) ,  w/25, h/8);
		}
		if(SimulationManager.getWonLane4()=="2") {
			gc.drawImage(RenderableHolder.getDoorOpen(), w - (w/20+ w/10), (3+1)*(h/15)-20 + 3*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(), w - (w/20+ w/10)-w/23, (3+1)*(h/15)+7.5 + 3*(h/8) ,  w/25, h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(), w - (w/20+ w/10), (3+1)*(h/15)-20 + 3*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(), w - (w/20+ w/10)-w/23, (3+1)*(h/15)+7.5 + 3*(h/8) ,  w/25, h/8);
		}
		if(SimulationManager.getWonLane5()=="2") {
			gc.drawImage(RenderableHolder.getDoorOpen(), w - (w/20+ w/10), (4+1)*(h/15)-20 + 4*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOn(), w - (w/20+ w/10)-w/23, (4+1)*(h/15)+7.5 + 4*(h/8) ,  w/25, h/8);
		}else {
			gc.drawImage(RenderableHolder.getDoorClose(), w - (w/20+ w/10), (4+1)*(h/15)-20 + 4*(h/8) ,  w/12, h/5.5);
			gc.drawImage(RenderableHolder.getSwitchOff(), w - (w/20+ w/10)-w/23, (4+1)*(h/15)+7.5 + 4*(h/8) ,  w/25, h/8);
		}

	}

}
