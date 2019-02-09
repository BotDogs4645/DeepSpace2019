/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;


/**
 * Add your docs here.
 */
public class Gyro extends Subsystem {
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public Gyro() {
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