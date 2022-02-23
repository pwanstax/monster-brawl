package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {

	// ------------------------------ METHOD ------------------------------ //
	
	public int getZ();

	public void draw(GraphicsContext gc);

}
