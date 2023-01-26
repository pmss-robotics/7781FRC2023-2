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
public class DriveToDistanceCommand extends CommandBase {

  DriveCommand driveCommand = new DriveCommand();

  double distance = 0.0;
  double speed = 0.0;

  // Distance and speed values in constructor 
  // Distance depends on your distance factor in your subsystem
  // Speed is the -1 to 1 value given to your motors

  public DriveToDistanceCommand(double distance, double speed) {

    this.distance = distance;
    this.speed = speed;
      
  }

  // Resets the encoders to read 0 and stops motors to ensure no prior
  // movement
  @Override
  public void initialize() {
      Robot.driveSubsystem.stop();
      Robot.driveSubsystem.encReset();
      driveCommand.cancel();
  }

  // Drives forward (no rotation) until isFinshed returns true
  @Override
  public void execute() {
    Robot.driveSubsystem.drive(speed, 0);
  }

  // Returns true when the error between the desired distance and 
  // the encoder distance is less than or equal to 0.1
  // 0.1 is a dummy value and may differ depending on the application 
  // of the command
  @Override
  public boolean isFinished() {
    return Math.abs(Robot.driveSubsystem.getAvgDistance() - distance) <= 0.1;
  }

  // Stops the motors once isFinished returns true before
  // exiting the program
  @Override
  public void end(boolean isInterrupted) {
      Robot.driveSubsystem.stop();
      driveCommand.start();
  }
}