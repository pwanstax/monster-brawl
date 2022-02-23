package entity.base;

import entity.PlayerOne;
import entity.PlayerTwo;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageAnimationManager;
import sharedObject.SimulationManager;

public class Santa extends Monster {

	// ------------------------------ FIELD ------------------------------ //
	
	public int santaHeal;
	private int count = 0;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize the default santa and set its sender.
	public Santa(String sender) {
		super(sender, "Santa", 0, 0.65, 6);
	}

	// initialize the santa with the specific stats.
	public Santa(String sender, String name, int attack, double speed, int cost) {
		super(sender, name, attack, speed, cost);
	}

	// ------------------------------ METHOD ------------------------------ //
	@Override
	public void draw(GraphicsContext gc) {
		if (this.getSender() == "1") {
			// set coordinateY
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerOne.currentPos1);
				this.lane = PlayerOne.currentPos1;
				addMonsterToLaneList(lane, "1", this);
				toSetY = false;
			}
			// draw run
			if ((posX < 35) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getSANrunImageList()
								.get(currentTime % ImageAnimationManager.getSANrunImageList().size()),
						posX + 100, posY - 20, 110, 100);
			}
			// jump+add money
			if ((posX >= 35) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getSANjumpImageList()
								.get(currentTime % ImageAnimationManager.getSANjumpImageList().size()),
						posX + 100, posY - 20, 110, 100);
				// if reach last jump frame, count++ , if reach 8 -> add 2 coins.
				if (currentTime % ImageAnimationManager.getSANjumpImageList()
						.size() == (ImageAnimationManager.getSANjumpImageList().size() - 1)) {
					count++;
					if (count == 8) {
						if (SimulationManager.getCoins1() < 49) {
							SimulationManager.setCoins1Increase(2);
						}
						this.count = 0;
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				maleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getSANdeadImageList()
								.get(currentTime % ImageAnimationManager.getSANdeadImageList().size()),
						posX + 100, posY - 20, 110, 100);
				if (currentTime % ImageAnimationManager.getSANdeadImageList()
						.size() == (ImageAnimationManager.getSANdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
		if (this.getSender() == "2") {
			// set coordinateY
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerTwo.currentPos2);
				this.lane = PlayerTwo.currentPos2;
				addMonsterToLaneList(lane, "2", this);
				toSetY = false;
			}
			// draw run
			if ((posX >= -35) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getSANrunImageList()
								.get(currentTime % ImageAnimationManager.getSANrunImageList().size()),
						posX + 600 + 110, posY - 20, -110, 100);
			}
			// draw jump
			if ((posX < -35) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getSANjumpImageList()
								.get(currentTime % ImageAnimationManager.getSANjumpImageList().size()),
						posX + 600 + 110, posY - 20, -110, 100);
				// if reach last jump frame, count++ , if reach 8 -> add 2 coins.
				if (currentTime % ImageAnimationManager.getSANjumpImageList()
						.size() == (ImageAnimationManager.getSANjumpImageList().size() - 1)) {
					count++;
					if (count == 8) {
						if (SimulationManager.getCoins2() < 49) {
							SimulationManager.setCoins2Increase(2);
						}
						this.count = 0;
					}
				}
			}
			if (isDeath && isExist) {
//				maleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getSANdeadImageList()
								.get(currentTime % ImageAnimationManager.getSANdeadImageList().size()),
						posX + 600 + 110, posY - 20, -110, 100);
				if (currentTime % ImageAnimationManager.getSANdeadImageList()
						.size() == (ImageAnimationManager.getSANdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
	}

	// Update the position of santa. (posX)
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (isExist) {
			if ((this.getSender() == "1") && (posX < 35)) {
				posX += speed;
			}
			if ((this.getSender() == "2") && (posX >= -35)) {
				posX -= speed;
			}
		}
	}
}
