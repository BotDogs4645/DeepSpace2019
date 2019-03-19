package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class IntakePneumatics extends Subsystem {
    //Creates solenoid object

	Solenoid solenoid5 = new Solenoid(RobotMap.intakeLeftPiston);
    Solenoid solenoid6 = new Solenoid(RobotMap.intakeRightPiston);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public IntakePneumatics() {
        in();
    }
    
    public void out() {  
    	solenoid5.set(true);
        solenoid6.set(true);
        SmartDashboard.putString("Pnuematics","Out");
    }
    
    public void in() {
    	solenoid5.set(false);
    	solenoid6.set(false);
        SmartDashboard.putString("Pnuematics","In");
    }
    
    public void rest() {  
    	solenoid5.set(false);
        solenoid6.set(false);
    }

}
