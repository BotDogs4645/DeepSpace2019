package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.GoToAngle;

public class Gyroscope extends Subsystem {

  int count = 0;
  public double finalAngle;
  public double finalAngle1;
  public double specifiedAngle;
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  
  //public WPI_TalonSRX motor = new WPI_TalonSRX(11);

  public Gyroscope() {
    gyro.calibrate();
  }
  
  public void reset() {
    gyro.reset();
  } 

  @Override
  public void initDefaultCommand() { 
    //setDefaultCommand(new GoToAngle(10,11,10));
  }
  public void stop() {
    Robot.gyroSub.stop();
    Robot.tankDriveSubsystem.stop();
  }
}