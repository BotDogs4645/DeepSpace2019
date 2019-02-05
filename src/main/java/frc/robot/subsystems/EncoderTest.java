package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.EncoderCommand;


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

    public void goStraight (double distance) { //where 15.24 is the circumference of the wheels and distance is in cm
        Robot.tankDriveSubsystem.driveWithConstant(); //Drives with 0.4 speed
        double rotations = distance / (15.24 * Math.PI); //gets the number of times the wheel needs to rotate to reach a specified distance (cm) (rotations = distance/circumference)
        double units = 400 * rotations; // gets the total number of raw sensor units correlated with specified distance
        if (getPosition() >= units) { //determines if the raw sensor units thus far equates to that of specified distance. if so, stop moving
            Robot.tankDriveSubsystem.stop(); //stops all motors
        } 
    }

    public void turnToAngle(int angleOfTurn) { /* new edits */
        double circumferenceOfRobot = 57.76; //units are in centimeter
        double distance = (double)(circumferenceOfRobot * (angleOfTurn/360)); //gets the distance needed to turn a specified angle
        goStraight(distance);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new EncoderCommand());
    }

}
