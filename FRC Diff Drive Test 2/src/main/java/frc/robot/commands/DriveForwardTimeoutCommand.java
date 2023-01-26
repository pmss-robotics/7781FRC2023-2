/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.concurrent.TimeUnit;
import frc.robot.Robot;

public class DriveForwardTimeoutCommand extends CommandBase {

  public DriveForwardTimeoutCommand() {
    
  }

  // Ensuring motors aren't moving and setting a timeout to 3sec
  @Override
  public void initialize() {
    Robot.driveSubsystem.stop();
    		setTimeout(3L);
  }

    private void setTimeout(long l) {
    }

    // Drives forward at 100% speed with no rotation speed
  @Override
  public void execute() {
    Robot.driveSubsystem.drive(1, 0);
  }

  // Will go to end once the timer runs out 
  /*@Override
  public boolean isFinished() {
    return isTimedOut();
  }*/

  // Stops the motors
  @Override
  public void end(boolean isInterrupted) {
    Robot.driveSubsystem.stop();
  }
}