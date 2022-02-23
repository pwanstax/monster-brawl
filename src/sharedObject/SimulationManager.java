package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import entity.base.Monster;
import entity.Barrel;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;

public class SimulationManager {

	// ------------------------------ FIELD ------------------------------ //

	private static int inGameTime;
	private static boolean isGameEnd;
	private static boolean isBackToMenu;
	private static String gameResult;
	private static int points1;
	private static int points2;
	private static int isSelected1;
	private static int isSelected2;
	private static int XP1;
	private static int XP2;
	private static ArrayList<Integer> Y;
	private static int coins1;
	private static int coins2;
	private static String WonLane1;
	private static String WonLane2;
	private static String WonLane3;
	private static String WonLane4;
	private static String WonLane5;
	private static ArrayList<Monster> P1Lane1;
	private static ArrayList<Monster> P1Lane2;
	private static ArrayList<Monster> P1Lane3;
	private static ArrayList<Monster> P1Lane4;
	private static ArrayList<Monster> P1Lane5;
	private static ArrayList<ArrayList<Monster>> P1AllMonster;
	private static ArrayList<Monster> P2Lane1;
	private static ArrayList<Monster> P2Lane2;
	private static ArrayList<Monster> P2Lane3;
	private static ArrayList<Monster> P2Lane4;
	private static ArrayList<Monster> P2Lane5;
	private static ArrayList<ArrayList<Monster>> P2AllMonster;
	private static ArrayList<Barrel> barrelList;
	public static String fontUrl = "src/Font/EmotionEngine-8ynA.ttf";

	// ------------------------------ METHOD ------------------------------ //

