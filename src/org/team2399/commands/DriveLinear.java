package org.team2399.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import org.team2399.command.Command;
import org.team2399.subsystems.DriveTrainSide;

public class DriveLinear extends Command {

	private final DriveTrainSide side;

	private final DoubleSupplier source;

	public static Supplier<Command> generator(DriveTrainSide side, DoubleSupplier source) {
		return () -> new DriveLinear(side, source);
		// return DriveLinear::new(side, source);
	}

	private DriveLinear(DriveTrainSide side, DoubleSupplier source) {
		this("NAME", -1, side, source);
	}

	private DriveLinear(String name, DriveTrainSide side, DoubleSupplier source) {
		this(name, -1, side, source);
	}

	public DriveLinear(double timeout, DriveTrainSide side, DoubleSupplier source) {
		this("NAME", timeout, side, source);
	}

	public DriveLinear(String name, double timeout, DriveTrainSide side, DoubleSupplier source) {
		super(name, timeout);
		this.side = side;
		this.source = source;
		this.setInterruptible(true);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.team2399.command.Command#execute()
	 */
	@Override
	protected void execute() {
		super.execute();
		side.drivePercent(source.getAsDouble());
	}

}
