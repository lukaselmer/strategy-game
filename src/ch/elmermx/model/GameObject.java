package ch.elmermx.model;

import java.awt.event.MouseEvent;
import java.util.Observable;

public abstract class GameObject extends Observable {
	protected final GameDimension position, destination;

	public GameObject(GameDimension startPosition) {
		this.position = new GameDimension(startPosition);
		this.destination = new GameDimension(startPosition);
	}

	public void mouseClicked(MouseEvent e) {
		this.destination.setSize(new GameDimension(e.getX(), e.getY()));
	}
	
	public abstract void tick();

	public abstract String getName();

	public String getDescription() {
		return "-";
	}

	public GameDimension getPosition() {
		return position;
	}

	public double getX() {
		return getPosition().getHeight();
	}

	public double getY() {
		return getPosition().getWidth();
	}
}
