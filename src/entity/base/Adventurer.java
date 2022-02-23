package entity.base;

import entity.PlayerOne;
import entity.PlayerTwo;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.ImageAnimationManager;
import sharedObject.SimulationManager;

public class Adventurer extends Monster {

	// ------------------------------ FIELD ------------------------------ //

	private int shotCount = 0;
	private int killCount = 0;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	// initialize the default adventurer and set its sender.
	public Adventurer(String sender) {
		super(sender, "Adventurer", 2, 0.5, 20);
	}

	// initialize the adventurer with the specific stats.
	public Adventurer(String sender, String name, int attack, double speed, int cost) {
		super(sender, name, attack, speed, cost);
	}

	// ------------------------------ METHOD ------------------------------ //
	@Override
	public void draw(GraphicsContext gc) {
		if (this.getSender() == "1") {
			// setup coordinate Y
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerOne.currentPos1);
				this.lane = PlayerOne.currentPos1;
				addMonsterToLaneList(lane, "1", this);
				toSetY = false;
			}
			// draw run
			if ((posX < 100) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getADVrunImageList()
								.get(currentTime % ImageAnimationManager.getADVrunImageList().size()),
						posX + 100, posY - 20, 100, 100);
			}

			if ((posX >= 100) && (!isDeath)) {
				if (killCount < 3) {
					// draw killing
					if (!SimulationManager.getP2AllMonster().get(lane).isEmpty()) {
						gc.drawImage(
								ImageAnimationManager.getADVshootImageList()
										.get(currentTime % ImageAnimationManager.getADVshootImageList().size()),
								posX + 100, posY - 20, 100, 100);
						setAttacking(true);
						// if reach last shoot frame, shootCount++ , if reach 50 -> kill.
						if (currentTime % ImageAnimationManager.getADVshootImageList()
								.size() == (ImageAnimationManager.getADVshootImageList().size() - 1)) {
							shotCount++;
							if (shotCount >= 50) {
								shotCount = 0;
								((Monster) SimulationManager.getP2AllMonster().get(lane).get(0)).setDeath(true);
								SimulationManager.getP2AllMonster().get(lane).remove(0);
								killCount++;
							}
						}
					}
					// draw idle
					if (SimulationManager.getP2AllMonster().get(lane).isEmpty()) {
						gc.drawImage(
								ImageAnimationManager.getADVidleImageList()
										.get(currentTime % ImageAnimationManager.getADVidleImageList().size()),
								posX + 100, posY - 20, 100, 100);
					}
				}
				// draw run
				if (killCount >= 3) {
					if ((posX < 200) && (!isDeath)) {
						gc.drawImage(
								ImageAnimationManager.getADVrunImageList()
										.get(currentTime % ImageAnimationManager.getADVrunImageList().size()),
								posX + 100, posY - 20, 100, 100);
					}
				}
				// draw attack
				if ((posX >= 200) && (!isDeath)) {
					gc.drawImage(
							ImageAnimationManager.getADVmaleeImageList()
									.get(currentTime % ImageAnimationManager.getADVmaleeImageList().size()),
							posX + 100, posY - 20, 100, 100);
					setAttacking(true);
					// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
					// barrel.
					if (currentTime % ImageAnimationManager.getADVmaleeImageList()
							.size() == (ImageAnimationManager.getADVmaleeImageList().size() - 1)) {
						attackCount1++;
						if (attackCount1 == 10) {
							SimulationManager.getBarrelList().get(lane).damageTakenFrom1(attack);
							attackCount1 = 0;
						}
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				femaleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getADVdeadImageList()
								.get(currentTime % ImageAnimationManager.getADVdeadImageList().size()),
						posX + 100, posY - 20, 100, 100);
				if (currentTime % ImageAnimationManager.getADVdeadImageList()
						.size() == (ImageAnimationManager.getADVdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
		if (this.getSender() == "2") {
			// set up coordinate Y
			if (toSetY) {
				posY = SimulationManager.getY().get(PlayerTwo.currentPos2);
				this.lane = PlayerTwo.currentPos2;
				addMonsterToLaneList(lane, "2", this);
				toSetY = false;
			}
			// draw running
			if ((posX >= -100) && (!isDeath)) {
				gc.drawImage(
						ImageAnimationManager.getADVrunImageList()
								.get(currentTime % ImageAnimationManager.getADVrunImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
			}
			if ((posX < -100) && (!isDeath)) {
				if (killCount < 3) {
					// draw killing
					if (!SimulationManager.getP1AllMonster().get(lane).isEmpty()) {
						gc.drawImage(
								ImageAnimationManager.getADVshootImageList()
										.get(currentTime % ImageAnimationManager.getADVshootImageList().size()),
								posX + 600 + 100, posY - 20, -100, 100);
						// if reach last shoot frame, shootCount++ , if reach 50 -> kill.
						if (currentTime % ImageAnimationManager.getADVshootImageList()
								.size() == (ImageAnimationManager.getADVshootImageList().size() - 1)) {
							shotCount++;
							if (shotCount >= 50) {
								shotCount = 0;
								((Monster) SimulationManager.getP1AllMonster().get(lane).get(0)).setDeath(true);
								SimulationManager.getP1AllMonster().get(lane).remove(0);
								killCount++;
							}
						}
					}
					// draw idle
					if (SimulationManager.getP1AllMonster().get(lane).isEmpty()) {
						gc.drawImage(
								ImageAnimationManager.getADVidleImageList()
										.get(currentTime % ImageAnimationManager.getADVidleImageList().size()),
								posX + 600 + 100, posY - 20, -100, 100);
					}
				}
				// draw run
				if (killCount >= 3) {
					if ((posX >= -200) && (!isDeath)) {
						gc.drawImage(
								ImageAnimationManager.getADVrunImageList()
										.get(currentTime % ImageAnimationManager.getADVrunImageList().size()),
								posX + 600 + 100, posY - 20, -100, 100);
					}
				}
				// draw attack
				if ((posX < -200) && (!isDeath)) {
					gc.drawImage(
							ImageAnimationManager.getADVmaleeImageList()
									.get(currentTime % ImageAnimationManager.getADVmaleeImageList().size()),
							posX + 600 + 100, posY - 20, -100, 100);
					setAttacking(true);
					// if reach last attack frame, attackCount++ , if reach 10 -> deal damage to
					// barrel.
					if (currentTime % ImageAnimationManager.getADVmaleeImageList()
							.size() == (ImageAnimationManager.getADVmaleeImageList().size() - 1)) {
						attackCount2++;
						if (attackCount2 == 10) {
							SimulationManager.getBarrelList().get(lane).damageTakenFrom2(attack);
							attackCount2 = 0;
						}
					}
				}
			}
			// draw dead
			if (isDeath && isExist) {
//				femaleDeathSound.play();
				gc.drawImage(
						ImageAnimationManager.getADVdeadImageList()
								.get(currentTime % ImageAnimationManager.getADVdeadImageList().size()),
						posX + 600 + 100, posY - 20, -100, 100);
				if (currentTime % ImageAnimationManager.getADVdeadImageList()
						.size() == (ImageAnimationManager.getADVdeadImageList().size() - 1)) {
					setExist(false);
				}
			}
		}
	}

	// Update the position of adventurer. (posX)
	@Override
	public void update() {
		if ((isExist) && (killCount < 3)) {
			if ((this.getSender() == "1") && (posX < 100)) {
				posX += speed;
			}
			if ((this.getSender() == "2") && (posX >= -100)) {
				posX -= speed;
			}
		}
		if ((isExist) && (killCount >= 3)) {
			if ((this.getSender() == "1") && (posX < 200)) {
				posX += speed;
			}
			if ((this.getSender() == "2") && (posX >= -200)) {
				posX -= speed;
			}
		}
	}
}