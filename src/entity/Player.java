package entity;

import java.util.ArrayList;

import entity.base.Monster;
import input.InputUtility;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.Deck;

public abstract class Player extends Entity {

	// ------------------------------ FIELD ------------------------------ //
	
	protected int currentPos;
	protected int coordinateX, coordinateY;
	protected boolean[] pos = { false, false, false, false, false };
	protected KeyCode up;
	protected KeyCode down;
	protected KeyCode releaseMonster;
	protected KeyCode choose0;
	protected KeyCode choose1;
	protected KeyCode choose2;
	protected int coins;
	protected Monster release;
	protected Deck deck;
	protected Image currentSprite;
	protected Monster adventurer, knight, ninja, santa, robot;
	protected boolean releaseMons = false;
	protected ArrayList<Monster> usedMonsterList;

	// ------------------------------ CONSTRUCTOR ------------------------------ //
	
	// initialize new deck from the inputed array.
	// the current position of a player will be set as true.
	public Player(Monster... monsters) {
		deck = new Deck(monsters);
		currentPos = 2;
		pos[currentPos] = true;
	}

	// ------------------------------ METHOD ------------------------------ //
	
	public void update() {
		// update the position of the player from up/down key and release monster from
		// space bar
		if (InputUtility.getKeyPressed(up) && !pos[0]) {
			pos[currentPos - 1] = true;
			pos[currentPos] = false;
			currentPos -= 1;

		} else if (InputUtility.getKeyPressed(down) && !pos[pos.length - 1]) {
			pos[currentPos + 1] = true;
			pos[currentPos] = false;
			currentPos += 1;
		}
		if (InputUtility.getKeyPressed(releaseMonster)) {
			releaseMonster();
		}
	}

	public abstract boolean isMonsterReady();

	public abstract void releaseMonster();

	// ------------------------------ GETTER,SETTER ------------------------------ //
	
	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int x) {
		coordinateX = x;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int y) {
		coordinateY = y;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Monster getRelease() {
		return release;
	}

}
