package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.EncoderCommand;
import frc.robot.Robot;

public class EncoderTest extends Subsystem {
    public WPI_TalonSRX talon = new WPI_TalonSRX(15);

    public EncoderTest() {
        talon.setSensorPhase(true);
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
        talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    }

    public double getPosition() {
        return (double)talon.getSelectedSensorPosition();    
    }

    public void goStraight(double distance) { //where 15.24 is the circumference of the wheels and distance is in in
        double rotations = distance / (6 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (in) (rotations = distance/circumference)
        double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
        Robot.tankDriveSubsystem.driveForward(); //Drives with 0.5 speed
        if (getPosition() >= units) //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
            Robot.tankDriveSubsystem.stop(); //stops all motors
    }

    public void turn(double distance, double angle) { 
        double rotations = distance / (6 * Math.PI); 
        double units = 400 * rotations;
        Robot.tankDriveSubsystem.driveToAngle(angle); // depending on the angle, the speeds of the left/right sides of the tank drive will differ
        if (getPosition() >= units) 
            Robot.tankDriveSubsystem.stop(); 
    }

    public void distanceToAngle(double angle) { //using encoder
        double circumferenceOfRobot = 22.74; //units are in centimeter
        double distance = (double)(circumferenceOfRobot * (angle/360)); //gets the distance needed to turn
        turn(distance, angle); //to turn, one side of the tankDrive must go faster than the opposing side. 
        /* 90 degrees clockwise = 270 degrees cc*/
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new EncoderCommand());
    }

}