package ch.elmermx.strategy_game;

import ch.elmermx.model.Game;
import ch.elmermx.model.GameDimension;
import ch.elmermx.model.WorkerUnit;
import ch.elmermx.strategy_game.view.GameFrame;

public class Main {
	public static void main(String[] args) {
		Game g = new Game(new GameDimension(1200, 900));
		g.addGameObject(new WorkerUnit(new GameDimension(100, 200)));
		// g.addGameObject(new WorkerUnit(new Dimension(150, 200)));
		// g.addGameObject(new WorkerUnit(new Dimension(100, 250)));
		// g.addGameObject(new WorkerUnit(new Dimension(150, 250)));
		new GameFrame(g);
		Thread gameThread = new Thread(g);
		gameThread.start();
	}
}
