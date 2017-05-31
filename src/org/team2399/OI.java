package org.team2399;

import org.team2399.buttons.Button;
import org.team2399.buttons.JoystickButton;
import org.team2399.command.Command;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public enum DriveMode {
		STANDARD, INVERTED, DEADBAND
	}

	private class RotateDriveModeCommand extends Command {

		@Override
		protected void execute() {
			OI.this.rotateDriveMode();
		}

		@Override
		protected boolean isFinished() {
			return true;
		}

	}

	private final Joystick driverLeftStick = new Joystick(0);
	private final Joystick driverRightStick = new Joystick(1);

	private final Button driverLeftTrigger = new JoystickButton(driverLeftStick, 0);
	private final Button driverLeftSqueeze = new JoystickButton(driverLeftStick, 2);

	private final Button driverRightTrigger = new JoystickButton(driverRightStick, 0);

	private DriveMode driveMode = DriveMode.STANDARD;

	public OI() {
		driverLeftSqueeze.whenPressed(new RotateDriveModeCommand());
	}

	public DriveMode getDriveMode() {
		return driveMode;
	}

	public void setDriveMode(DriveMode dm) {
		driveMode = dm;
	}

	public void rotateDriveMode() {
		driveMode = DriveMode.values()[(driveMode.ordinal() + 1) % 3];
	}

	private static double applyDriveMode(double input, DriveMode dm) {
		switch (dm) {
		case DEADBAND:
			return (Math.abs(input) > 0.1 ? input : 0);
		case INVERTED:
			return input;
		case STANDARD:
		default:
			return -input;
		}
	}

	public double getDTLeftInput() {
		return applyDriveMode(driverLeftStick.getY(), this.driveMode);
	}

	public double getDTRightInput() {
		return applyDriveMode(driverRightStick.getY(), this.driveMode);
	}

	public void whileDTLeftBrake(Command c) {
		driverLeftTrigger.whileHeld(c);
	}

	public void whileDTRightBrake(Command c) {
		driverRightTrigger.whileHeld(c);
	}
}
