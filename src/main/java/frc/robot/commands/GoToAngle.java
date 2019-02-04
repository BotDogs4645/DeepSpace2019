/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GoToAngle extends Command {
  public double finalAngle;
  public double finalAngle1;
  public GoToAngle(double pfinalAngle1, double pfinalAngle2) {
    requires(Robot.gyroSub);
    finalAngle = pfinalAngle1;
    finalAngle1 = pfinalAngle2;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.gyroSub.gyro.reset();
    Robot.gyroSub.motor.set(0.50);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Current angle ", Robot.gyroSub.gyro.getAngle());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    SmartDashboard.putBoolean("finished", (Robot.gyroSub.gyro.getAngle() >= finalAngle && Robot.gyroSub.gyro.getAngle() <= finalAngle1));
    return (Robot.gyroSub.gyro.getAngle() >= finalAngle && Robot.gyroSub.gyro.getAngle() <= finalAngle1);

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.gyroSub.motor.set(0.0);
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.gyroSub.motor.set(0.0);
  }
}
