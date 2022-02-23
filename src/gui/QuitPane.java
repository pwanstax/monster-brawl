package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sharedObject.SimulationManager;

public class QuitPane extends HBox {

	// ------------------------------ FIELD ------------------------------ //

	private Button menuBtn;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public QuitPane(int width, int height) {

		// set property to pane and initialize menu button
		setPrefSize(width, height);
		setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, null, null)));
		setPadding(new Insets(1, 5, 1, 5));
		this.setStyle("-fx-background-image: url('woodbackground.jpg');");
		initMenuButton();
		this.getChildren().add(menuBtn);
	}

	// ------------------------------ METHOD ------------------------------ //

	public void initMenuButton() {

		// initialize and set action to menu button
		menuBtn = new Button("MENU");
		menuBtn.setAlignment(Pos.BASELINE_LEFT);
		menuBtn.setFocusTraversable(false);
		SimulationManager.setFont((Button) menuBtn, 14);
		menuBtn.setOnMouseClicked((MouseEvent e) -> {
			SimulationManager.setGameEnd(true);
			SimulationManager.setBackToMenu(true);
		});
	}
}