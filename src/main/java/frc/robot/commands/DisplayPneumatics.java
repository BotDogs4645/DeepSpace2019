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
import frc.robot.subsystems.ClimbingPneumatics;

public class DisplayPneumatics extends Command {
  public DisplayPneumatics() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climbingPneumaticsOb);
  }
//\\alexa suckskjsd hg uigldfgi ulfd hgu relhwre
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      SmartDashboard.putBoolean("Pnuematics Front Left",Robot.climbingPneumaticsOb.getFL());
      SmartDashboard.putBoolean("Pnuematics Front Right",Robot.climbingPneumaticsOb.getFR());
      SmartDashboard.putBoolean("Pnuematics Back Left",Robot.climbingPneumaticsOb.getBL());
      SmartDashboard.putBoolean("Pnuematics Back Right",Robot.climbingPneumaticsOb.getBR());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
