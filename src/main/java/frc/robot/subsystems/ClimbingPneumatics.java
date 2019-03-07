 /*package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ClimbingPneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
    
        //back left piston
		DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.backLeftPiston1, RobotMap.backLeftPiston2);
        //back right piston
        DoubleSolenoid solenoid2 = new DoubleSolenoid(RobotMap.backRightPiston1, RobotMap.backRightPiston2);
        //front left piston
        DoubleSolenoid solenoid3= new DoubleSolenoid(RobotMap.frontLeftPiston1, RobotMap.frontLeftPiston2);
        //front right piston
        DoubleSolenoid solenoid4= new DoubleSolenoid(RobotMap.frontRightPiston1, RobotMap.frontRightPiston2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void outFront() {
    	solenoid3.set(DoubleSolenoid.Value.kForward);
    	solenoid4.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics Front","Out");
    }

    public void inFront() 
    {
    	solenoid3.set(DoubleSolenoid.Value.kReverse);
    	solenoid4.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Front","In");
    }
    
public void outBack()
    {
        solenoid1.set(DoubleSolenoid.Value.kForward);
    	solenoid2.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	solenoid1.set(DoubleSolenoid.Value.kReverse);
    	solenoid2.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	//solenoid3.set(DoubleSolenoid.Value.kOff);
    	//solenoid4.set(DoubleSolenoid.Value.kOff);
    }

} */