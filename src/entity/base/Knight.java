package entity.base;

import entity.PlayerOne;
import entity.PlayerTwo;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageAnimationManager;
import sharedObject.SimulationManager;

public class Knight extends Monster {

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize the default knight and set its sender.
	public Knight(String sender) {
		super(sender, "Knight", 5, 0.6, 6);
	}

	// initialize the knight with the specific stats.
	public Knight(String sender, String name, int attack, double speed, int cost) {
		super(sender, name, attack, speed, cost);
	}

	// ------------------------------ METHOD ------------------------------ //

	@Override
	public void draw(GraphicsContext gc) {
		if (this.getSender() == "1") {
			// set coordinate Y
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerOne.currentPos1);
				this.lane = PlayerOne.currentPos1;
				addMonsterToLaneList(lane, "1", this);
				toSetY = false;
			}
			// draw run
			if ((posX < 200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getKNIrunImageList()
								.get(currentTime % ImageAnimationManager.getKNIrunImageList().size()),
						posX + 100, posY - 20, 100, 100);
			}
			// draw attack
			if ((posX >= 200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getKNIattackImageList()
								.get(currentTime % ImageAnimationManager.getKNIattackImageList().size()),
						posX + 100, posY - 20, 100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getKNIattackImageList()
						.size() == (ImageAnimationManager.getKNIattackImageList().size() - 1)) {
					attackCount1++;
					if (attackCount1 == 10) {
						SimulationManager.getBarrelList().get(lane).damageTakenFrom1(attack);
						attackCount1 = 0;
					}
				}
			}
			// draw death
			if (isDeath && isExist) {
//				maleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getKNIdeadImageList()
								.get(currentTime % ImageAnimationManager.getKNIdeadImageList().size()),
						posX + 100, posY - 20, 100, 100);
				if (currentTime % ImageAnimationManager.getKNIdeadImageList()
						.size() == (ImageAnimationManager.getKNIdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
		if (this.getSender() == "2") {
			// set coordinate Y
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerTwo.currentPos2);
				this.lane = PlayerTwo.currentPos2;
				addMonsterToLaneList(lane, "2", this);
				toSetY = false;
			}
			// draw run
			if ((posX >= -200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getKNIrunImageList()
								.get(currentTime % ImageAnimationManager.getKNIrunImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
			}
			// draw attack
			if ((posX < -200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getKNIattackImageList()
								.get(currentTime % ImageAnimationManager.getKNIattackImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getKNIattackImageList()
						.size() == (ImageAnimationManager.getKNIattackImageList().size() - 1)) {
					attackCount2++;
					if (attackCount2 == 10) {
						SimulationManager.getBarrelList().get(lane).damageTakenFrom2(attack);
						attackCount2 = 0;
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				maleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getKNIdeadImageList()
								.get(currentTime % ImageAnimationManager.getKNIdeadImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				if (currentTime % ImageAnimationManager.getKNIdeadImageList()
						.size() == (ImageAnimationManager.getKNIdeadImageList().size() - 1)) {

					setExist(false);

				}
			}
		}
	}

	// Update the position of knight. (posX)
	@Override
	public void update() {
		if (isExist) {
			if ((this.getSender() == "1") && (posX < 200)) {
				posX += speed;
			}
			if ((this.getSender() == "2") && (posX >= -200)) {
				posX -= speed;
			}
		}
	}
}
