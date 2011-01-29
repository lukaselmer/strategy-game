package ch.elmermx.model;

public abstract class Unit extends GameObject {

	public Unit(GameDimension startPosition) {
		super(startPosition);
	}

	@Override
	public void tick() {
		if (position.equals(destination)) {
			return;
		}
		moveTo(destination);
		setChanged();
		notifyObservers();
	}

	protected void moveTo(GameDimension destination) {
		double diffX = position.getX() - destination.getX();
		double diffY = position.getY() - destination.getY();
		double diffTotal = Math.abs(diffX) + Math.abs(diffY);
		if (diffTotal < getSpeed() * 2) {
			position.setSize(destination);
		} else {
			double moveX = -getSpeed() / diffTotal * diffX;
			double moveY = -getSpeed() / diffTotal * diffY;
			position.add(moveX, moveY);
		}
	}

	public abstract double getSpeed();

}
