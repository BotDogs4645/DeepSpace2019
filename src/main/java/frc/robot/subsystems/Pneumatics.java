/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
	
		DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.leftPiston1, RobotMap.rightPiston1);
        DoubleSolenoid solenoid2 = new DoubleSolenoid(RobotMap.leftPiston2, RobotMap.rightPiston2);
        DoubleSolenoid solenoid3= new DoubleSolenoid(RobotMap.leftPiston3, RobotMap.rightPiston3);
        DoubleSolenoid solenoid4= new DoubleSolenoid(RobotMap.rightPiston4, RobotMap.rightPiston4);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void outFront() {
    	solenoid1.set(DoubleSolenoid.Value.kForward);
    	solenoid2.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics Front","Out");
    }
    

    
    
    
    
    
    public void inFront() 
    {
    	solenoid1.set(DoubleSolenoid.Value.kReverse);
    	solenoid2.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Front","In");
    }
    
public void outBack()
    {
        solenoid3.set(DoubleSolenoid.Value.kForward);
    	solenoid4.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	solenoid3.set(DoubleSolenoid.Value.kReverse);
    	solenoid4.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	//solenoid3.set(DoubleSolenoid.Value.kOff);
    	//solenoid4.set(DoubleSolenoid.Value.kOff);
    }

}