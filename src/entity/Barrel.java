package entity;

import entity.base.Monster;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class Barrel extends Entity {
	
	// ------------------------------ FIELD ------------------------------ //
	
	private int damageFrom1;
	private int damageFrom2;
	private int greenWidth;
	private int breakValue;
	private boolean isLaneEnd;
	protected double posX;
	protected double posY;
	protected int Lane;

	// ------------------------------ CONSTRUCTOR ------------------------------ //
	
	public Barrel(double posX, double posY, int lane) {
		setPosX(posX);
		setPosY(posY);
		setLaneEnd(false);
		Lane = lane;
		z = 50;
		breakValue = 100;
		damageFrom1 = 0;
		damageFrom2 = 0;
		greenWidth = 100;
	}
	
	// ------------------------------ METHOD ------------------------------ //
	
	// add the damage receiving from PlayerOne.
	public void damageTakenFrom1(int damage) {
		setDamageFrom1(getDamageFrom1() + damage);
	}
	// add the damage receiving from PlayerTwo.
	public void damageTakenFrom2(int damage) {
		setDamageFrom2(getDamageFrom2() + damage);
	}

	// draw the barrel if this lane is not end.
	public void draw(GraphicsContext gc) {
		if (!isLaneEnd) {
			gc.drawImage(RenderableHolder.getBarrel(), posX, posY);
			gc.setFill(Color.GREEN);
			gc.fillRect(300, posY - 20, greenWidth, 5);
			gc.setFill(Color.RED);
			gc.fillRect(300 + greenWidth, posY - 20, 200 - greenWidth, 5);
		}
	}


	public void update() {
		
		int dif = damageFrom1 - damageFrom2;
		greenWidth = 100 + ((dif * 100) / breakValue);
		
		// if the difference of damage is more than 100 the lane is end and all monsters will die.
		if ((dif >= 100) || (dif <= -100)) {
			for (Monster i : SimulationManager.getP1AllMonster().get(this.Lane)) {
				i.setDeath(true);
			}
			for (Monster i : SimulationManager.getP2AllMonster().get(this.Lane)) {
				i.setDeath(true);
			}
			if (dif >= 100) {
				// set the winner of the lane and add point.
				if ((Lane == 0)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane1("1");
					SimulationManager.setPoints1(SimulationManager.getPoints1()+1);	
				}
				if ((Lane == 1)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane2("1");
					SimulationManager.setPoints1(SimulationManager.getPoints1()+1);
				}
				if ((Lane == 2)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane3("1");
					SimulationManager.setPoints1(SimulationManager.getPoints1()+1);
				}
				if ((Lane == 3)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane4("1");
					SimulationManager.setPoints1(SimulationManager.getPoints1()+1);
				}
				if ((Lane == 4)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane5("1");
					SimulationManager.setPoints1(SimulationManager.getPoints1()+1);
				}
			}
			if (dif <= -100) {
				// set the winner of the lane and add point.
				if ((Lane == 0)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane1("2");
					SimulationManager.setPoints2(SimulationManager.getPoints2()+1);
				}
				if ((Lane == 1)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane2("2");
					SimulationManager.setPoints2(SimulationManager.getPoints2()+1);
				}
				if ((Lane == 2)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane3("2");
					SimulationManager.setPoints2(SimulationManager.getPoints2()+1);
				}
				if ((Lane == 3)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane4("2");
					SimulationManager.setPoints2(SimulationManager.getPoints2()+1);
				}
				if ((Lane == 4)&&(!isLaneEnd)) {
					setLaneEnd(true);
					SimulationManager.setWonLane5("2");
					SimulationManager.setPoints2(SimulationManager.getPoints2()+1);
				}
			}
		}
	}

	// ------------------------------ SETTER,GETTER ------------------------------ //
	public int getDamageFrom1() {
		return damageFrom1;
	}

	public void setDamageFrom1(int damageFrom1) {
		this.damageFrom1 = damageFrom1;
	}

	public int getDamageFrom2() {
		return damageFrom2;
	}

	public void setDamageFrom2(int damageFrom2) {
		this.damageFrom2 = damageFrom2;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public boolean isLaneEnd() {
		return isLaneEnd;
	}

	public void setLaneEnd(boolean isLaneEnd) {
		this.isLaneEnd = isLaneEnd;
	}

}
