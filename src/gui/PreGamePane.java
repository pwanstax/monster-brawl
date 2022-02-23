package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import exception.UnselectedException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.SimulationManager;

public class PreGamePane extends StackPane {

	// ------------------------------ FIELD ------------------------------ //

	private Label time;
	private Label coin;
	private CheckBox time90, time120, time180, coin0, coin10, coin20;
	private Button startBtn;
	private Button backBtn;
	private Tooltip tooltip;
	private Label description;
	private HBox timePane;
	private HBox coinPane;
	private HBox buttonPane;
	private VBox form;
	private boolean anyTimeBoxSelected;
	private boolean anyCoinBoxSelected;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public PreGamePane(int width, int height) {
		// TODO Auto-generated constructor stub
		// initialize all child node
		setPadding(new Insets(50));
		this.setStyle(
				"-fx-background-image: url('res/woodbackground.jpg'); -fx-background-repeat: stretch; -fx-background-position: center center;");

		initTimePane();
		initCoinPane();
		initButtonPane();
		initForm();

		this.getChildren().add(form);
	}

	// ------------------------------ METHOD ------------------------------ //

	public void initTimePane() {
		// initialize timepane , time label , time90 , time120 ,time180
		timePane = new HBox(20);
		timePane.setAlignment(Pos.CENTER);

		time = new Label("  Time :");
		SimulationManager.setFont(((Label) time), 30);

		time90 = new CheckBox("90");
		SimulationManager.setFont(((CheckBox) time90), 30);

		time120 = new CheckBox("120");
		SimulationManager.setFont(((CheckBox) time120), 30);

		time180 = new CheckBox("180");
		SimulationManager.setFont(((CheckBox) time180), 30);

		setupTimeSelectedLogic(time90, time120, time180);
		timePane.getChildren().addAll(time, time90, time120, time180);
	}

	public void initCoinPane() {

		// initialize coinpane ,coin label , coin0 , coin10 ,coin20
		coinPane = new HBox(20);
		coinPane.setAlignment(Pos.CENTER);

		coin = new Label("coin :");
		SimulationManager.setFont(((Label) coin), 30);

		coin0 = new CheckBox("0");
		SimulationManager.setFont(((CheckBox) coin0), 30);

		coin10 = new CheckBox("10");
		SimulationManager.setFont(((CheckBox) coin10), 30);

		coin20 = new CheckBox("20");
		SimulationManager.setFont(((CheckBox) coin20), 30);

		setupcoinSelectedLogic(coin0, coin10, coin20);
		coinPane.getChildren().addAll(coin, coin0, coin10, coin20);
	}

	public void initButtonPane() {
		// initialize buttonpane , startbtn , backBtn , tooltip
		buttonPane = new HBox(20);
		buttonPane.setAlignment(Pos.CENTER);

		backBtn = new Button("Back");
		SimulationManager.setFont(((Button) backBtn), 30);

		startBtn = new Button("start");
		SimulationManager.setFont(((Button) startBtn), 30);

		tooltip = new Tooltip();

		try {
			tooltip.setFont(Font.loadFont(new FileInputStream(SimulationManager.fontUrl), 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tooltip.setFont(new Font(20));
		}
		buttonPane.getChildren().addAll(backBtn, startBtn);
	}

	public void initForm() {
		// initialize description and form
		description = new Label("Select time and coin");
		SimulationManager.setFont(((Label) description), 60);
		description.setAlignment(Pos.TOP_LEFT);

		form = new VBox(30);
		form.setPadding(new Insets(0, 50, 0, 50));
		form.setAlignment(Pos.CENTER);
		form.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
		form.setStyle(
				"-fx-background-image: url('res/scrollbackground.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 700 500;");
		form.getChildren().addAll(description, timePane, coinPane, buttonPane);
	}

	public void setupTimeSelectedLogic(CheckBox box90, CheckBox box120, CheckBox box180) {
		// only one box can be clicked
		// if box90 is selected ,ingametime = 90
		box90.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				box120.setSelected(false);
				box180.setSelected(false);
				if (box90.isSelected()) {
					SimulationManager.setIngametime(90);
				}
			}
		});
		// if box120 is selected ,ingametime = 120
		box120.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				box90.setSelected(false);
				box180.setSelected(false);
				if (box120.isSelected()) {
					SimulationManager.setIngametime(120);
				}
			}
		});
		// if box180 is selected ,ingametime = 180
		box180.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				box120.setSelected(false);
				box90.setSelected(false);
				if (box180.isSelected()) {
					SimulationManager.setIngametime(180);
				}
			}
		});
	}

	public void setupcoinSelectedLogic(CheckBox coin0, CheckBox coin10, CheckBox coin20) {
		// only one box can be clicked
		// if coin0 box is selected , start coins = 0
		coin0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				coin10.setSelected(false);
				coin20.setSelected(false);
				if (coin0.isSelected()) {
					SimulationManager.setCoins1(0);
					SimulationManager.setCoins2(0);
				}
			}
		});
		// if coin10 box selected , start coins = 10
		coin10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				coin0.setSelected(false);
				coin20.setSelected(false);
				if (coin10.isSelected()) {
					SimulationManager.setCoins1(10);
					SimulationManager.setCoins2(10);
				}
			}
		});
		// if coin20 box selected , start coins = 20
		coin20.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				coin0.setSelected(false);
				coin10.setSelected(false);
				if (coin20.isSelected()) {
					SimulationManager.setCoins1(20);
					SimulationManager.setCoins2(20);
				}
			}
		});
	}

	public void setAlertText(String message) {
		// set message to tooltip and set tooltip to start button
		tooltip.setText(message);
		startBtn.setOnMouseClicked((MouseEvent e) -> {
			tooltip.show(startBtn, e.getScreenX(), e.getScreenY() + 10);
		});
		startBtn.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
		startBtn.setTooltip(tooltip);
	}

	public boolean isAllTick() throws UnselectedException {
		// if none of timeboxes is selected ,set setAnyTimeBoxSelected to false
		setAnyTimeBoxSelected(time90.isSelected() || time120.isSelected() || time180.isSelected());

		// if none of coinboxes is selected ,set setAnyCoinBoxSelected to false
		setAnyCoinBoxSelected(coin0.isSelected() || coin10.isSelected() || coin20.isSelected());

		// if Both timeboxes and coinboxes are not selected throw an exception
		if (!isAnyTimeBoxSelected() && !isAnyCoinBoxSelected()) {
			throw new UnselectedException("You must select time and coin!!");

			// if only timeboxes is not selected throw an another exception
		} else if (!isAnyTimeBoxSelected()) {
			throw new UnselectedException("You must select time!!");

			// if only coinboxes is not selected throw an another exception
		} else if (!isAnyCoinBoxSelected()) {
			throw new UnselectedException("You must select coin!!");
		}

		return true;

	}

	// ------------------------------ GETTER,SETTER ------------------------------ //
	
	public boolean isAnyTimeBoxSelected() {
		return anyTimeBoxSelected;
	}

	public void setAnyTimeBoxSelected(boolean anyTimeBoxSelected) {
		this.anyTimeBoxSelected = anyTimeBoxSelected;
	}

	public boolean isAnyCoinBoxSelected() {
		return anyCoinBoxSelected;
	}

	public void setAnyCoinBoxSelected(boolean anycoinBoxSelected) {
		this.anyCoinBoxSelected = anycoinBoxSelected;
	}

	public Button getStartBtn() {
		return startBtn;
	}

	public Button getBackBtn() {
		return backBtn;
	}

}
