package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PneumaticsCommandOutBack extends Command
{
    public PneumaticsCommandOutBack()
    {
       // requires(Robot.pneumaticsOb);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {

        Robot.pneumaticsOb.outBack();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        Robot.pneumaticsOb.inBack();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        Robot.pneumaticsOb.inBack();
    }


}