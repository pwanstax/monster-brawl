package entity;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	
	protected int z;
	
	// set z to 100.
	public Entity() {
		z = 100;
	}
	
	public int getZ() {
		return z;
	}
	
	public abstract void update();

}
