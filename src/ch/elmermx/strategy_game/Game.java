package ch.elmermx.strategy_game;

import java.util.ArrayList;

public class Game implements Runnable {
	private volatile boolean runGame = true;
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	public void stopGame() {
		runGame = false;
	}

	@Override
	public void run() {
		while (runGame) {
			tick();
		}
	}

	private void tick() {
		for (GameObject go : gameObjects) {
			go.tick();
		}
	}

}
