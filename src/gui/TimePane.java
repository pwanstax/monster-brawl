package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sharedObject.SimulationManager;

public class TimePane extends HBox {

	// ------------------------------ FIELD ------------------------------ //

	private Label timeChannel;
	private Label pointChannel1, pointChannel2;
	private MonsterChannel1 monsterChannel1;
	private MonsterChannel2 monsterChannel2;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public TimePane(int width, int height) {

		// initialize all child node
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setStyle("-fx-background-image: url('gameresultBackground.jpg');");

		initMonsterChannel(width * 3 / 10, height);
		initTimeChannel(width / 5, height);
		initPointChannel(width / 10, height);
		initPointChannel(width / 10, height);
		this.getChildren().addAll(monsterChannel1, pointChannel1, timeChannel, pointChannel2, monsterChannel2);

	}

	// ------------------------------ METHOD ------------------------------ //

	public void paintComponent() {
		// displays all components in timepane
		timeChannel.setText(Integer.toString(SimulationManager.getIngametime()));
		monsterChannel1.paintComponent();
		monsterChannel2.paintComponent();
		pointChannel1.setText(Integer.toString(SimulationManager.getPoints1()));
		pointChannel2.setText(Integer.toString(SimulationManager.getPoints2()));
	}

	public void initMonsterChannel(int width, int height) {
		// initialize monsterChannel1 , monsterChannel2
		monsterChannel1 = new MonsterChannel1(width, height);
		monsterChannel2 = new MonsterChannel2(width, height);
	}

	public void initTimeChannel(int width, int height) {
		// initialize TimeChannnel
		timeChannel = new Label(Integer.toString(SimulationManager.getIngametime()));
		timeChannel.setAlignment(Pos.CENTER);
		timeChannel.setPrefSize(width, height);
		SimulationManager.setFont(((Label) timeChannel), 60);
	}

	public void initPointChannel(int width, int height) {
		// initialize pointChannnel1 , pointChannnel2
		pointChannel1 = new Label();
		pointChannel1.setAlignment(Pos.CENTER);
		pointChannel1.setPrefSize(width, height);
		SimulationManager.setFont(((Label) pointChannel1), 50);

		pointChannel2 = new Label();
		pointChannel2.setAlignment(Pos.CENTER);
		pointChannel2.setPrefSize(width, height);
		SimulationManager.setFont(((Label) pointChannel2), 50);
	}

}
