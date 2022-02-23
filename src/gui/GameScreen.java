package gui;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas {

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public GameScreen(double width, double height) {
		// set width ,height , add listener
		super(width, height);
		addListener();
	}

	// ------------------------------ METHOD ------------------------------ //

	public void addListener() {
		// receive keyboard inputs and sent them to InputUtility
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public void paintComponent() {
		// draw all entity in RenderableHolder on canvas
		GraphicsContext gc = this.getGraphicsContext2D();
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			entity.draw(gc);
		}
	}

}
