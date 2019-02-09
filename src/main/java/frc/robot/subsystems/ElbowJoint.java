/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class ElbowJoint extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public WPI_TalonSRX armJointMotorLeft = new WPI_TalonSRX(4);
  public WPI_TalonSRX armJointMotorRight = new WPI_TalonSRX(5);

  Encoder armEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);


  public ElbowJoint() {
    // Intert a subsystem name and PID values here
    super("ElbowJoint", 1, 2, 3);
    setPercentTolerance(5);
    getPIDController().setContinuous(false);
    
    
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return armJointMotorLeft.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    armJointMotorLeft.set(output);
  }

  public void setTargetPosition(double pHeight) {
    double y = 42.875 - pHeight;
    double r = 47.75;
    double x = Math.sqrt((Math.pow(r,2)) - (Math.pow(y, 2)));  
    double totalAngle = Math.asin(x/r);
    double restAngle = Math.acos(42.875 / r);
    double portion = (totalAngle - restAngle) / (2 * Math.PI);
    double arcLength = portion * (95.5 * Math.PI); //Calculate arc length in inches
    SmartDashboard.putNumber("Arc Length", arcLength);
    setSetpoint(arcLength);
    
  }

}
