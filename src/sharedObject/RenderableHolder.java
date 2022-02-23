package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class RenderableHolder {

	// ------------------------------ FIELD ------------------------------ //

	private static final RenderableHolder instance = new RenderableHolder();

	private static Map<String, ImageView> map1 = new HashMap<String, ImageView>();
	private static Map<String, ImageView> map2 = new HashMap<String, ImageView>();

	private static Image playerOneSprite;
	private static Image playerTwoSprite;
	private static Image backgroundImg;
	private static Image wallBackground;
	private static Image menuBackground;
	private static Image gameResultBackground;

	private static Image barrel;
	private static Image switchOn;
	private static Image switchOff;
	private static Image doorOpen;
	private static Image doorClose;

	private static Image adventurerIcon;
	private static Image knightIcon;
	private static Image ninjaIcon;
	private static Image santaIcon;
	private static Image robotIcon;

	private static WritableImage background;

	private static ImageView currentImage10;
	private static ImageView currentImage11;
	private static ImageView currentImage12;
	private static ImageView currentImage20;
	private static ImageView currentImage21;
	private static ImageView currentImage22;

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	static {
		loadResource();
		ImageAnimationManager.loadAnimationImage();
	}

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public RenderableHolder() {
		// initialize entities and comparator
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	// ------------------------------ METHOD ------------------------------ //

	public static void loadResource() {
		// initialize images
		playerOneSprite = new Image(ClassLoader.getSystemResource("res/playerOneSprite.png").toString(), 80, 600 / 8, false,
				true);
		playerTwoSprite = new Image(ClassLoader.getSystemResource("res/playerTwoSprite.png").toString(), 70, 75, true,
				true);

		adventurerIcon = new Image(ClassLoader.getSystemResource("res/Adventurer.PNG").toString(), 56, 65, false, true);
		knightIcon = new Image(ClassLoader.getSystemResource("res/Knight.PNG").toString(), 56, 65, false, true);
		ninjaIcon = new Image(ClassLoader.getSystemResource("res/Ninja.PNG").toString(), 56, 65, false, true);
		santaIcon = new Image(ClassLoader.getSystemResource("res/Santa.PNG").toString(), 56, 65, false, true);
		robotIcon = new Image(ClassLoader.getSystemResource("res/Robot.PNG").toString(), 56, 65, false, true);

		backgroundImg = new Image(ClassLoader.getSystemResource("res/background.jpg").toString());
		PixelReader croppedBackground = backgroundImg.getPixelReader();
		background = new WritableImage(croppedBackground, 0, (int) backgroundImg.getHeight() / 5 + 100, 800, 500);

		menuBackground = new Image(ClassLoader.getSystemResource("res/menubackground.jpg").toString());
		wallBackground = new Image(ClassLoader.getSystemResource("res/gameresultBackground.jpg").toString(), 800, 65, false,
				true);
		gameResultBackground = new Image(ClassLoader.getSystemResource("res/gameresultBackground.png").toString());

		barrel = new Image(ClassLoader.getSystemResource("res/Objects/Barrel (1).png").toString());
		switchOn = new Image(ClassLoader.getSystemResource("res/Objects/Switch (1).png").toString());
		switchOff = new Image(ClassLoader.getSystemResource("res/Objects/Switch (2).png").toString());
		doorOpen = new Image(ClassLoader.getSystemResource("res/Objects/DoorOpen.png").toString());
		doorClose = new Image(ClassLoader.getSystemResource("res/Objects/DoorLocked.png").toString());

	}

	public static void loadMap() {
		// initialize map1 ,map2
		map1.put("Adventurer", new ImageView(adventurerIcon));
		map1.put("Knight", new ImageView(knightIcon));
		map1.put("Ninja", new ImageView(ninjaIcon));
		map1.put("Robot", new ImageView(robotIcon));
		map1.put("Santa", new ImageView(santaIcon));

		map2.put("Adventurer", new ImageView(adventurerIcon));
		map2.put("Knight", new ImageView(knightIcon));
		map2.put("Ninja", new ImageView(ninjaIcon));
		map2.put("Robot", new ImageView(robotIcon));
		map2.put("Santa", new ImageView(santaIcon));

	}

	// ------------------------------ GETTER,SETTER ------------------------------ //

	public static ImageView getMonsterImage1(String name) {
		return map1.get(name);
	}

	public static ImageView getMonsterImage2(String name) {
		return map2.get(name);
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);

	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	public static ImageView getCurrentImage10() {
		return currentImage10;
	}

	public static void setCurrentImage10(ImageView currentImage10) {
		RenderableHolder.currentImage10 = currentImage10;
	}

	public static ImageView getCurrentImage11() {
		return currentImage11;
	}

	public static void setCurrentImage11(ImageView currentImage11) {
		RenderableHolder.currentImage11 = currentImage11;
	}

	public static ImageView getCurrentImage12() {
		return currentImage12;
	}

	public static void setCurrentImage12(ImageView currentImage12) {
		RenderableHolder.currentImage12 = currentImage12;
	}

	public static ImageView getCurrentImage20() {
		return currentImage20;
	}

	public static void setCurrentImage20(ImageView currentImage20) {
		RenderableHolder.currentImage20 = currentImage20;
	}

	public static ImageView getCurrentImage21() {
		return currentImage21;
	}

	public static void setCurrentImage21(ImageView currentImage21) {
		RenderableHolder.currentImage21 = currentImage21;
	}

	public static ImageView getCurrentImage22() {
		return currentImage22;
	}

	public static void setCurrentImage22(ImageView currentImage22) {
		RenderableHolder.currentImage22 = currentImage22;
	}

	public static Image getBarrel() {
		return barrel;
	}

	public static void setBarrel(Image barrel) {
		RenderableHolder.barrel = barrel;
	}

	public static Image getSwitchOn() {
		return switchOn;
	}

	public static void setSwitchOn(Image switchOn) {
		RenderableHolder.switchOn = switchOn;
	}

	public static Image getSwitchOff() {
		return switchOff;
	}

	public static void setSwitchOff(Image switchOff) {
		RenderableHolder.switchOff = switchOff;
	}

	public static Image getDoorOpen() {
		return doorOpen;
	}

	public static void setDoorOpen(Image doorOpen) {
		RenderableHolder.doorOpen = doorOpen;
	}

	public static Image getDoorClose() {
		return doorClose;
	}

	public static void setDoorClose(Image doorClose) {
		RenderableHolder.doorClose = doorClose;
	}

	public static Image getPlayerOneSprite() {
		return playerOneSprite;
	}

	public static Image getPlayerTwoSprite() {
		return playerTwoSprite;
	}

	public static Image getBackgroundImg() {
		return backgroundImg;
	}

	public static Image getWallBackground() {
		return wallBackground;
	}

	public static Image getMenuBackground() {
		return menuBackground;
	}

	public static Image getGameResultBackground() {
		return gameResultBackground;
	}

	public static WritableImage getBackground() {
		return background;
	}

}
