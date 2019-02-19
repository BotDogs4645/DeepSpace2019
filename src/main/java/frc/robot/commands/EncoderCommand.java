package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderCommand extends Command { // yet to be tested
    public EncoderCommand() {
        requires(Robot.encoderSub);
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() { 
        RobotMap.TANK_DRIVE_TOP_LEFT.setSelectedSensorPosition(0); 
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        SmartDashboard.putNumber("Position", Robot.encoderSub.getPosition());
        Robot.encoderSub.goStraight(10); //Parameter is a placeholder = 10 inch to move
    }

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