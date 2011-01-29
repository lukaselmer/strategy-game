package ch.elmermx.strategy_game.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import ch.elmermx.model.Game;
import ch.elmermx.model.GameDimension;
import ch.elmermx.model.GameObject;

public class WorkerComponent extends GameComponent {
	private static final long serialVersionUID = 9099438094072437656L;

	public WorkerComponent(GameObject gameObject, Game game) {
		super(gameObject, game);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//paintMovement(g2d);
		g2d.drawRect(0, 0, 10, 10);
		g2d.scale(scale, scale);
		g2d.translate(10.0, 0.0);
		//g2d.translate(-8.0, -45.0);
		g2d.fillOval(-6, 0, 11, 11);
		g2d.fillOval(-10, 10, 20, 30);
		g2d.translate(-2.0, 28.0);
		g2d.rotate(Math.toRadians(-20), 0, 0);
		g2d.fillOval(0, 0, 4, 26);
		g2d.translate(0.0, -1.0);
		g2d.rotate(Math.toRadians(40), 0, 0);
		g2d.fillOval(0, 0, 4, 26);
		g2d.rotate(Math.toRadians(-20), 0, 0);
	}

	@Override
	public GameDimension getComponentSize() {
		return new GameDimension(20, 70);
	}
}
