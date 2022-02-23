package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public abstract class PlayerField implements IRenderable {

	// ------------------------------ FIELD ------------------------------ //

	protected int X, Z, width, height;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public PlayerField(int width, int height) {
		this.width = width;
		this.height = height;
		this.Z = -5000;
	}

	// ------------------------------ METHOD ------------------------------ //

	public int getZ() {
		return Z;
	}

	public abstract void draw(GraphicsContext gc);

}
