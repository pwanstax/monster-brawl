package gui;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.SimulationManager;

public class GamePane extends VBox {

	// ------------------------------ FIELD ------------------------------ //

	private TimePane timePane;
	private StackPane gamescreenStack;
	private GameScreen gamescreen;
	private QuitPane quitPane;
	private GameResult gameResult;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public GamePane(int width, int height) {
		// initialize all fields
		timePane = new TimePane(width, 60);
		gamescreenStack = new StackPane();
		gamescreen = new GameScreen(width, height - 100);
		gamescreen.setFocusTraversable(true);
		gameResult = new GameResult(width / 2, (height - 100) / 2);
		gamescreenStack.getChildren().add(gamescreen);
		quitPane = new QuitPane(width, 45);
		getChildren().addAll(timePane, gamescreenStack, quitPane);

	}

	// ------------------------------ METHOD ------------------------------ //

	public void paintComponent() {
		// paint all component of gameplay and check if game is over
		timePane.paintComponent();
		gamescreen.paintComponent();
		if (SimulationManager.isGameEnd()) {
			paintGameResult();
		}

	}

	public void paintGameResult() {
		// show game result pane
		this.gameResult.getWinner().setText(SimulationManager.getGameResult());
		gamescreenStack.getChildren().setAll(this.gamescreen, this.gameResult);

	}
}