	// set the font
	public static void setFont(Labeled label, int size) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(fontUrl), size));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// set up and initialize miscellaneous things in this game.
	public static void setUpSimulationManager() {
		RenderableHolder.getInstance().getEntities().clear();
		SimulationManager.setGameEnd(false);
		SimulationManager.setBackToMenu(false);

		SimulationManager.setIsSelected1(0);
		SimulationManager.setPoints1(0);

		SimulationManager.setIsSelected2(0);
		SimulationManager.setPoints2(0);

		P1Lane1 = new ArrayList<>();
		P1Lane2 = new ArrayList<>();
		P1Lane3 = new ArrayList<>();
		P1Lane4 = new ArrayList<>();
		P1Lane5 = new ArrayList<>();
		P1AllMonster = new ArrayList<>();

		P2Lane1 = new ArrayList<>();
		P2Lane2 = new ArrayList<>();
		P2Lane3 = new ArrayList<>();
		P2Lane4 = new ArrayList<>();
		P2Lane5 = new ArrayList<>();
		P2AllMonster = new ArrayList<>();

		P1AllMonster.add(P1Lane1);
		P1AllMonster.add(P1Lane2);
		P1AllMonster.add(P1Lane3);
		P1AllMonster.add(P1Lane4);
		P1AllMonster.add(P1Lane5);

		P2AllMonster.add(P2Lane1);
		P2AllMonster.add(P2Lane2);
		P2AllMonster.add(P2Lane3);
		P2AllMonster.add(P2Lane4);
		P2AllMonster.add(P2Lane5);

		barrelList = new ArrayList<>();
		Y = new ArrayList<>();

		WonLane1 = "none";
		WonLane2 = "none";
		WonLane3 = "none";
		WonLane4 = "none";
		WonLane5 = "none";

	}
	// sum up damage from PlayerOne.
	public static int getTotalDamage1() {
		int point1 = 0;
		for (Barrel i : barrelList) {
			point1 += i.getDamageFrom1();
		}
		return point1;
	}
	// sum up damage from PlayerTwo.
	public static int getTotalDamage2() {
		int point2 = 0;
		for (Barrel i : barrelList) {
			point2 += i.getDamageFrom2();
		}
		return point2;
	}
	// add PlayerOne's coin.
	public static void setCoins1Increase(int x) {
		coins1 += x;
	}
	// add PlayerTwo's coin.
	public static void setCoins2Increase(int x) {
		coins2 += x;
	}
	// remove PlayerOne's coin.
	public static void setCoins1Decrease(int x) {
		coins1 -= x;
	}
	// remove PlayerTwo's coin.
	public static void setCoins2Decrease(int x) {
		coins2 -= x;
	}
	// decrease time in the game.
	public static void setDecreaseIngametime() {
		SimulationManager.inGameTime -= 1;
	}

	// ------------------------------ GETTER,SETTER ------------------------------ //

	public static boolean isGameEnd() {
		return isGameEnd;
	}

	public static boolean isBackToMenu() {
		return isBackToMenu;
	}

	public static void setBackToMenu(boolean isBackToMenu) {
		SimulationManager.isBackToMenu = isBackToMenu;
	}

	public static void setGameEnd(boolean isGameEnd) {
		SimulationManager.isGameEnd = isGameEnd;
	}

	public static void setPoints1(int points1) {
		SimulationManager.points1 = points1;
	}

	public static void setPoints2(int points2) {
		SimulationManager.points2 = points2;
	}

	public static int getPoints1() {
		return points1;
	}

	public static int getPoints2() {
		return points2;
	}

	public static String getGameResult() {
		return gameResult;
	}

	public static void setGameresult(String gameResult) {
		SimulationManager.gameResult = gameResult;
	}

	public static int getCoins1() {
		return coins1;
	}

	public static int getCoins2() {
		return coins2;
	}

	public static void setCoins1(int coins1) {
		SimulationManager.coins1 = coins1;
	}

	public static void setCoins2(int coins2) {
		SimulationManager.coins2 = coins2;
	}

	public static int getIngametime() {
		return inGameTime;
	}

	public static void setIngametime(int ingametime) {
		SimulationManager.inGameTime = ingametime;
	}

	public static int getIsSelected1() {
		return isSelected1;
	}

	public static void setIsSelected1(int isSelected1) {
		SimulationManager.isSelected1 = isSelected1;
	}

	public static int getIsSelected2() {
		return isSelected2;
	}

	public static void setIsSelected2(int isSelected2) {
		SimulationManager.isSelected2 = isSelected2;
	}

	public static int getXP1() {
		return XP1;
	}

	public static void setXP1(int xP1) {
		XP1 = xP1;
	}

	public static ArrayList<Integer> getY() {
		return Y;
	}

	public static void setY(ArrayList<Integer> yP1) {
		Y = yP1;
	}

	public static int getXP2() {
		return XP2;
	}

	public static void setXP2(int xP2) {
		XP2 = xP2;
	}

	public static ArrayList<Monster> getP1Lane1() {
		return P1Lane1;
	}

	public static void setP1Lane1(ArrayList<Monster> p1Lane1) {
		P1Lane1 = p1Lane1;
	}

	public static ArrayList<Monster> getP1Lane2() {
		return P1Lane2;
	}

	public static void setP1Lane2(ArrayList<Monster> p1Lane2) {
		P1Lane2 = p1Lane2;
	}

	public static ArrayList<Monster> getP1Lane3() {
		return P1Lane3;
	}

	public static void setP1Lane3(ArrayList<Monster> p1Lane3) {
		P1Lane3 = p1Lane3;
	}

	public static ArrayList<Monster> getP1Lane4() {
		return P1Lane4;
	}

	public static void setP1Lane4(ArrayList<Monster> p1Lane4) {
		P1Lane4 = p1Lane4;
	}

	public static ArrayList<Monster> getP1Lane5() {
		return P1Lane5;
	}

	public static void setP1Lane5(ArrayList<Monster> p1Lane5) {
		P1Lane5 = p1Lane5;
	}

	public static ArrayList<Monster> getP2Lane1() {
		return P2Lane1;
	}

	public static void setP2Lane1(ArrayList<Monster> p2Lane1) {
		P2Lane1 = p2Lane1;
	}

	public static ArrayList<Monster> getP2Lane2() {
		return P2Lane2;
	}

	public static void setP2Lane2(ArrayList<Monster> p2Lane2) {
		P2Lane2 = p2Lane2;
	}

	public static ArrayList<Monster> getP2Lane3() {
		return P2Lane3;
	}

	public static void setP2Lane3(ArrayList<Monster> p2Lane3) {
		P2Lane3 = p2Lane3;
	}

	public static ArrayList<Monster> getP2Lane4() {
		return P2Lane4;
	}

	public static void setP2Lane4(ArrayList<Monster> p2Lane4) {
		P2Lane4 = p2Lane4;
	}

	public static ArrayList<Monster> getP2Lane5() {
		return P2Lane5;
	}

	public static void setP2Lane5(ArrayList<Monster> p2Lane5) {
		P2Lane5 = p2Lane5;
	}

	public static ArrayList<ArrayList<Monster>> getP1AllMonster() {
		return P1AllMonster;
	}

	public static void setP1AllMonster(ArrayList<ArrayList<Monster>> p1AllMonster) {
		P1AllMonster = p1AllMonster;
	}

	public static ArrayList<ArrayList<Monster>> getP2AllMonster() {
		return P2AllMonster;
	}

	public static void setP2AllMonster(ArrayList<ArrayList<Monster>> p2AllMonster) {
		P2AllMonster = p2AllMonster;
	}

	public static ArrayList<Barrel> getBarrelList() {
		return barrelList;
	}

	public static void setBarrelList(ArrayList<Barrel> barrelList) {
		SimulationManager.barrelList = barrelList;
	}

	public static String getWonLane1() {
		return WonLane1;
	}

	public static void setWonLane1(String wonLane1) {
		WonLane1 = wonLane1;
	}

	public static String getWonLane2() {
		return WonLane2;
	}

	public static void setWonLane2(String wonLane2) {
		WonLane2 = wonLane2;
	}

	public static String getWonLane3() {
		return WonLane3;
	}

	public static void setWonLane3(String wonLane3) {
		WonLane3 = wonLane3;
	}

	public static String getWonLane4() {
		return WonLane4;
	}

	public static void setWonLane4(String wonLane4) {
		WonLane4 = wonLane4;
	}

	public static String getWonLane5() {
		return WonLane5;
	}

	public static void setWonLane5(String wonLane5) {
		WonLane5 = wonLane5;
	}

}
