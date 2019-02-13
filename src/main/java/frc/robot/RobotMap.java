/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

  //PDP side is the front side

  //Pistons in PCM #1
	public static int backLeftPiston1 = 0;
	public static int backLeftPiston2 = 1;

	public static int backRightPiston1 = 2;
  public static int backRightPiston2 = 3;
  
  
  public static int frontRightPiston3= 4;//isn't real port, need to be decided
  public static int frontRightPiston4= 5;//isn't real port, need to be decided

  public static int frontLeftPiston3= 6;//isn't real port, need to be decided
  public static int frontLeftPiston4= 7; //isn't real port, need to be decided 
  

//Pistons in PCM #2
public static int leftPiston5 = 1;
public static int leftPiston6 = 2;

public static int rightPiston7 = 3;
public static int rightPiston8 = 4;

public static int gearPiston7 = 5;
public static int gearPiston8 = 6;

public static int intakeMotorPort = 1;

}
