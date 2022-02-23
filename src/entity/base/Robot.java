package entity.base;

import entity.PlayerOne;
import entity.PlayerTwo;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageAnimationManager;
import sharedObject.SimulationManager;

public class Robot extends Monster {

	// ------------------------------ FIELD ------------------------------ //

	private double posXforROB = posX;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize the default robot and set its sender.
	public Robot(String sender) {
		super(sender, "Robot", 4, 0.7, 9);
	}

	// initialize the robot with the specific stats.
	public Robot(String sender, String name, int attack, double speed, int cost) {
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
			// draw run+attack
			if ((posX < 200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getROBrunShootImageList()
								.get(currentTime % ImageAnimationManager.getROBrunShootImageList().size()),
						posX + 100, posY - 20, 100, 100);
				// draw muzzle
				if (posXforROB < 150) {
					gc.drawImage(
							ImageAnimationManager.getROBmuzzleImageList()
									.get(currentTime % ImageAnimationManager.getROBmuzzleImageList().size()),
							posX + 160, posY + 10, 50, 50);
				}
				// draw bullet
				if (posXforROB < 200) {
					gc.drawImage(
							ImageAnimationManager.getROBbulletImageList()
									.get(currentTime % ImageAnimationManager.getROBbulletImageList().size()),
							posXforROB + 170, posY + 10, 50, 50);
				}

			}
			// draw attack
			if ((posX >= 200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getROBmaleeImageList()
								.get(currentTime % ImageAnimationManager.getROBmaleeImageList().size()),
						posX + 100, posY - 20, 100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getROBmaleeImageList()
						.size() == (ImageAnimationManager.getROBmaleeImageList().size() - 1)) {
					attackCount1++;
					if (attackCount1 == 10) {
						SimulationManager.getBarrelList().get(lane).damageTakenFrom1(attack);
						attackCount1 = 0;
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				maleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getROBdeadImageList()
								.get(currentTime % ImageAnimationManager.getROBdeadImageList().size()),
						posX + 100, posY - 20, 100, 100);
				if (currentTime % ImageAnimationManager.getROBdeadImageList()
						.size() == (ImageAnimationManager.getROBdeadImageList().size() - 1)) {
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
			// draw run+attack
			if ((posX >= -200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getROBrunShootImageList()
								.get(currentTime % ImageAnimationManager.getROBrunShootImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				// draw muzzle
				if (posXforROB >= -150) {
					gc.drawImage(
							ImageAnimationManager.getROBmuzzleImageList()
									.get(currentTime % ImageAnimationManager.getROBmuzzleImageList().size()),
							posX + 590 + 50, posY + 10, -50, 50);
				}
				// draw bullet
				if (posXforROB >= -200) {
					gc.drawImage(
							ImageAnimationManager.getROBbulletImageList()
									.get(currentTime % ImageAnimationManager.getROBbulletImageList().size()),
							posXforROB + 670 - 50, posY + 10, -50, 50);
				}
			}
			// draw attack
			if ((posX < -200) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getROBmaleeImageList()
								.get(currentTime % ImageAnimationManager.getROBmaleeImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				setAttacking(true);
				// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
				// barrel.
				if (currentTime % ImageAnimationManager.getROBmaleeImageList()
						.size() == (ImageAnimationManager.getROBmaleeImageList().size() - 1)) {
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
						ImageAnimationManager.getROBdeadImageList()
								.get(currentTime % ImageAnimationManager.getROBdeadImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				if (currentTime % ImageAnimationManager.getROBdeadImageList()
						.size() == (ImageAnimationManager.getROBdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
	}

	// Update the position of robot. (posX)
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (isExist) {
			if ((this.getSender() == "1") && (posX < 200)) {
				posX += speed;
				posXforROB += 3 * speed;
				if ((posXforROB >= 196) && (posXforROB <= 199)) {
					SimulationManager.getBarrelList().get(lane).damageTakenFrom1(20);
				}
			}
			if ((this.getSender() == "2") && (posX >= -200)) {
				posX -= speed;
				posXforROB -= 3 * speed;
				if ((posXforROB <= -196) && (posXforROB >= -199)) {
					SimulationManager.getBarrelList().get(lane).damageTakenFrom2(20);
				}
			}
		}
	}

}
