/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //JOYSTICKS
  static int joyLeft = 0;
  static int joyRight = 1;
  static int gamepadPort = 2;

  //TANK DRIVE MOTORS
  public static WPI_TalonSRX topLeft = new WPI_TalonSRX(3); 
  public static WPI_TalonSRX middleLeft = new WPI_TalonSRX(4); 
  public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(10); 

  public static WPI_TalonSRX topRight = new WPI_TalonSRX(5); 
  public static WPI_TalonSRX middleRight = new WPI_TalonSRX(13);
  public static WPI_TalonSRX rearRight = new WPI_TalonSRX(1); 

  //WRIST JOINT MOTORS
  public static WPI_TalonSRX wristJointMotorLeft = new WPI_TalonSRX(6); //port # yet to be determined
  public static WPI_TalonSRX wristJointMotorRight = new WPI_TalonSRX(7); //port # yet to be determined

  //ELBOW JOINT MOTORS
  public static WPI_TalonSRX armJointMotorLeft = new WPI_TalonSRX(8); //port # yet to be determined
  public static WPI_TalonSRX armJointMotorRight = new WPI_TalonSRX(9); //port # yet to be determined

}
