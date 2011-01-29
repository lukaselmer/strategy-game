package ch.elmermx.model;

import java.awt.Dimension;
import java.util.Observable;

public abstract class GameObject extends Observable {
	private final Dimension position;

	public GameObject(Dimension startPosition) {
		this.position = startPosition;
	}

	public abstract void tick();

	public abstract String getName();

	public String getDescription() {
		return "-";
	}

	public Dimension getPosition() {
		return position;
	}
}
