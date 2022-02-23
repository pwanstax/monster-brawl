package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import sharedObject.SimulationManager;

public class GameResult extends VBox {

	// ------------------------------ FIELD ------------------------------ //

	private Label winner;
	private Button menuBtn;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public GameResult(int width, int height) {
		// initialize all fields and set pane
		super(10);
		setMaxSize(width, height);
		setAlignment(Pos.CENTER);
		setStyle(
				"-fx-background-image: url('res/scrollbackground.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 400 300;");

		initWinner();
		initMenuBtn();

		this.getChildren().addAll(winner, menuBtn);

	}

	// ------------------------------ METHOD ------------------------------ //

	public Label getWinner() {
		return winner;
	}

	public void initWinner() {
		// initialize winner label
		winner = new Label(SimulationManager.getGameResult());
		winner.setAlignment(Pos.CENTER);
		SimulationManager.setFont((Label) winner, 40);
	}

	public void initMenuBtn() {
		// initialize back to main menu button
		menuBtn = new Button("Main Menu");
		menuBtn.setPrefSize(100, 40);
		SimulationManager.setFont(((Button) menuBtn), 16);

		// set action to menu button
		menuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SimulationManager.setBackToMenu(true);
			}
		});
	}

}
