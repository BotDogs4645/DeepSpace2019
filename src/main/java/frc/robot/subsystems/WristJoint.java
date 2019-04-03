/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.WristWithTrigger;

/**
 * Add your docs here.
 */

public class WristJoint extends PIDSubsystem {
  
  public boolean wristMovingWithTrigger = false;

  public WristJoint() {
    // Intert a subsystem name and PID values here
    super("WristJoint", .001, 0, 0);
    setPercentTolerance(10); //Error should be within 5 percent
    getPIDController().setContinuous(false); 
    setOutputRange(-0.2, 0.2); //test if this is necessary

    RobotMap.wristJointMotorRight.setSelectedSensorPosition(0, 0, 0);
    setSetpoint(RobotMap.wristJointMotorRight.getSelectedSensorPosition());
    enable();

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  public void moveWristWithTrigger() {
    int target_value = RobotMap.wristJointMotorRight.getSelectedSensorPosition();
    if (OI.gamepad.getPOV() == 90) { //If you press right on the d-pad, make the wrist move right
      //RobotMap.wristJointMotorRight.set(0.1);
      wristMovingWithTrigger = true;
      setSetpoint(0);
      //RobotMap.wristJointMotorRight.set(0.4);
      //RobotMap.wristJointMotorLeft.set(-0.4);
    }
    else if (OI.gamepad.getPOV() == 270) { //If you press left on the d-pad, make the wrist move left
      //RobotMap.wristJointMotorRight.set(-0.1);
      wristMovingWithTrigger = true;
      setSetpoint(1000);
      //RobotMap.wristJointMotorRight.set(-0.4);
      //RobotMap.wristJointMotorLeft.set(0.4);
    }
    else if (OI.gamepad.getPOV() == -1) { //Stop the wrist when you release the d-pad
      //RobotMap.wristJointMotorRight.set(0);
      wristMovingWithTrigger = false;
      //RobotMap.wristJointMotorRight.set(0);
      //RobotMap.wristJointMotorLeft.set(0);
    }                 
    SmartDashboard.putNumber("wrist encode value", target_value);
    SmartDashboard.putNumber("wrist target value", getSetpoint());

    SmartDashboard.putNumber("pov", OI.gamepad.getPOV() );
  }

  public void moveWristUp()
  {
    RobotMap.wristJointMotorRight.set(0.3);
    RobotMap.wristJointMotorLeft.set(-0.3);
  }

  public void moveWristDown()
  {
    RobotMap.wristJointMotorRight.set(-0.3);
    RobotMap.wristJointMotorLeft.set(0.3);
  }

  public void stopWristMovement()
  {
    RobotMap.wristJointMotorRight.set(0);
    RobotMap.wristJointMotorLeft.set(0);
  }

  public void setTargetPosition(double target) { //rotate by a certain angle
    
    SmartDashboard.putNumber("current right wrist joint encoder value", RobotMap.wristJointMotorRight.getSelectedSensorPosition());
    setSetpoint(target); //setpoint is the arclength encoder moves
  }

  public void encoderTargetVal(double val) { //rotate by a certain angle
    //double arcLength = (angle / 360) * (16 * Math.PI);
    setSetpoint(val); //setpoint is the arclength encoder moves
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new WristWithTrigger());
  }

  

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    SmartDashboard.putNumber("PID input(wrist encoder)", RobotMap.wristJointMotorRight.getSelectedSensorPosition(0));
    return RobotMap.wristJointMotorRight.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    RobotMap.wristJointMotorRight.pidWrite(output);
    SmartDashboard.putNumber("PID output(wrist joint power)", output);
  }
}
