package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import sharedObject.SimulationManager;

public abstract class MonsterChannel extends HBox {

	// ------------------------------ FIELD ------------------------------ //

	protected HBox deckchannel;
	protected Label coinschannel;
	protected StackPane card0, card1, card2;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public MonsterChannel(double width, double height) {
		// initialize all child node
		this.setPrefSize(width, height);
		this.setAlignment(Pos.CENTER);

		initDeckChannel(width);
		initCard(width);
		initCoinChannel(width);

	}

	// ------------------------------ METHOD ------------------------------ //

	public void initCard(double width) {
		// initialize all cards
		card0 = new StackPane();
		setCard(this.card0, width);
		card1 = new StackPane();
		setCard(this.card1, width);
		card2 = new StackPane();
		setCard(this.card2, width);
	}

	public void setCard(StackPane card, double width) {
		// set card property
		card.setPrefWidth(width * 0.7 / 3);
		card.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		card.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
	}

	public void initDeckChannel(double width) {
		// initialize deckChannel
		deckchannel = new HBox();
		deckchannel.setPrefWidth(width * 0.7);
		deckchannel.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}

	public void initCoinChannel(double width) {
		// initialize coinChannel
		coinschannel = new Label();
		coinschannel.setPrefWidth(width * 0.3);
		SimulationManager.setFont(coinschannel, 30);
		coinschannel.setAlignment(Pos.CENTER);
	}

	public void highlight(StackPane card) {
		// paint green color
		card.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, null, null)));
	}

	public void unhighlight(StackPane card) {
		// paint white color
		card.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
	}

	public abstract void checkSelected();

	public abstract void editImage();

	public void paintComponent() {
		// displays monster images
		editImage();
		checkSelected();

	}

}