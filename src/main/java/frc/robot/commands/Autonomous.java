/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Robot;


public class Autonomous extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Autonomous() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    DriverStation driver = DriverStation.getInstance();
    


    //addSequential(new MoveByColor(true, .5));
    
    /*
    addSequential(new MoveByEncoder(40));//input actual distance once we get 
    addSequential(new FixPosition());
    addSequential(new MoveByEncoder(200));//input actual distance once we get it 
    if(driver.getLocation() == 1){
      addSequential(new TurnByGyro(90));
    }else{
      addSequential(new TurnByGyro(-90));
    }

    //addSequential(new MoveByEncoder()); if to close to cargoship
    //Make sure the arm is inline with the was cargo ship
    //MAKE SURE ITS NOT T00 CLOSE TO THE CARGO SHIP. MIGHT BREAK SOMETHING IF SO
    addSequential(new PistonOutput());
    addSequential(new MoveByEncoder(12));//input actual distance once we get it 
    if(driver.getLocation() == 1){
      addSequential(new TurnByGyro(90));
    }else{
      addSequential(new TurnByGyro(-90));
    }
    addSequential(new MoveByEncoder(190));//input actual distance once we get it
    if(driver.getLocation() == 1){
      addSequential(new TurnByGyro(90));
    }else{
      addSequential(new TurnByGyro(-90));
    }
    addSequential(new MoveByUltrasonic());
    if(driver.getLocation() == 1){
      addSequential(new TurnByGyro(-90));
    }else{
      addSequential(new TurnByGyro(90));
    }
    addSequential(new MoveByUltrasonic());
    */

    //CODE FOR TESTING
    //test each line individually

    //addSequential(new MoveByEncoder(10));
    //addSequential(new TurnByGyro(90));
    //addSequential(new MoveByEncoder(20));
    //addSequential(new FixPosition();
    //addSequential(new MoveByUltrasonic());
    //addSequential(new TurnByGyro(-90));
    //addSequential(new PistonOutput();
    //addSequential(new MoveByTimer(10));
  }
}
