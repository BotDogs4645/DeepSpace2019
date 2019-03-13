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
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.ArmWithTrigger;
import frc.robot.commands.WristWithTrigger;

/**
 * Add your docs here.
 */
/*
public class ElbowJoint extends PIDSubsystem {

  //Encoder armEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  public boolean armMovingWithTrigger = false;
  public double angle;
  

  public ElbowJoint() {
    // Intert a subsystem name and PID values here
    super("ElbowJoint", 0.04, 0.5, .04); //100000 //0.02, 0, .01
    setPercentTolerance(20); //Error must be within 5 percent
    getPIDController().setContinuous(false); 
    setOutputRange(-0.3, 0.3); //test if this is necessary
    //RobotMap.armJointMotorRight.follow(RobotMap.armJointMotorLeft); //slave which motor does not have encoder
    RobotMap.armJointMotorLeft.setSelectedSensorPosition(0, 0, 0);
    RobotMap.armJointMotorLeft.setSensorPhase(true);
    setSetpoint(0);

    //    setSetpoint(RobotMap.armJointMotorLeft.getSelectedSensorPosition());
    enable();
    //RobotMap.armJointMotorLeft.setSelectedSensorPosition(0, 0, 0);
    
    
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    //enable() - Enables the PID controller.

  }

  public void moveArmWithTrigger(){
    int target_value = RobotMap.armJointMotorLeft.getSelectedSensorPosition();
    if (OI.gamepad.getPOV() == 0){ //could also be .getRawAxis
      //RobotMap.armJointMotorLeft.set(0.3); //test whether (+0.3) makes it go up or down
      armMovingWithTrigger = true;
      setSetpoint(getSetpoint() + 1);

    }

    else if(OI.gamepad.getPOV() == 180){
      //RobotMap.armJointMotorLeft.set(-0.1); //test whether (-0.3) makes it go up or down
      armMovingWithTrigger = true;
      setSetpoint(getSetpoint() - 1);

    }

    else if(OI.gamepad.getPOV() == -1){
      //RobotMap.armJointMotorLeft.set(0);
      armMovingWithTrigger = false;

    }
    SmartDashboard.putNumber("POV", OI.gamepad.getPOV());
    SmartDashboard.putNumber("arm current value", target_value);
    SmartDashboard.putNumber("arm setpoint value", getSetpoint());

  }
  
  public void setTargetPosition(double pHeight) { //Uses a formula that figures out the arclength based on the desired height for the tip of the arm to be at
    double y = 42.875 - pHeight; 
    double r = 47.75;
    angle = Math.acos(y/r) - Math.acos(42.875/r);
    double arcLength = (angle / (2 * Math.PI)) * (95.5 * Math.PI);
    //SmartDashboard.putNumber("Arc Length", arcLength);
    setSetpoint(arcLength); //Setpoint becomes the arclength that the tip of the arm moves
  }
  

  public void setTargetPosition(double angle) { //rotate by a certain angle
    double arcLength = (angle / 360) * (16 * Math.PI);
    setSetpoint(arcLength); //setpoint is the arclength encoder moves
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArmWithTrigger());
  }
/*
  public void moveArmUp()
  {
    RobotMap.armJointMotorLeft.set(0.3);
    RobotMap.armJointMotorRight.set(-0.3);
  }

  public void moveArmDown()
  {
    RobotMap.armJointMotorLeft.set(-0.3);
    RobotMap.armJointMotorRight.set(0.3);
  }

  public void stopArmMovement()
  {
    RobotMap.armJointMotorLeft.set(0);
    RobotMap.armJointMotorRight.set(0);
  }


  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    SmartDashboard.putNumber("PID input(elbow encoder)", RobotMap.armJointMotorLeft.getSelectedSensorPosition(0));
    return RobotMap.armJointMotorLeft.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    RobotMap.armJointMotorLeft.pidWrite(output);
    SmartDashboard.putNumber("PID output(elbow joint power)", output);
  }



}
*/