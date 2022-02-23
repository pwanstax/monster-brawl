package entity.base;

import entity.PlayerOne;
import entity.PlayerTwo;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageAnimationManager;
import sharedObject.SimulationManager;

public class Ninja extends Monster {

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize the default ninja and set its sender.
	public Ninja(String sender) {
		super(sender, "Ninja", 3, 1.5, 5);
	}

	// initialize the ninja with the specific stats.
	public Ninja(String sender, String name, int attack, double speed, int cost) {
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
						ImageAnimationManager.getNINrunImageList()
								.get(currentTime % ImageAnimationManager.getNINrunImageList().size()),
						posX + 100, posY - 10, 80, 80);
			}
			// draw attack
			if ((posX >= 200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getNINattackImageList()
								.get(currentTime % ImageAnimationManager.getNINattackImageList().size()),
						posX + 100, posY - 20, 100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getNINattackImageList()
						.size() == (ImageAnimationManager.getNINattackImageList().size() - 1)) {
					attackCount1++;
					if (attackCount1 == 10) {
						SimulationManager.getBarrelList().get(lane).damageTakenFrom1(attack);
						attackCount1 = 0;
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				femaleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getNINdeadImageList()
								.get(currentTime % ImageAnimationManager.getNINdeadImageList().size()),
						posX + 100, posY - 20, 100, 100);
				if (currentTime % ImageAnimationManager.getNINdeadImageList()
						.size() == (ImageAnimationManager.getNINdeadImageList().size() - 1)) {
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
						ImageAnimationManager.getNINrunImageList()
								.get(currentTime % ImageAnimationManager.getNINrunImageList().size()),
						posX + 600 + 80, posY - 10, -80, 80);
			}
			// draw attack
			if ((posX < -200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getNINattackImageList()
								.get(currentTime % ImageAnimationManager.getNINattackImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getNINattackImageList()
						.size() == (ImageAnimationManager.getNINattackImageList().size() - 1)) {
					attackCount2++;
					if (attackCount2 == 10) {
						SimulationManager.getBarrelList().get(lane).damageTakenFrom2(attack);
						attackCount2 = 0;
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				femaleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getNINdeadImageList()
								.get(currentTime % ImageAnimationManager.getNINdeadImageList().size()),
						posX + 600 + 90, posY - 20, -100, 100);
				if (currentTime % ImageAnimationManager.getNINdeadImageList()
						.size() == (ImageAnimationManager.getNINdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
	}

	// Update the position of ninja. (posX)
	@Override
	public void update() {
		// TODO Auto-generated method stub
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
