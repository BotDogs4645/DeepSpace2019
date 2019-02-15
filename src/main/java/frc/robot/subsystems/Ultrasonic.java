/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveByUltrasonic;


/**
 * Add your docs here.
 */
public class Ultrasonic extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  AnalogInput distanceSensor = RobotMap.ULTRASONIC;
  //AnalogInput distanceSensor = new AnalogInput(RobotMap.ULTRASONIC);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new MoveByUltrasonic());
  }

  public double getDistance()
	{
		double distance = distanceSensor.getVoltage();

		double distancemm = ((distance*1000)/4.88)*5;
		double distancecm = distancemm/10;
		return distancecm;
	}
	
  
}
