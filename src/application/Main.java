package application;

import exception.UnselectedException;
import gui.GamePane;
import gui.HowToPlayPane;
import gui.MenuPane;
import gui.PreGamePane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
// import javafx.scene.media.Media;
// import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.SimulationManager;

public class Main extends Application {
	// private MediaPlayer menuMusic ;
	// private MediaPlayer gameplayMusic ;
	private long lastTimeTriggered = -1;
	private MenuPane menu;
	private PreGamePane pregame;
	private HowToPlayPane howToPlay;
	private GamePane gamepane;
	private GameLogic logic;
	private Scene menuScene;
	private Scene pregameScene;
	private Scene gameScene;
	private Scene HowToPlayScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		
		// Initialize main menu		
		menu = new MenuPane();
		menuScene = new Scene(menu, 800, 600);
		howToPlay = new HowToPlayPane();
		HowToPlayScene = new Scene(howToPlay, 800, 600);

		stage.setResizable(false);
		stage.setScene(menuScene);
		stage.setTitle("Monster-Brawl");
		stage.show();
		
		// initialize sound
//		initSound();
//		menuMusic.play();
		
		// set start button
		menu.getstartButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setPreGamePane(stage);
			}
		});

		// set HowToPlay button
		menu.getHowToPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setHowToPlayPane(stage);
			}
		});
		// set quit button
		menu.getquitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});

	}
	
	public void setHowToPlayPane(Stage stage) {
		
		// set back button in how-to-play pane 
		stage.setScene(HowToPlayScene);
		howToPlay.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(menuScene);
			}
		});
			
		
	}
	
	public void setPreGamePane(Stage stage) {
		
		// init pre-game
		pregame =  new PreGamePane(800,600);
		pregameScene = new Scene(pregame , 800 , 600);
		stage.setScene(pregameScene);
		
		// set start button in pre-game
		pregame.getStartBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (pregame.isAllTick()) {
						setGameplay(stage);
//						menuMusic.stop();
//						gameplayMusic.play();
					}
				} catch (UnselectedException e) {
					pregame.setAlertText(e.message);
				} 
			}
		});
		// set back-button in pre-game
		pregame.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(menuScene);
			}
		});
	}
	
	public void setGameplay(Stage stage) {
		// initialize logic and gamepane
		logic = new GameLogic();
		SimulationManager.setBackToMenu(false);
		gamepane = new GamePane(800,600);
		gameScene = new Scene(gamepane,800,600);
		stage.setScene(gameScene);
		stage.setTitle("Monster-Brawl");
		
		// start animation 
		startAnimation(stage);
		// start timer
		startTimer(stage);
	}

	public void startAnimation(Stage stage) {
		
		// start game animation
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gamepane.paintComponent();
				if (!SimulationManager.isGameEnd()) {
					logic.logicUpdate();
				}
				if (SimulationManager.isBackToMenu()) {
					stop();
					stage.setScene(menuScene);
				}
			}
		};
		animation.start();
	}
	
	public void startTimer(Stage stage) {
		
		// start game timer
		AnimationTimer timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
				
				if (now - lastTimeTriggered >= 1000000000) {
					// 1 second pass 
					SimulationManager.setDecreaseIngametime();
					if (SimulationManager.getIngametime() % 2 == 0) {
					if (SimulationManager.getCoins1() < 49) {
						SimulationManager.setCoins1Increase(2);
					}
					if (SimulationManager.getCoins1() == 49) {
						SimulationManager.setCoins1Increase(1);
					}

					if (SimulationManager.getCoins2() < 49) {
						SimulationManager.setCoins2Increase(2);
					}
					if (SimulationManager.getCoins2() == 49) {
						SimulationManager.setCoins2Increase(1);
					}
				}
					
					lastTimeTriggered = now;
				}
				
				//check game is over?
				if (SimulationManager.isGameEnd()) {
					lastTimeTriggered = -1;
//					gameplayMusic.stop();
//					menuMusic.play();
					stop();
					
				}
			}
		};
		
		timer.start();
	}
	
	// public void initSound() {
	// 	// initialize menu sound and gameplay sound
	// 	menuMusic = new MediaPlayer(new Media(ClassLoader.getSystemResource("POL-treasure-match-short.wav").toString()));
	// 	gameplayMusic = new MediaPlayer(new Media(ClassLoader.getSystemResource("POL-road-duel-short.wav").toString()));
	// 	menuMusic.setCycleCount(menuMusic.INDEFINITE);
	// 	menuMusic.setVolume(0.1);
	// 	gameplayMusic.setCycleCount(gameplayMusic.INDEFINITE);
	// 	gameplayMusic.setVolume(0.1);
	// }
}
