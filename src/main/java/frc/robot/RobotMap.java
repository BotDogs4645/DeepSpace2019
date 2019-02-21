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
  public static WPI_TalonSRX topLeft = new WPI_TalonSRX(3); 
  public static WPI_TalonSRX middleLeft = new WPI_TalonSRX(4); 
  public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(10); 

  public static WPI_TalonSRX topRight = new WPI_TalonSRX(5); 
  public static WPI_TalonSRX middleRight = new WPI_TalonSRX(13);
  public static WPI_TalonSRX rearRight = new WPI_TalonSRX(1); 


  

  //PDP side is the front side

  //Pistons in PCM #1
	public static int backLeftPiston1 = 0;
	public static int backLeftPiston2 = 1;

	public static int backRightPiston1 = 2;
  public static int backRightPiston2 = 3;
  
  
  public static int frontRightPiston1= 4;//isn't real port, need to be decided
  public static int frontRightPiston2= 5;//isn't real port, need to be decided

  public static int frontLeftPiston1= 6;//isn't real port, need to be decided
  public static int frontLeftPiston2= 7; //isn't real port, need to be decided 
  

//Pistons in PCM #2

//intake pistons
public static int intakeLeftPiston5 = 4;
public static int intakeLeftPiston6 = 5;

public static int intakeRightPiston7 = 6;
public static int intakeRightPiston8 = 7;

public static int leftGearPiston1 = 5;
public static int leftGearPiston2 = 6;

public static int rightGearPiston1= 1;//not real TBD
public static int rightGearPiston2=2;//not real TBD

public static int intakeMotorPort = 5;

}
