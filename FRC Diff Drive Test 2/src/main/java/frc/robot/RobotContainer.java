/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  // Intake Speed Values
  public static final double intakeLow = 0.3;
  public static final double intakeMed = 0.7;
  public static final double intakeHigh = 1;

  // Drivetrain speed controllers

public static final int frontRight = 0;
public static final int frontLeft = 1;
public static final int backRight = 2;
  public static final int backLeft = 3;

  // Intake speed controllers

  public static final int intake1 = 4;
  public static final int intake2 = 5;

  // PCM Channels

  public static final int singleSolenoid = 0;
  public static final int doubleSolenoid1 = 1;
  public static final int doubleSolenoid2 = 2;

  // Digital Input Ports

   // Drivetrain Encoder Ports

  public static final int leftEnc1 = 0;
  public static final int leftEnc2 = 1;
  public static final int rightEnc1 = 2;
  public static final int rightEnc2 = 3;

  // Intake Ultrasonic Ports

  public static final int ping = 4;
  public static final int echo = 5;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
