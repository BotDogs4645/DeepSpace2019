/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TankDriveGears extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
/*
  Solenoid solenoid7 = new Solenoid(0, RobotMap.gearPiston7);
  Solenoid solenoid8 = new Solenoid(0, RobotMap.gearPiston8);
  */


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

public void out() {
  /*
  solenoid7.set(true);
  solenoid8.set(true);
  */

  SmartDashboard.putString("Pnuematics","Out");
  
}

public void in() 
{
  /* LEAVE COMMENTED
  solenoid5.set(DoubleSolenoid.Value.kReverse);
  solenoid6.set(DoubleSolenoid.Value.kReverse);
  SmartDashboard.putString("Pnuematics","In");
  */
  
}


public void rest() {
  /*
  solenoid7.set(false);
  solenoid8.set(false);
  */
  
}

}
 

