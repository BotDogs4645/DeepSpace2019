package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DisplayPneumatics;

public class ClimbingPneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
    
        //back left piston
		Solenoid solenoidBL = new Solenoid(RobotMap.backLeftPiston);
        //back right piston
        Solenoid solenoidBR = new Solenoid(RobotMap.backRightPiston);
        //front left piston
        Solenoid solenoidFR= new Solenoid(RobotMap.frontRightPiston);
        //front right piston
        Solenoid solenoidFL= new Solenoid(RobotMap.frontLeftPiston);


     public ClimbingPneumatics()
     {
         startPosition();
     }   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DisplayPneumatics());
    }

    public void startPosition()
    {
        solenoidFR.set(false);
        solenoidFL.set(false);

        solenoidBL.set(false);
    	solenoidBR.set(false);
    }
    
    
    public void outFront() 
    {
    	solenoidFR.set(true);
    	solenoidFL.set(true);
        //SmartDashboard.putString("Pnuematics Front","Out");
        

    }

    public void inFront() 
    {
    	solenoidFR.set(false);
    	solenoidFL.set(false);
    	//SmartDashboard.putString("Pnuematics Front","In");
    }
    
public void outBack()
    {
        solenoidBL.set(true);
    	solenoidBR.set(true);
    	//SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	solenoidBR.set(false);
    	solenoidBL.set(false);
    	//SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	//solenoid3.set(DoubleSolenoid.Value.kOff);
    	//solenoid4.set(DoubleSolenoid.Value.kOff);
    }

    public boolean getBL() {
        return solenoidBL.get();
    }
    public boolean getBR() {
        return solenoidBR.get();
    }
    public boolean getFL() {
        return solenoidFL.get();
    }
    public boolean getFR() {
        return solenoidFR.get();
    }

}