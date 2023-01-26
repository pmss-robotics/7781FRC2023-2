/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class SinglePunchCommand extends CommandBase {

  public SinglePunchCommand() {
  
  }

  // Ensures that the solenoid isn't already moving
  // before the command starts
  @Override
  public void initialize() {
    Robot.punchSubsystem.singleIdle();
    }

  // Punches the solenoid and 
  // keeps the soleoid in the "punch" configuration until 
  // the command goes into the end method
  @Override
  public void execute() {
    Robot.punchSubsystem.singlePunch();
  }

  // Will only return true if the command is cancelled
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // Ensures the solenoid is no longer being "punched" before
  // exiting the program
  @Override
  public void end(boolean isInterrupted) {
    Robot.punchSubsystem.singleIdle();
  }
}