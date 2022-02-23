package entity;

import java.util.ArrayList;

import entity.base.Adventurer;
import entity.base.Knight;
import entity.base.Monster;
import entity.base.Ninja;
import entity.base.Robot;
import entity.base.Santa;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class PlayerOne extends Player {

	// ------------------------------ FIELD ------------------------------ //

	public static int currentPos1 = 2;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize new deck from the inputed array.
	public PlayerOne(Monster... monsters) {

		super(monsters);
		setCoordinateX(SimulationManager.getXP1());
		setCoordinateY(SimulationManager.getY().get(currentPos));
		currentSprite = RenderableHolder.getPlayerOneSprite();
		up = KeyCode.W;
		down = KeyCode.S;
		choose0 = KeyCode.DIGIT1;
		choose1 = KeyCode.DIGIT2;
		choose2 = KeyCode.DIGIT3;
		releaseMonster = KeyCode.SPACE;
		this.coins = SimulationManager.getCoins1();
		usedMonsterList = new ArrayList<Monster>();
	}

	// ------------------------------ METHOD ------------------------------ //

	// draw the PlayerOne sprite in the right position.
	@Override
	public void draw(GraphicsContext gc) {

		for (int i = 0; i < pos.length; i++) {
			if (pos[i]) {
				setCoordinateY(SimulationManager.getY().get(i));
				break;
			}
		}
		gc.drawImage(currentSprite, coordinateX - 5, coordinateY - 10, 85, 85);
	}

	// check if the player’s coins are enough for the selected monster.
	public boolean isMonsterReady() {
		if (coins >= deck.getDeckList().get(SimulationManager.getIsSelected1()).getCost()) {

			return true;
		}
		return false;
	}

	// Remove monster that is released from deck, add a random monster, then add the
	// monster that was released to the monsterList.
	@Override
	public void releaseMonster() {

		if (isMonsterReady()) {

			release = deck.removeMonster(SimulationManager.getIsSelected1());
			SimulationManager.setCoins1Decrease(release.getCost());
			deck.addRandomMonster();
			deck.getMonsterList().add(release);
			checkDeck();
			releaseMons = true;
		}
	}

	// Set the current image of monster channel.
	public void checkDeck() {

		RenderableHolder.setCurrentImage10(RenderableHolder.getMonsterImage1(deck.getDeckList().get(0).getName()));
		RenderableHolder.setCurrentImage11(RenderableHolder.getMonsterImage1(deck.getDeckList().get(1).getName()));
		RenderableHolder.setCurrentImage12(RenderableHolder.getMonsterImage1(deck.getDeckList().get(2).getName()));
	}

	// Update the position of the player, chosen monster, coins and current position
	// of PlayerOne.
	@Override
	public void update() {

		super.update();
		if (InputUtility.getKeyPressed(choose0)) {
			SimulationManager.setIsSelected1(0);
		} else if (InputUtility.getKeyPressed(choose1)) {
			SimulationManager.setIsSelected1(1);
		} else if (InputUtility.getKeyPressed(choose2)) {
			SimulationManager.setIsSelected1(2);
		}
		currentPos1 = currentPos;
		this.coins = SimulationManager.getCoins1();

		// If releaseMons is true then releases the monster that PlayerOne chooses.
		if (releaseMons) {
			if (release instanceof Adventurer) {
				adventurer = new Adventurer("1");
				RenderableHolder.getInstance().add(adventurer);
				usedMonsterList.add(adventurer);
				releaseMons = false;
			}
			if (release instanceof Knight) {
				knight = new Knight("1");
				RenderableHolder.getInstance().add(knight);
				usedMonsterList.add(knight);
				releaseMons = false;
			}
			if (release instanceof Ninja) {
				ninja = new Ninja("1");
				RenderableHolder.getInstance().add(ninja);
				usedMonsterList.add(ninja);
				releaseMons = false;
			}
			if (release instanceof Robot) {
				robot = new Robot("1");
				RenderableHolder.getInstance().add(robot);
				usedMonsterList.add(robot);
				releaseMons = false;
			}
			if (release instanceof Santa) {
				santa = new Santa("1");
				RenderableHolder.getInstance().add(santa);
				usedMonsterList.add(santa);
				releaseMons = false;
			}
		}

		// Update all monsters that PlayerOne releases.
		if (!usedMonsterList.isEmpty()) {
			for (Monster i : usedMonsterList) {
				i.update();
			}
		}
	}

}
