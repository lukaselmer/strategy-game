package ch.elmermx.strategy_game.view;

import ch.elmermx.model.GameObject;
import ch.elmermx.model.WorkerUnit;

public class GameComponentFactory {

	public static GameComponent createGameComponent(GameObject go) {
		if (go instanceof WorkerUnit)
			return new WorkerComponent(go);
		throw new RuntimeException();
	}

}
