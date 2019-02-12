/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.commands.DriveCommand;

public class TankDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  public WPI_TalonSRX topLeft = new WPI_TalonSRX(3); //ports subject to change (16)
  public WPI_TalonSRX middleLeft = new WPI_TalonSRX(4); //15
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(10); //14

  SpeedControllerGroup leftSide = new SpeedControllerGroup(topLeft, middleLeft, rearLeft);

  public WPI_TalonSRX topRight = new WPI_TalonSRX(5); //ports subject to change' (12)
  public WPI_TalonSRX middleRight = new WPI_TalonSRX(13); //13
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(1); //10

  SpeedControllerGroup rightSide = new SpeedControllerGroup(topRight, middleRight, rearRight);

  DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public void init() { // middleLeft and middleRight motor must go in opposite directions from the rest of the motors.
    middleLeft.follow(topLeft);
    rearLeft.follow(topLeft);

    middleLeft.setInverted(true); // inverted reverses the direction = goes in the opposite direction
    rearLeft.setInverted(true);

    middleRight.follow(topRight);
    rearRight.follow(topRight); 

    middleRight.setInverted(true);
    rearRight.setInverted(true);
  }

  public void driveWithJoystick() {
    double leftSpeed = OI.joyLeft.getY() * 0.8;
    double rightSpeed = OI.joyRight.getY() * -0.8; //test forwards/backwards

    /*if(Math.abs(leftSpeed) < 0.2) 
      leftSpeed = 0;
    if(Math.abs(rightSpeed) < 0.2)
      rightSpeed = 0;
    /*if(Math.abs(leftSpeed) > 0.8)
      leftSpeed = 0.8;
    if(Math.abs(rightSpeed) > 0.8)
      rightSpeed = 0.8;*/

    SmartDashboard.putNumber("Front Left Motor:", topLeft.get());
    SmartDashboard.putNumber("Middle Left Motor:", middleLeft.get());
    SmartDashboard.putNumber("Rear Left Motor:", rearLeft.get());

    SmartDashboard.putNumber("Front Right Motor:", topRight.get());
    SmartDashboard.putNumber("Middle Right Motor:", middleRight.get());
    SmartDashboard.putNumber("Rear Right Motor:", rearRight.get());

    difDrive.tankDrive(leftSpeed, rightSpeed);
  }

  //TO BE TESTED
  public void driveForward() { // to be utilized when button 3 is pressed on Left Joystick (joyLeft)
    double leftSpeed = 0.5;
    double rightSpeed = 0.5;
    difDrive.tankDrive(leftSpeed, rightSpeed);

    SmartDashboard.putNumber("Front Left Motor:", topLeft.get());
    SmartDashboard.putNumber("Middle Left Motor:", middleLeft.get());
    SmartDashboard.putNumber("Rear Left Motor:", rearLeft.get());

    SmartDashboard.putNumber("Front Right Motor:", topRight.get());
    SmartDashboard.putNumber("Middle Right Motor:", middleRight.get());
    SmartDashboard.putNumber("Rear Right Motor:", rearRight.get());
  }


  public void stop() {
    topLeft.stopMotor();
    middleLeft.stopMotor();
    rearLeft.stopMotor();

    topRight.stopMotor();
    middleRight.stopMotor();
    rearRight.stopMotor();
  }
}
  