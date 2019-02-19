/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;

public class TankDrive extends PIDSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /*
  public WPI_TalonSRX topLeft = new WPI_TalonSRX(3); 
  public WPI_TalonSRX middleLeft = new WPI_TalonSRX(4); 
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(10); 
  */
  public double dis;
  /*
  public WPI_TalonSRX topLeft = new WPI_TalonSRX(RobotMap.TANK_DRIVE_TOP_LEFT); //ports subject to change (16)
  public WPI_TalonSRX middleLeft = new WPI_TalonSRX(RobotMap.TANK_DRIVE_MIDDLE_LEFT); 
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.TANK_DRIVE_REAR_LEFT);
  */
  SpeedControllerGroup leftSide = new SpeedControllerGroup(RobotMap.TANK_DRIVE_TOP_LEFT, RobotMap.TANK_DRIVE_MIDDLE_LEFT, RobotMap.TANK_DRIVE_REAR_LEFT);



  SpeedControllerGroup rightSide = new SpeedControllerGroup(RobotMap.TANK_DRIVE_TOP_RIGHT, RobotMap.TANK_DRIVE_MIDDLE_RIGHT, RobotMap.TANK_DRIVE_REAR_RIGHT);

  DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);


  public TankDrive() {
    super("TankDrive", 1, 2, 3);
    setPercentTolerance(5);
    getPIDController().setContinuous(false);
    setPercentTolerance(5);
    enable();
  }
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


  public void init() { // middleLeft and middleRight motor must go in opposite directions from the rest of the motors.
    RobotMap.TANK_DRIVE_MIDDLE_LEFT.follow(RobotMap.TANK_DRIVE_TOP_LEFT);
    RobotMap.TANK_DRIVE_REAR_LEFT.follow(RobotMap.TANK_DRIVE_TOP_LEFT);

    RobotMap.TANK_DRIVE_MIDDLE_LEFT.setInverted(true);
    RobotMap.TANK_DRIVE_REAR_LEFT.setInverted(true);

    RobotMap.TANK_DRIVE_MIDDLE_RIGHT.follow(RobotMap.TANK_DRIVE_TOP_RIGHT);
    RobotMap.TANK_DRIVE_REAR_RIGHT.follow(RobotMap.TANK_DRIVE_TOP_RIGHT);
    

    RobotMap.TANK_DRIVE_MIDDLE_RIGHT.setInverted(true);
    RobotMap.TANK_DRIVE_REAR_RIGHT.setInverted(true);
  }

  public void setDistance(double pDistance)
  {

    dis = pDistance;
    double rotations = dis / (6 * Math.PI);
    double units = 360 * rotations; //encoder units
    setSetpoint(units);
  }

  public void driveWithJoystick() {
    double leftSpeed = OI.joyLeft.getY() * 0.8;
    double rightSpeed = OI.joyRight.getY() * 0.8;

    if(Math.abs(leftSpeed) < 0.2) 
      leftSpeed = 0;

    if(Math.abs(rightSpeed) < 0.2)
      rightSpeed = 0;

    /*if(Math.abs(leftSpeed) > 0.8)
      leftSpeed = 0.8;
    if(Math.abs(rightSpeed) > 0.8)
      rightSpeed = 0.8;*/

    SmartDashboard.putNumber("Front Left Motor:", RobotMap.TANK_DRIVE_TOP_LEFT.get());
    SmartDashboard.putNumber("Middle Left Motor:", RobotMap.TANK_DRIVE_MIDDLE_LEFT.get());
    SmartDashboard.putNumber("Rear Left Motor:", RobotMap.TANK_DRIVE_REAR_LEFT.get());


    SmartDashboard.putNumber("Front Right Motor:", RobotMap.TANK_DRIVE_TOP_RIGHT.get());
    SmartDashboard.putNumber("Middle Right Motor:", RobotMap.TANK_DRIVE_MIDDLE_RIGHT.get());
    SmartDashboard.putNumber("Rear Right Motor:", RobotMap.TANK_DRIVE_REAR_RIGHT.get());

    difDrive.tankDrive(leftSpeed, rightSpeed);
  }


  public void driveForward() { // to be utilized when button 3 is pressed on Left Joystick (joyLeft)
    double leftSpeed = 0.2;
    double rightSpeed = 0.2;
    difDrive.tankDrive(leftSpeed, rightSpeed);

    SmartDashboard.putNumber("Front Left Motor:", RobotMap.TANK_DRIVE_TOP_LEFT.get());
    SmartDashboard.putNumber("Middle Left Motor:", RobotMap.TANK_DRIVE_MIDDLE_LEFT.get());
    SmartDashboard.putNumber("Rear Left Motor:", RobotMap.TANK_DRIVE_REAR_LEFT.get());


    SmartDashboard.putNumber("Front Right Motor:", RobotMap.TANK_DRIVE_TOP_RIGHT.get());
    SmartDashboard.putNumber("Middle Right Motor:", RobotMap.TANK_DRIVE_MIDDLE_RIGHT.get());
    SmartDashboard.putNumber("Rear Right Motor:", RobotMap.TANK_DRIVE_REAR_RIGHT.get());

  }

  public void driveToAngle(double angle) { // to be utilized when button 3 is pressed on Left Joystick (joyLeft)
    double leftSpeed, rightSpeed;
    //the speedcontroller changes depending on what angle
    if(angle < 0.0) { //denotes it turning right. left side tank drive speed will be faster.
      leftSpeed = 0.5;
      rightSpeed = 0.5;
    }
    else { //denotes it turning left. right side tank drive will be faster
      rightSpeed = 0.5;
      leftSpeed = 0.5;
    }
    difDrive.tankDrive(leftSpeed, rightSpeed);

    SmartDashboard.putNumber("Front Left Motor:", RobotMap.TANK_DRIVE_TOP_LEFT.get());
    SmartDashboard.putNumber("Middle Left Motor:", RobotMap.TANK_DRIVE_MIDDLE_LEFT.get());
    SmartDashboard.putNumber("Rear Left Motor:", RobotMap.TANK_DRIVE_REAR_LEFT.get());


    SmartDashboard.putNumber("Front Right Motor:", RobotMap.TANK_DRIVE_TOP_RIGHT.get());
    SmartDashboard.putNumber("Middle Right Motor:", RobotMap.TANK_DRIVE_MIDDLE_RIGHT.get());
    SmartDashboard.putNumber("Rear Right Motor:", RobotMap.TANK_DRIVE_REAR_RIGHT.get());

  }

  public void stop() {
    RobotMap.TANK_DRIVE_TOP_LEFT.stopMotor();
    RobotMap.TANK_DRIVE_MIDDLE_LEFT.stopMotor();
    RobotMap.TANK_DRIVE_REAR_LEFT.stopMotor();

    RobotMap.TANK_DRIVE_TOP_RIGHT.stopMotor();
    RobotMap.TANK_DRIVE_MIDDLE_RIGHT.stopMotor();
    RobotMap.TANK_DRIVE_REAR_RIGHT.stopMotor();
  }
  public void turnInPlace(boolean left){
    double leftSpeed, rightSpeed;
    if(left){
      leftSpeed = -.2;
      rightSpeed = .2;
    }else{
      leftSpeed = .2;
      rightSpeed = -.2;
    }
    difDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  protected double returnPIDInput() {
    SmartDashboard.putNumber("PID input", RobotMap.TANK_DRIVE_TOP_LEFT.getSelectedSensorPosition(0));
    return RobotMap.TANK_DRIVE_TOP_LEFT.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    RobotMap.TANK_DRIVE_TOP_LEFT.pidWrite(output);
    SmartDashboard.putNumber("PID", output);
  }
  
  
}