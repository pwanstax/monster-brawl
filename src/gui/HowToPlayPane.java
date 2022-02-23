package gui;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.SimulationManager;

public class HowToPlayPane extends StackPane {

	// ------------------------------ FIELD ------------------------------ //

	private Label instruction11, instruction12, instruction21, instruction22;
	private ImageView playerOneImgv, playerTwoImgv;
	private HBox playerOnePane, playerTwoPane;
	private Button backBtn;
	private VBox playerPane;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public HowToPlayPane() {
		// initialize all child node and add to parent
		super();
		this.setStyle(
				"-fx-background-image: url('res/woodbackground.jpg'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 800 600;");

		loadResource();
		initPlayerOnePane();
		initPlayerTwoPane();
		initBackButton();
		initPlayerPane();

		this.getChildren().addAll(playerPane);
	}

	// ------------------------------ METHOD ------------------------------ //

	private void loadResource() {
		// load image
		playerOneImgv = new ImageView(new Image(getClass().getResource("../res/adventurerSprite/Idle (1).png").toString(), 80, 600 / 8, false, true));
		playerTwoImgv = new ImageView(new Image(getClass().getResource("../res/adventurerSprite/Idle (1).png").toString(), 80, 600 / 8, false, true));
		playerTwoImgv.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
	}

	public void initPlayerPane() {
		// initialize
		playerPane = new VBox(30);
		playerPane.setPadding(new Insets(50, 20, 50, 20));
		playerPane.setAlignment(Pos.TOP_CENTER);
		playerPane.getChildren().addAll(playerOnePane, playerTwoPane, backBtn);
	}

	public void initPlayerOnePane() {
		// initialize playerOnePane , instruction11 , instruction12
		playerOnePane = new HBox(20);
		playerOnePane.setStyle(
				"-fx-background-image: url('res/howtoplaypaper.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 700 200;");
		playerOnePane.setPrefSize(700, 200);
		playerOnePane.setAlignment(Pos.CENTER);

		instruction11 = new Label("Player1\nW : go up\nS : go down\nSPACE BAR : release monster");
		SimulationManager.setFont((Label) instruction11, 20);

		instruction12 = new Label("\n1 : select slot1\n2 : select slot2\n3 : select slot3");
		SimulationManager.setFont((Label) instruction12, 20);

		playerOnePane.getChildren().addAll(playerOneImgv, instruction11, instruction12);
	}

	public void initPlayerTwoPane() {
		// initialize PlayerTwoPane , instruction21 , instruction22
		playerTwoPane = new HBox(20);
		playerTwoPane.setStyle(
				"-fx-background-image: url('res/howtoplaypaper.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 700 200;");
		playerTwoPane.setPrefSize(700, 200);
		playerTwoPane.setAlignment(Pos.CENTER);

		instruction21 = new Label("Player2\nW : go up\nS : go down\nSPACE BAR : release monster");
		SimulationManager.setFont((Label) instruction21, 20);

		instruction22 = new Label("\n+ : select slot1\n- : select slot2\n0 : select slot3");
		SimulationManager.setFont((Label) instruction22, 20);

		playerTwoPane.getChildren().addAll(instruction21, instruction22, playerTwoImgv);
	}

	public void initBackButton() {
		// initialize back button
		backBtn = new Button("Back");
		SimulationManager.setFont((Button) backBtn, 20);
	}

	public Button getBackBtn() {
		return backBtn;
	}
}