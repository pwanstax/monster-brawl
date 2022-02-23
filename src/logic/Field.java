package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	// ------------------------------ METHOD ------------------------------ //

	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// draw gameplay background
		gc.drawImage(RenderableHolder.getBackground(), 0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

}
