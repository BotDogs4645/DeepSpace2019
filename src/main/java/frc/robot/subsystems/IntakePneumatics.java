package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class IntakePneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
	
		DoubleSolenoid solenoid5 = new DoubleSolenoid(RobotMap.leftPiston5, RobotMap.leftPiston5);
		DoubleSolenoid solenoid6 = new DoubleSolenoid(RobotMap.rightPiston7, RobotMap.rightPiston8);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void out() {
    	solenoid5.set(DoubleSolenoid.Value.kForward);
    	solenoid6.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics","Out");
    }
    
    public void in() 
    {
    	solenoid5.set(DoubleSolenoid.Value.kReverse);
    	solenoid6.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics","In");
    }
    
    public void rest() {
    	solenoid5.set(DoubleSolenoid.Value.kOff);
    	solenoid6.set(DoubleSolenoid.Value.kOff);
    }

}