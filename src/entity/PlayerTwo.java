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

public class PlayerTwo extends Player {

	// ------------------------------ FIELD ------------------------------ //

	public static int currentPos2 = 2;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize new deck from the inputed array.
	public PlayerTwo(Monster... monsters) {

		super(monsters);
		up = KeyCode.UP;
		down = KeyCode.DOWN;
		choose0 = KeyCode.EQUALS;
		choose1 = KeyCode.MINUS;
		choose2 = KeyCode.DIGIT0;
		releaseMonster = KeyCode.LEFT;
		currentSprite = RenderableHolder.getPlayerTwoSprite();
		setCoordinateX(SimulationManager.getXP2());
		setCoordinateY(SimulationManager.getY().get(currentPos));
		this.coins = SimulationManager.getCoins2();
		usedMonsterList = new ArrayList<Monster>();
	}

	// ------------------------------ METHOD ------------------------------ //

	// draw the PlayerOne sprite in the right position.
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pos.length; i++) {
			if (pos[i]) {
				setCoordinateY(SimulationManager.getY().get(i));
				break;
			}
		}
		gc.drawImage(currentSprite, coordinateX + 70, coordinateY - 10, -85, 85);
	}

	// check if the player’s coins are enough for the selected monster.
	public boolean isMonsterReady() {
		if (coins >= deck.getDeckList().get(SimulationManager.getIsSelected2()).getCost()) {

			return true;
		}
		return false;
	}

	// Remove monster that is released from deck, add a random monster, then add the
	// monster that was released to the monsterList.
	@Override
	public void releaseMonster() {
		// TODO Auto-generated method stub
		if (isMonsterReady()) {

			release = deck.removeMonster(SimulationManager.getIsSelected2());
			SimulationManager.setCoins2Decrease(release.getCost());
			deck.addRandomMonster();
			deck.getMonsterList().add(release);
			checkDeck();
			releaseMons = true;
		}
	}

	// Set the current image of monster channel.
	public void checkDeck() {
		RenderableHolder.setCurrentImage20(RenderableHolder.getMonsterImage2(deck.getDeckList().get(0).getName()));
		RenderableHolder.setCurrentImage21(RenderableHolder.getMonsterImage2(deck.getDeckList().get(1).getName()));
		RenderableHolder.setCurrentImage22(RenderableHolder.getMonsterImage2(deck.getDeckList().get(2).getName()));
	}

	// Update the position of the player, chosen monster, coins and current position
	// of PlayerTwo.
	@Override
	public void update() {

		super.update();
		if (InputUtility.getKeyPressed(choose0)) {
			SimulationManager.setIsSelected2(0);
		} else if (InputUtility.getKeyPressed(choose1)) {
			SimulationManager.setIsSelected2(1);
		} else if (InputUtility.getKeyPressed(choose2)) {
			SimulationManager.setIsSelected2(2);
		}
		currentPos2 = currentPos;
		this.coins = SimulationManager.getCoins2();

		// If releaseMons is true then releases the monster that PlayerTwo chooses.
		if (releaseMons) {
			if (release instanceof Adventurer) {
				adventurer = new Adventurer("2");
				RenderableHolder.getInstance().add(adventurer);
				usedMonsterList.add(adventurer);
				releaseMons = false;
			}
			if (release instanceof Knight) {
				knight = new Knight("2");
				RenderableHolder.getInstance().add(knight);
				usedMonsterList.add(knight);
				releaseMons = false;
			}
			if (release instanceof Ninja) {
				ninja = new Ninja("2");
				RenderableHolder.getInstance().add(ninja);
				usedMonsterList.add(ninja);
				releaseMons = false;
			}
			if (release instanceof Robot) {
				robot = new Robot("2");
				RenderableHolder.getInstance().add(robot);
				usedMonsterList.add(robot);
				releaseMons = false;
			}
			if (release instanceof Santa) {
				santa = new Santa("2");
				RenderableHolder.getInstance().add(santa);
				usedMonsterList.add(santa);
				releaseMons = false;
			}
		}

		// Update all monsters that PlayerTwo releases.
		if (!usedMonsterList.isEmpty()) {
			for (Monster i : this.usedMonsterList) {
				i.update();
			}
		}
	}

}
