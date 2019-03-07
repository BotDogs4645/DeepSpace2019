/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class TankDrive extends PIDSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Command

  SpeedControllerGroup leftSide = new SpeedControllerGroup(RobotMap.rearLeft, RobotMap.rearLeft);

  SpeedControllerGroup rightSide = new SpeedControllerGroup(RobotMap.rearRight, RobotMap.rearRight);

  DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);

  public TankDrive() {
    super("TankDrive", 1, 2, 3);
    setPercentTolerance(5);
    getPIDController().setContinuous(false);  
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public void init() { // middleLeft and middleRight motor must go in opposite directions from the rest of the motors.
    RobotMap.rearLeft.follow(RobotMap.topLeft);
   
    RobotMap.rearRight.follow(RobotMap.topRight); 
  }

  public void driveWithJoystick() {
    double leftSpeed = OI.joyLeft.getY() * 0.8;
    double rightSpeed = OI.joyRight.getY() * -0.8; //check forwards/backwards

   /* if(Math.abs(leftSpeed) < 0.2) 
      leftSpeed = 0;

    if(Math.abs(rightSpeed) < 0.2)
      rightSpeed = 0;

    /*if(Math.abs(leftSpeed) > 0.8)
      leftSpeed = 0.8;
    if(Math.abs(rightSpeed) > 0.8)
      rightSpeed = 0.8;*/

    SmartDashboard.putNumber("Front Left Motor:", RobotMap.topLeft.get());
    //SmartDashboard.putNumber("Middle Left Motor:", RobotMap.middleLeft.get());
    SmartDashboard.putNumber("Rear Left Motor:", RobotMap.rearLeft.get());

    SmartDashboard.putNumber("Front Right Motor:", RobotMap.topRight.get());
    //SmartDashboard.putNumber("Middle Right Motor:", RobotMap.middleRight.get());
    SmartDashboard.putNumber("Rear Right Motor:", RobotMap.rearRight.get());

    difDrive.tankDrive(leftSpeed, rightSpeed);
  }

  //TO BE TESTED
  public void driveForward() { // to be utilized when button 3 is pressed on Left Joystick (joyLeft)
    double leftSpeed = 0.5;
    double rightSpeed = -0.5;
    difDrive.tankDrive(leftSpeed, rightSpeed);

    SmartDashboard.putNumber("Front Left Motor:", RobotMap.topLeft.get());
    //SmartDashboard.putNumber("Middle Left Motor:", RobotMap.middleLeft.get());
    SmartDashboard.putNumber("Rear Left Motor:", RobotMap.rearLeft.get());

    SmartDashboard.putNumber("Front Right Motor:", RobotMap.topRight.get());
    //SmartDashboard.putNumber("Middle Right Motor:", RobotMap.middleRight.get());
    SmartDashboard.putNumber("Rear Right Motor:", RobotMap.rearRight.get());
  }


  public void stop() {
    RobotMap.topLeft.stopMotor();
    //RobotMap.middleLeft.stopMotor();
    RobotMap.rearLeft.stopMotor();

    RobotMap.topRight.stopMotor();
   // RobotMap.middleRight.stopMotor();
    RobotMap.rearRight.stopMotor();
  }

  @Override
  protected double returnPIDInput() {
    return 0;
  }

  @Override
  protected void usePIDOutput(double output) {

  }
}

  
