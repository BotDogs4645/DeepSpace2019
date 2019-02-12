/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class WristJoint extends PIDSubsystem {
  public WPI_TalonSRX wristJointMotorLeft = new WPI_TalonSRX(6);
  public WPI_TalonSRX wristJointMototRight = new WPI_TalonSRX(7);
  public boolean wristMovingWithTrigger = false;

  public WristJoint() {
    // Intert a subsystem name and PID values here
    super("WristJoint", 1, 2, 3);
    setPercentTolerance(5);
    getPIDController().setContinuous(false);
    wristJointMotorLeft.follow(wristJointMototRight);
    enable();
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  public void moveWristWithTrigger() {
    if (OI.gamepad.getPOV() == 90) {
      wristJointMotorLeft.set(0.3);
      wristMovingWithTrigger = true;
    }
    else if (OI.gamepad.getPOV() == 270) {
      wristJointMotorLeft.set(0.3);
      wristMovingWithTrigger = true;
    }
    else if (OI.gamepad.getPOV() == -1) {
      wristJointMotorLeft.set(0);
      wristMovingWithTrigger = false;
      setSetpoint(wristJointMotorLeft.getSelectedSensorPosition());
    }
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
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
