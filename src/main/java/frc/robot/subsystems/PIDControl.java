/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.commands.AutonDriveCommand;
import frc.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;

/**
 * Add your docs here.
 */
public class PIDControl extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public PIDController encoderPID = getPIDController();
  
  public WPI_TalonSRX talon = new WPI_TalonSRX(15);

  public PIDControl(double distance) {
    // Insert a subsystem name and PID values here
    super("EncoderTest", 0, 0, 0);
    talon.setSensorPhase(true);
    talon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
    talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    setSetpoint(distance);      // Sets where the PID controller should move the system
    setPercentTolerance(5);
    enable(); // Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new AutonDriveCommand());
  }

  public double getPosition() {
    return (double)talon.getSelectedSensorPosition();    
  }

  public void goStraight() { //where 6 is the diameter of the wheels and distance is in in
    double i = 0;
    double d = 0;
    double lastError = 0;
    double rotations = getSetpoint() / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
    double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
    Robot.tankDriveSubsystem.driveForward(); //Drives with 0.5 speed
    double p = units - getPosition(); //Represents p, how far we are from the setPosition
    i += p; // Represents the sum of all error values
    d = p - lastError;
    lastError = p;
    /*if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
        Robot.tankDriveSubsystem.stop(); //stops all motors */
        
  }

  public void turnToAngle(double distance, double angle) { //where 15.24 is the circumference of the wheels and distance is in in
    double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
    double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
    Robot.tankDriveSubsystem.driveToAngle(angle); //Drives with 0.5 speed
    if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
        Robot.tankDriveSubsystem.stop(); //stops all motors
  }

  public void turnToAngle(double angleOfTurn) { /* new edits */
    double circumferenceOfRobot = 57.76; //units are in centimeter
    double distance = (double)(circumferenceOfRobot * (angleOfTurn/360)); //gets the distance needed to turn a specified angle
    turnToAngle(distance, angleOfTurn);;
  }

  public void reset() {
    encoderPID.reset();
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
