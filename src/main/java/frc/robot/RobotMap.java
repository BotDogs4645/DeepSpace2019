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
  //pneumatics

  //TANK DRIVE MOTORS
  public static WPI_TalonSRX topLeft = new WPI_TalonSRX(14); 
  public static WPI_TalonSRX middleLeft = new WPI_TalonSRX(4); 
  public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(15); 

  public static WPI_TalonSRX topRight = new WPI_TalonSRX(3); 
  public static WPI_TalonSRX middleRight = new WPI_TalonSRX(13);
  public static WPI_TalonSRX rearRight = new WPI_TalonSRX(5); 


  //PDP side is the front side

  //Pistons in PCM #1
	public static int backRightPiston = 0;
	public static int backLeftPiston = 1;

	public static int frontRightPiston = 2;
  public static int frontLeftPiston = 3;
  
  
 

//Pistons in PCM #2

//intake pistons
public static int intakeLeftPiston5 = 4;
public static int intakeLeftPiston6 = 5;

public static int intakeRightPiston7 = 6;
public static int intakeRightPiston8 = 7;

public static int leftGearPiston1 = 0;
public static int rightGearPiston1= 2;//not real TBD

public static int intakeMotorPort = 9;

//WRIST JOINT MOTORS
public static WPI_TalonSRX wristJointMotorLeft = new WPI_TalonSRX(10); //port # yet to be determined
public static WPI_TalonSRX wristJointMotorRight = new WPI_TalonSRX(8); //port # yet to be determined

//ELBOW JOINT MOTORS
public static WPI_TalonSRX armJointMotorLeft = new WPI_TalonSRX(12); //port # yet to be determined
public static WPI_TalonSRX armJointMotorRight = new WPI_TalonSRX(11); //port # yet to be determined


}
