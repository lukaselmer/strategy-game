package ch.elmermx.model;


public class WorkerUnit extends Unit {
	public WorkerUnit(GameDimension startPosition) {
		super(startPosition);
	}

	@Override
	public String getName() {
		return "Worker";
	}

	@Override
	public double getSpeed() {
		return 1;
	}

}
