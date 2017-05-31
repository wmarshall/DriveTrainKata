package org.team2399;

import org.team2399.buttons.Button;
import org.team2399.buttons.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private final Joystick DTLeftStick = new Joystick(0);
	private final Joystick DTRightStick = new Joystick(1);

	private final Button DTLeftTrigger = new JoystickButton(DTLeftStick, 0);

	private final Button DTRightTrigger = new JoystickButton(DTLeftStick, 0);

	public OI() {
		// TODO Auto-generated constructor stub
	}

	public double getDTLeftInput() {
		return -DTLeftStick.getY();
	}

	public double getDTRightInput() {
		return -DTRightStick.getY();
	}

}
