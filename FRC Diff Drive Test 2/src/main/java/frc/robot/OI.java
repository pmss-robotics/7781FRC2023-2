/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.SinglePunchCommand;
import frc.robot.commands.DoublePunchCommand;
import frc.robot.commands.IntakeSonicCommand;
import frc.robot.Robot;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Instantiaion of xbox
	
	private final XboxController m_controller = new XboxController(0);

	// Instantiation of buttons with names based on their 
	// associated commands

	var xSpeed = -m_controller.getY(GenericHID.Hand.kLeft) * Drivetrain.kMaxSpeed;
    // for next time: copy and paste the rest of the speed command from Robot

	// Joystick accessors

	public Joystick getDriverStick() {
		return driverStick;
	}

	public Joystick getOperatorStick() {
		return operatorStick;
	}
	
	public OI(){

		// Associating commands with buttons

		intake.whileHeld(new IntakeCommand(true, 1));
		outtake.whileHeld(new IntakeCommand(false, 1));
		singlePunch.whileHeld(new SinglePunchCommand());
		doublePunch.whenPressed(new DoublePunchCommand(true));
		doublePunch.whenPressed(new DoublePunchCommand(false));
		intakeSonic.whenPressed(new IntakeSonicCommand());
	}

}