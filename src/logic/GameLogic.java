package logic;

import java.util.ArrayList;
import entity.Entity;
import entity.PlayerOne;
import entity.PlayerTwo;
import entity.base.Monster;
import entity.base.Ninja;
import entity.base.Robot;
import entity.base.Santa;
import entity.Barrel;
import entity.base.Adventurer;
import entity.base.Knight;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class GameLogic {

	// ------------------------------ FIELD ------------------------------ //

	private Field field;
	private PlayerOne playerOne;
	private PlayerField playerField1;
	private PlayerTwo playerTwo;
	private PlayerField playerField2;
	private Monster adventurer, knight, ninja, santa, robot;
	private Barrel barrel1, barrel2, barrel3, barrel4, barrel5;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public GameLogic() {

		SimulationManager.setUpSimulationManager();

		RenderableHolder.loadMap();

		adventurer = new Adventurer("0");
		knight = new Knight("0");
		ninja = new Ninja("0");
		santa = new Santa("0");
		robot = new Robot("0");

		barrel1 = new Barrel(375, 45.0, 0);
		barrel2 = new Barrel(375, 140.0, 1);
		barrel3 = new Barrel(375, 235.0, 2);
		barrel4 = new Barrel(375, 330.0, 3);
		barrel5 = new Barrel(375, 425.0, 4);
		SimulationManager.getBarrelList().add(barrel1);
		SimulationManager.getBarrelList().add(barrel2);
		SimulationManager.getBarrelList().add(barrel3);
		SimulationManager.getBarrelList().add(barrel4);
		SimulationManager.getBarrelList().add(barrel5);

		RenderableHolder.getInstance().add(barrel1);
		RenderableHolder.getInstance().add(barrel2);
		RenderableHolder.getInstance().add(barrel3);
		RenderableHolder.getInstance().add(barrel4);
		RenderableHolder.getInstance().add(barrel5);

		playerField1 = new PlayerOneField(800, 500);
		playerField2 = new PlayerTwoField(800, 500);
		playerOne = new PlayerOne(knight, adventurer, ninja, santa, robot);
		playerTwo = new PlayerTwo(knight, adventurer, ninja, santa, robot);

		RenderableHolder.setCurrentImage10(RenderableHolder.getMonsterImage1(knight.getName()));
		RenderableHolder.setCurrentImage11(RenderableHolder.getMonsterImage1(adventurer.getName()));
		RenderableHolder.setCurrentImage12(RenderableHolder.getMonsterImage1(ninja.getName()));
		RenderableHolder.setCurrentImage20(RenderableHolder.getMonsterImage2(knight.getName()));
		RenderableHolder.setCurrentImage21(RenderableHolder.getMonsterImage2(adventurer.getName()));
		RenderableHolder.setCurrentImage22(RenderableHolder.getMonsterImage2(ninja.getName()));

		field = new Field();
		RenderableHolder.getInstance().add(field);

		RenderableHolder.getInstance().add(playerField1);
		addNewObject(playerOne);
		RenderableHolder.getInstance().add(playerField2);
		addNewObject(playerTwo);

	}

	// ------------------------------ METHOD ------------------------------ //

	// Add entity to RenderableHolder.
	protected void addNewObject(Entity entity) {
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate() {
		playerOne.update();
		playerTwo.update();
		checkGameEnd();
		// update all barrels
		for (Barrel i : SimulationManager.getBarrelList()) {
			i.update();
		}
		// if game end all monsters die.
		if (SimulationManager.isGameEnd()) {
			for (ArrayList<Monster> i : SimulationManager.getP1AllMonster()) {
				for (Monster j : i) {
					j.setDeath(true);
				}
			}
			for (ArrayList<Monster> i : SimulationManager.getP2AllMonster()) {
				for (Monster j : i) {
					j.setDeath(true);
				}
			}
		}
	}

	// check if the game is end.
	public void checkGameEnd() {
		// time out
		if (SimulationManager.getIngametime() == 0) {
			if (SimulationManager.getPoints1() == SimulationManager.getPoints2()) {
				if (SimulationManager.getTotalDamage1() == SimulationManager.getTotalDamage2()) {
					SimulationManager.setGameresult("DRAW!!");
				} else if (SimulationManager.getTotalDamage1() > SimulationManager.getTotalDamage2()) {
					SimulationManager.setGameresult("PLAYER 1 WIN!!");
				} else if (SimulationManager.getTotalDamage1() < SimulationManager.getTotalDamage2()) {
					SimulationManager.setGameresult("PLAYER 2 WIN!!");
				}
			} else if (SimulationManager.getPoints1() > SimulationManager.getPoints2()) {
				SimulationManager.setGameresult("PLAYER 1 WIN!!");
			} else if (SimulationManager.getPoints1() < SimulationManager.getPoints2()) {
				SimulationManager.setGameresult("PLAYER 2 WIN!!");
			}
			SimulationManager.setGameEnd(true);
			// player 1 win
		} else if (SimulationManager.getPoints1() == 3) {
			SimulationManager.setGameresult("PLAYER 1 WIN!!");
			SimulationManager.setGameEnd(true);
			// player 2 win
		} else if (SimulationManager.getPoints2() == 3) {
			SimulationManager.setGameresult("PLAYER 2 WIN!!");
			SimulationManager.setGameEnd(true);
		}

	}

}