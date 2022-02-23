package gui;

import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class MonsterChannel2 extends MonsterChannel {

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public MonsterChannel2(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		editImage();
		coinschannel.setText(Integer.toString(SimulationManager.getCoins2()));
		deckchannel.getChildren().addAll(card2, card1, card0);
		this.getChildren().addAll(coinschannel, deckchannel);
	}

	// ------------------------------ METHOD ------------------------------ //

	public void checkSelected() {
		// check what player2's monster is current selected and paint color to it
		switch (SimulationManager.getIsSelected2()) {
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
		// set current image of card0 , card1 ,card2 (Player2 only)
		card0.getChildren().setAll(RenderableHolder.getCurrentImage20());
		card1.getChildren().setAll(RenderableHolder.getCurrentImage21());
		card2.getChildren().setAll(RenderableHolder.getCurrentImage22());
	}

	@Override
	public void paintComponent() {
		// TODO Auto-generated method stub
		// displays player2's coins and monster images
		coinschannel.setText(Integer.toString(SimulationManager.getCoins2()));
		super.paintComponent();
	}

}
