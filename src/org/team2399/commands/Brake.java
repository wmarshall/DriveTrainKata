package org.team2399.commands;

import java.util.function.Supplier;

import org.team2399.command.Command;
import org.team2399.subsystems.DriveTrainSide;

public class Brake extends Command {

	private final DriveTrainSide side;

	public static Supplier<Command> generator(DriveTrainSide side) {
		return () -> new Brake(side);
	}

	public Brake(DriveTrainSide side) {
		this("NAME", -1, side);
	}

	public Brake(String name, DriveTrainSide side) {
		this(name, -1, side);
	}

	public Brake(double timeout, DriveTrainSide side) {
		this("NAME", timeout, side);
	}

	public Brake(String name, double timeout, DriveTrainSide side) {
		super(name, timeout);
		this.side = side;
		this.setInterruptible(true);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.team2399.command.Command#execute()
	 */
	@Override
	protected void execute() {
		super.execute();
		side.drivePercent(0);
	}

}
