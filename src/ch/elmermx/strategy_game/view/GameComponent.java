package ch.elmermx.strategy_game.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import ch.elmermx.model.Game;
import ch.elmermx.model.GameDimension;
import ch.elmermx.model.GameObject;

public abstract class GameComponent extends JComponent implements Observer {
	private static final long serialVersionUID = -6647985697533528505L;
	protected final GameObject gameObject;
	protected double scale = 1.0;

	public GameComponent(GameObject gameObject, Game game) {
		this.gameObject = gameObject;
		//this.setBounds(0, 0, (int) game.getMapSize().getWidth(), (int) game.getMapSize().getHeight());
		this.setBounds((int) gameObject.getX(), (int) gameObject.getY(), (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
		gameObject.addObserver(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// System.out.println(gameObject.getX() + " ::: " + gameObject.getY());
		super.paintComponent(g);
		this.setBounds((int) gameObject.getY(), (int) gameObject.getX(), (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public abstract GameDimension getComponentSize();

	@Override
	public Dimension getPreferredSize() {
		return new Dimension((int) (getComponentSize().getWidth() * scale), (int) (getComponentSize().getHeight() * scale));
	}

	@Override
	public void update(Observable o, Object arg) {
		invalidate();
		repaint();
	}

	// protected void paintMovement(Graphics2D g2d) {
	// g2d.translate((int) gameObject.getY(), (int) gameObject.getX());
	// }
}
