/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class MoveByTimer extends Command {
  private double time;
  private static Timer autoTimer = new Timer();

  public MoveByTimer(double ptime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    time = ptime;
    requires(Robot.kTankDrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.kTankDrive.driveForward();
    autoTimer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.kTankDrive.driveForward();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (autoTimer.get() >= time)
    {
      return true;
    }

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.kTankDrive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.kTankDrive.stop();
  }
}
