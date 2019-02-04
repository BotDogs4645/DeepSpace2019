package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;


/**
 * Add your docs here.
 */
public class Gryo extends Subsystem {
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public WPI_TalonSRX motor = new WPI_TalonSRX(11);
  public Gryo() {
    gyro.calibrate();
  }
  
  int count = 0;
  public void reset() {
    gyro.reset();
  } 

  @Override
  public void initDefaultCommand() { 
  }
}
