package gui;

import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class MonsterChannel1 extends MonsterChannel {

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public MonsterChannel1(double width, double height) {
		//
		super(width, height);
		editImage();
		coinschannel.setText(Integer.toString(SimulationManager.getCoins1()));
		deckchannel.getChildren().addAll(card0, card1, card2);
		this.getChildren().addAll(deckchannel, coinschannel);
	}

	// ------------------------------ METHOD ------------------------------ //

	public void checkSelected() {
		// check what player1's monster is current selected and paint color to it
		switch (SimulationManager.getIsSelected1()) {
		case 0:
			highlight(card0);
			unhighlight(card1);
			unhighlight(card2);
			break;
		case 1:
			highlight(card1);
			unhighlight(card0);
			unhighlight(card2);
			break;
		case 2:
			highlight(card2);
			unhighlight(card0);
			unhighlight(card1);
			break;
		}
	}

	public void editImage() {
		// set current image of card0 , card1 ,card2 (Player1 only)
		card0.getChildren().setAll(RenderableHolder.getCurrentImage10());
		card1.getChildren().setAll(RenderableHolder.getCurrentImage11());
		card2.getChildren().setAll(RenderableHolder.getCurrentImage12());
	}

	@Override
	public void paintComponent() {
		// TODO Auto-generated method stub
		// displays player1's coins and monster images
		coinschannel.setText(Integer.toString(SimulationManager.getCoins1()));
		super.paintComponent();
	}

}
