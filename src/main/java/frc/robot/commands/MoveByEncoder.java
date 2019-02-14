/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveByEncoder extends Command {
  private double distance;
  private double originalPoition;

  public MoveByEncoder(double pDistance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    distance = pDistance;
    requires(Robot.kEncoder);
    requires(Robot.kTankDrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    originalPoition = Robot.kEncoder.getPosition();
    Robot.kTankDrive.setDistance(distance);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.kTankDrive.driveForward();
    
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.kEncoder.getPosition() > (originalPoition + distance - 2))//subtracting to acount for posible error(not nessesary)
      return true;
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
