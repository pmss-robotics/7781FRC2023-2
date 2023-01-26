/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class IntakeSonicCommand extends CommandBase {

  public IntakeSonicCommand() { 
  }

  // Ensures the motors are stopped to avoid conflict
  @Override
  public void initialize() {
      Robot.intakeSubsystem.stop();
  }

  // Runs the intake in the forward (intake) direction
  // At 0.7 speed
  // Remember values vary for every robot
  @Override
  public void execute() {
      Robot.intakeSubsystem.intake(true, 0.7);
  }

  // Returns true and goes to end when the reading on the Ultrasonic
  // reads less than 4cm, the given value
  // Remember values vary for every robot
  @Override
  public boolean isFinished() {
    return Robot.intakeSubsystem.hasSomething(4);
  }

  // Called once after isFinished returns true
  // Stops the motor before exiting the program
  @Override
  public void end(boolean isInterrupted) {
      Robot.intakeSubsystem.stop();
  }
}