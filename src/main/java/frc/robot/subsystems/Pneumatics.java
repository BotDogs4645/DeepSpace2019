/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class Pneumatics extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Creates solenoid object
  
    DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.RIGHT_PISTON_1, RobotMap.RIGHT_PISTON_2);
    DoubleSolenoid solenoid2 = new DoubleSolenoid(RobotMap.LEFT_PISTON_1, RobotMap.LEFT_PISTON_2);

    /*
    DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.LEFT_PISTON_1, RobotMap.LEFT_PISTON_2);
    DoubleSolenoid solenoid2 = new DoubleSolenoid(RobotMap.RIGHT_PISTON_1, RobotMap.RIGHT_PISTON_2);
    */
  public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
  }
  
  public void out() {
      solenoid1.set(DoubleSolenoid.Value.kForward);
      solenoid2.set(DoubleSolenoid.Value.kForward);
      SmartDashboard.putString("Pnuematics","Out");
  }
  
  public void in() 
  {
      solenoid1.set(DoubleSolenoid.Value.kReverse);
      solenoid2.set(DoubleSolenoid.Value.kReverse);
      SmartDashboard.putString("Pnuematics","In");
  }
  
  public void rest() {
      solenoid1.set(DoubleSolenoid.Value.kOff);
      solenoid2.set(DoubleSolenoid.Value.kOff);
  }

}
