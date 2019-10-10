/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FixPosition extends Command {
  private boolean isLeft;
  private double angleToTurn;
  public FixPosition() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.kTankDrive);
    requires(Robot.kGyro);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    angleToTurn = -(Robot.kGyro.getAngle());
    if(angleToTurn < 0){
      isLeft = true;
    }else{
      isLeft = false;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.kTankDrive.turnInPlace(isLeft);//this method might not work
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.kGyro.getAngle() > -2 && Robot.kGyro.getAngle() < 2){// the greater than and less than 
      //checks are in case of error not nessessary if it messes with stoping in the correct place
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
