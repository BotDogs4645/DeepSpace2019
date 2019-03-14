package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ClimbingPneumatics extends Subsystem {
	//Creates solenoid object
    
        //back left piston
		Solenoid solenoid1 = new Solenoid(RobotMap.backLeftPiston1);
        //back right piston
        Solenoid solenoid2 = new Solenoid(RobotMap.backRightPiston1);
        //front left piston
        Solenoid solenoid3= new Solenoid(RobotMap.frontLeftPiston1);
        //front right piston
        Solenoid solenoid4= new Solenoid(RobotMap.frontRightPiston1);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void outFront() {
    	solenoid3.set(true);
    	solenoid4.set(true);
    	SmartDashboard.putString("Pnuematics Front","Out");
    }

    public void inFront() 
    {
    	solenoid3.set(false);
    	solenoid4.set(false);
    	SmartDashboard.putString("Pnuematics Front","In");
    }
    
    public void outBack()
    {
        solenoid1.set(true);
    	solenoid2.set(true);
    	SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	solenoid1.set(false);
    	solenoid2.set(false);
    	SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	//solenoid3.set(DoubleSolenoid.Value.kOff);
    	//solenoid4.set(DoubleSolenoid.Value.kOff);
    }

} 