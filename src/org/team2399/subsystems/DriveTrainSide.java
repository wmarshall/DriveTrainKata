package org.team2399.subsystems;

import org.team2399.command.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrainSide extends Subsystem {

	private final SpeedController leader;

	public DriveTrainSide(String name, SpeedController leader, boolean isInverted) {
		super(name);
		this.leader = leader;
		leader.setInverted(isInverted);
	}

	public DriveTrainSide() {
		this("DriveTrainSide", new CANTalon(0xbeef), false);
	}

	/**
	 * @return
	 * @see edu.wpi.first.wpilibj.SpeedController#get()
	 */
	public double getDrivePercent() {
		return leader.get();
	}

	/**
	 * @param speed
	 * @see edu.wpi.first.wpilibj.SpeedController#set(double)
	 */
	public void drivePercent(double speed) {
		leader.set(speed);
	}

	/**
	 * @param isInverted
	 * @see edu.wpi.first.wpilibj.SpeedController#setInverted(boolean)
	 */
	public void setInverted(boolean isInverted) {
		leader.setInverted(isInverted);
	}

	/**
	 * @return
	 * @see edu.wpi.first.wpilibj.SpeedController#getInverted()
	 */
	public boolean getInverted() {
		return leader.getInverted();
	}

	/**
	 * 
	 * @see edu.wpi.first.wpilibj.SpeedController#disable()
	 */
	public void disable() {
		leader.disable();
	}

	/**
	 * 
	 * @see edu.wpi.first.wpilibj.SpeedController#stopMotor()
	 */
	public void stopMotor() {
		leader.stopMotor();
	}

}
