package entity.base;

import entity.Entity;
import javafx.animation.AnimationTimer;
import sharedObject.SimulationManager;

public abstract class Monster extends Entity {

	// ------------------------------ FIELD ------------------------------ //

	private long lastTimeTriggered = -1;
	protected String sender;
	protected String name;
	protected int attack;
	protected double speed;
	protected int cost;
	protected boolean isDeath;
	protected boolean isAttacking;
	protected boolean isExist;
	protected double posX;
	protected double posY;
	protected boolean toSetY = true;
	protected int currentTime = 0;
	protected int lane;
	protected int attackCount1 = 0;
	protected int attackCount2 = 0;
//	protected AudioClip maleDeathSound;
//	protected MediaPlayer femaleDeathSound;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public Monster(String sender) {
		setSender(sender);
	}

	public Monster(String sender, String name, int attack, double speed, int cost) {
		setSender(sender);
		setName(name);
		setAttack(attack);
		setSpeed(speed);
		setCost(cost);
		setDeath(false);
		setAttacking(false);
		setExist(true);
		this.z = 100;
		this.posX = 0;
//		maleDeathSound = new MediaPlayer(new Media(ClassLoader.getSystemResource("ascream4.wav").toString()));
//		femaleDeathSound = new MediaPlayer(new Media(ClassLoader.getSystemResource("roblox-death-sound-effect.mp3").toString()));
//		maleDeathSound.setVolume(0.1);
//		femaleDeathSound.setVolume(0.1);

		// each monster has its own timer.
		AnimationTimer timerForMonster = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);

				if (now - lastTimeTriggered >= 100000000) {
					currentTime++;
					lastTimeTriggered = now;
				}
			}
		};
		timerForMonster.start();
	}

	// ------------------------------ METHOD ------------------------------ //

	// add monster to lane's list in SimulationManager.
	public void addMonsterToLaneList(int lane, String sender, Monster monster) {
		if (sender == "1") {
			if (lane + 1 == 1) {
				SimulationManager.getP1Lane1().add(monster);
			}
			if (lane + 1 == 2) {
				SimulationManager.getP1Lane2().add(monster);
			}
			if (lane + 1 == 3) {
				SimulationManager.getP1Lane3().add(monster);
			}
			if (lane + 1 == 4) {
				SimulationManager.getP1Lane4().add(monster);
			}
			if (lane + 1 == 5) {
				SimulationManager.getP1Lane5().add(monster);
			}
		}
		if (sender == "2") {
			if (lane + 1 == 1) {
				SimulationManager.getP2Lane1().add(monster);
			}
			if (lane + 1 == 2) {
				SimulationManager.getP2Lane2().add(monster);
			}
			if (lane + 1 == 3) {
				SimulationManager.getP2Lane3().add(monster);
			}
			if (lane + 1 == 4) {
				SimulationManager.getP2Lane4().add(monster);
			}
			if (lane + 1 == 5) {
				SimulationManager.getP2Lane5().add(monster);
			}
		}
	}

	// ------------------------------ SETTER,GETTER ------------------------------ //

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeath() {
		return isDeath;
	}

	public void setDeath(boolean isDeath) {
		this.isDeath = isDeath;
	}

	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

}
