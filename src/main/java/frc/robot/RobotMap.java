/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;

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
  
  //ultrasonic
  public static AnalogInput ULTRASONIC = new AnalogInput(1);
  //tankdrive left
  public static WPI_TalonSRX TANK_DRIVE_TOP_LEFT = new WPI_TalonSRX(3);
  public static WPI_TalonSRX TANK_DRIVE_MIDDLE_LEFT = new WPI_TalonSRX(4);
  public static WPI_TalonSRX TANK_DRIVE_REAR_LEFT = new WPI_TalonSRX(10); 
  
  //tankdrive right
  public static WPI_TalonSRX TANK_DRIVE_TOP_RIGHT = new WPI_TalonSRX(5);
  public static WPI_TalonSRX TANK_DRIVE_MIDDLE_RIGHT = new WPI_TalonSRX(13);
  public static WPI_TalonSRX TANK_DRIVE_REAR_RIGHT = new WPI_TalonSRX(1);
  //pneumatics
  
  public static int LEFT_PISTON_1 = 1;
  public static int LEFT_PISTON_2 = 2;

  public static int RIGHT_PISTON_1 = 3;
  public static int RIGHT_PISTON_2 = 4;

  //missing climbing pneunantics
}
