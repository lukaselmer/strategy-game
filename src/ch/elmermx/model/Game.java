package ch.elmermx.model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {
	private volatile boolean runGame = true;
	private List<GameObject> gameObjects = new ArrayList<GameObject>();
	private final GameDimension mapSize;

	public Game(GameDimension mapSize) {
		this.mapSize = mapSize;
	}

	public void stopGame() {
		runGame = false;
	}

	public GameDimension getMapSize() {
		return mapSize;
	}

	public List<GameObject> getGameObjects() {
		return gameObjects;
	}

	@Override
	public void run() {
		while (runGame) {
			tick();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void tick() {
		for (GameObject go : gameObjects) {
			go.tick();
		}
	}

	public void addGameObject(GameObject go) {
		GameDimension goDim = go.getPosition();
		if (goDim.getHeight() > mapSize.getHeight() || goDim.getWidth() > mapSize.getWidth()) {
			goDim.setSize(goDim.getWidth() > mapSize.getWidth() ? mapSize.getWidth() : goDim.getWidth(), goDim.getHeight() > mapSize.getHeight() ? mapSize.getHeight() : goDim.getHeight());
		}
		gameObjects.add(go);
	}

	public void mouseClicked(MouseEvent e) {
		gameObjects.get(0).mouseClicked(e);
	}

}
