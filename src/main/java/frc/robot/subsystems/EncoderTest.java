package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class EncoderTest extends Subsystem { // yet to be tested
    
    public EncoderTest() {
        RobotMap.TANK_DRIVE_TOP_LEFT.setSensorPhase(true); 
        RobotMap.TANK_DRIVE_TOP_LEFT.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
        RobotMap.TANK_DRIVE_TOP_LEFT.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    }

    public double getPosition() {
        return (double)RobotMap.TANK_DRIVE_TOP_LEFT.getSelectedSensorPosition(); // where the robot is 
    }

    public void goStraight(double distance) { //where 6 is the circumference of the wheels and distance is in inches
        double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (inch) (rotations = distance/circumference)
        double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
        Robot.tankDriveSubsystem.driveForward(); //Drives with 0.5 speed
        if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
            Robot.tankDriveSubsystem.stop(); //stops all motors
    }
    
    public void turnToAngle(double distance, double angle) {
        double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
        double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
        Robot.tankDriveSubsystem.driveToAngle(angle); //Drives with 0.5 speed
        if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
            Robot.tankDriveSubsystem.stop(); //stops all motors
    }

    public void turnToAngle(double angleOfTurn) { 
        double circumferenceOfRobot = Math.PI * 22.74; //units are in inches, where 22.74 is a measure of the distance between each wheel
        double distance = (double)(circumferenceOfRobot * (angleOfTurn/360)); //gets the distance needed to turn a specified angle
        turnToAngle(distance, angleOfTurn); // calls on auton tank drive for turning to angles
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new EncoderCommand());
    }

}
