package ch.elmermx.model;

import java.awt.Dimension;

public class GameDimension {

	private double x;
	private double y;

	public GameDimension(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public GameDimension(GameDimension gameDimension) {
		x = gameDimension.x;
		y = gameDimension.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return x;
	}

	public double getHeight() {
		return y;
	}

	public Dimension toDimension() {
		return new Dimension((int) x, (int) y);
	}

	public void setSize(GameDimension gameDimension) {
		x = gameDimension.x;
		y = gameDimension.y;
	}

	public void setSize(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof GameDimension) {
			GameDimension oo = (GameDimension) o;
			return x == oo.x && y == oo.y;
		}
		return super.equals(o);
	}

	public void add(double moveX, double moveY) {
		x += moveX;
		y += moveY;
	}

	@Override
	public String toString() {
		return String.format("x: %10.2f, y: %10.2f", x, y);
	}

}
