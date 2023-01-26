/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DoublePunchCommand extends CommandBase {

  // True direction indicates "punching," false indicates retracting
  // of the solenoid
  boolean direction = true;

  public DoublePunchCommand(boolean direction) {
    this.direction = direction;
  }

  // Making sure the solenoid is not already moving before
  // executing the punch/retract
  @Override
  public void initialize() {

    Robot.punchSubsystem.doubleIdle();
  }

  // Takes in the boolean from the constructor to punch or retract
  @Override
  public void execute() {
    if(direction){
      Robot.punchSubsystem.doublePunch();
    }else{
      Robot.punchSubsystem.doubleRetract();
    }
  }

  // Returns true immediately so execute only runs once
  @Override
  public boolean isFinished() {
    return true;
  }

  // Ensures that the solenoid does not continue to move
  @Override
  public void end(boolean interrupted) {
    Robot.punchSubsystem.doubleIdle();
  }

  // Ends the command in case of interruption
  /*@Override
  public void interrupted() {
    end();
  }*/
}