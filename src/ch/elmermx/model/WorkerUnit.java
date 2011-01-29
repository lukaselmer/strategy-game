package ch.elmermx.model;

import java.awt.Dimension;

public class WorkerUnit extends Unit {
	public WorkerUnit(Dimension startPosition) {
		super(startPosition);
	}

	@Override
	public void tick() {

	}

	@Override
	public String getName() {
		return "Worker";
	}

}
