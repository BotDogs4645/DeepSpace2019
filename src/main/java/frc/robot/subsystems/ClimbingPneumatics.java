package frc.robot.subsystems;



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
		Solenoid solenoidBL = new Solenoid(1);
        //back right piston
        Solenoid solenoidBR = new Solenoid(0);
        //front left piston
        Solenoid solenoidFR= new Solenoid(2);
        //front right piston
        Solenoid solenoidFL= new Solenoid(3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void outFront() 
    {
    	solenoidFR.set(true);
    	solenoidFL.set(true);
    	SmartDashboard.putString("Pnuematics Front","Out");
    }

    public void inFront() 
    {
    	solenoidFR.set(false);
    	solenoidFL.set(false);
    	SmartDashboard.putString("Pnuematics Front","In");
    }
    
public void outBack()
    {
        solenoidBL.set(true);
    	solenoidBR.set(true);
    	SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	solenoidBR.set(false);
    	solenoidBL.set(false);
    	SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	//solenoid3.set(DoubleSolenoid.Value.kOff);
    	//solenoid4.set(DoubleSolenoid.Value.kOff);
    }

}