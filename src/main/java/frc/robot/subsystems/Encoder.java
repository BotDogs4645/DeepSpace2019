/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Encoder extends Subsystem {
  public WPI_TalonSRX talon = RobotMap.TANK_DRIVE_REAR_RIGHT;

  public Encoder() {
      talon.setSensorPhase(true);
      talon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
      talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
  }


  public double getPosition() {
      return (double)talon.getSelectedSensorPosition();    
  }

  public void resetPosition() {
    talon.setSelectedSensorPosition(0);
  }


  public void goStraight(double distance) { //where 15.24 is the circumference of the wheels and distance is in in
      double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
      double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
      Robot.kTankDrive.driveForward(); //Drives with 0.5 speed
      if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
          Robot.kTankDrive.stop(); //stops all motors
  }
  public double getForwardUnits(double distance){
    double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
    double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
    return units;
  }
  

  public double turnToAngle(double distance, double angle) { //where 15.24 is the circumference of the wheels and distance is in in
      double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
      double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
      Robot.kTankDrive.driveToAngle(angle); //Drives with 0.5 speed
      return units;
      
  }

  public double turnToAngle(double angleOfTurn) { /* new edits */
      double circumferenceOfRobot = 57.76; //units are in centimeter
      double distance = (double)(circumferenceOfRobot * (angleOfTurn/360)); //gets the distance needed to turn a specified angle
      return turnToAngle(distance, angleOfTurn);
  }

  @Override
  protected void initDefaultCommand() {
      //setDefaultCommand(new EncoderCommand());
  }

}
