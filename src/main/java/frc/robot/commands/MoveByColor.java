/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class MoveByColor extends Command {

  private boolean black;
  private double speed;

  public MoveByColor(boolean pBlack, double pSpeed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    black = pBlack;
    speed = pSpeed;
    requires(Robot.kMotor);
    requires(Robot.kColorSensor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.kMotor.move(speed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    final int[] colors = Robot.kColorSensor.getColor();
    if(black){
      if(colors[3] == 0){
        return true;
      }
    }else{
      if(colors[3] == 2 || colors[3] == 11 || colors[3] == 3 || colors[3] == 10){
        return true;
      }
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.kMotor.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.kMotor.stop();
  }
}
