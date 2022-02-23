package logic;

import java.util.ArrayList;
import java.util.Random;
import entity.base.Monster;

public class Deck {

	// ------------------------------ FIELD ------------------------------ //

	private ArrayList<Monster> monsterList = new ArrayList<>();
	private ArrayList<Monster> deckList = new ArrayList<>();

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public Deck(Monster[] monsters) {
		// add first 3 monsters in monsters arrays to deckList
		for (int i = 0; i < 3; i++) {
			deckList.add(monsters[i]);
		}
		// add last 2 monsters in monsters arrays to deckList
		for (int j = 3; j < monsters.length; j++) {
			monsterList.add(monsters[j]);
		}
	}

	// ------------------------------ METHOD ------------------------------ //

	public Monster getMonsterinDeckList(int i) {
		// return monster No.i in deckList
		return deckList.get(i);
	}

	public void addRandomMonster() {
		// remove random monster in the monsterList and add it to deckList
		Random rand = new Random();
		int value = rand.nextInt(monsterList.size());
		deckList.add(monsterList.get(value));
		monsterList.remove(monsterList.get(value));
	}

	public Monster removeMonster(int i) {
		// remove monster in deckList and return removed monster
		Monster removal = deckList.get(i);
		deckList.remove(i);
		return removal;

	}

	// ------------------------------ GETTER,SETTER ------------------------------ //
	
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public ArrayList<Monster> getDeckList() {
		return deckList;
	}

}
