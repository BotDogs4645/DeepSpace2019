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

/**
 * Add your docs here.
 */
public class ArmJoint extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public WPI_TalonSRX armJointMotor = new WPI_TalonSRX(4);

  Encoder armEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);


  public ArmJoint() {
    // Intert a subsystem name and PID values here
    super("armJoint", 1, 2, 3);
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

  public void setTargetPosition(double target)
  {
    setSetpoint(target);

  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return armJointMotor.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    armJointMotor.set(output);
  }
}
