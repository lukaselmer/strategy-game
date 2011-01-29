package ch.elmermx.strategy_game.view;

import ch.elmermx.model.Game;
import ch.elmermx.model.GameObject;
import ch.elmermx.model.WorkerUnit;

public class GameComponentFactory {

	public static GameComponent createGameComponent(GameObject go, Game game) {
		if (go instanceof WorkerUnit)
			return new WorkerComponent(go, game);
		throw new RuntimeException();
	}

}
