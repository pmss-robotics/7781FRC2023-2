/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotContainer;


/**
 * Add your docs here.
 */
public class PunchSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Instantiation of single solenoid 
  // PCM channel is in RobotContainer
  Solenoid single = new Solenoid(RobotContainer.singleSolenoid);

  // Instantiation of double solenoid
  // PCM channels are in RobotContainer
  DoubleSolenoid doubleS = new DoubleSolenoid(RobotContainer.doubleSolenoid1, RobotContainer.doubleSolenoid2);

  // "Punches" single solenoid outwards
  public void singlePunch(){
    single.set(true);
  }

  // "Punches" double solenoid outwards
  public void doublePunch(){
    doubleS.set(DoubleSolenoid.Value.kForward);
  }

  // Retracts double solenoid
  public void doubleRetract(){
    doubleS.set(DoubleSolenoid.Value.kReverse);
  }

  // Ensures no movement of single solenoid
  public void singleIdle(){
    single.set(false);
  }

  // Ensures no movement of double solenoid
  public void doubleIdle(){
    doubleS.set(DoubleSolenoid.Value.kOff);
  }

  /*@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }*/
}