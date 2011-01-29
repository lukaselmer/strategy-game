package ch.elmermx.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {
	private volatile boolean runGame = true;
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private final Dimension mapSize;

	public Game(Dimension mapSize) {
		this.mapSize = mapSize;
	}

	public void stopGame() {
		runGame = false;
	}

	public Dimension getMapSize() {
		return mapSize;
	}

	public List<GameObject> getGameObjects() {
		return gameObjects;
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

	public void addGameObject(GameObject go) {
		Dimension goDim = go.getPosition();
		if (goDim.getHeight() > mapSize.getHeight() || goDim.getWidth() > mapSize.getWidth()) {
			goDim.setSize(goDim.getWidth() > mapSize.getWidth() ? mapSize.getWidth() : goDim.getWidth(), goDim.getHeight() > mapSize.getHeight() ? mapSize.getHeight() : goDim.getHeight());
		}
		gameObjects.add(go);
	}

}
