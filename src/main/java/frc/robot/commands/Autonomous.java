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
    addSequential(new MoveByEncoder(1));//input actual distance once we get it
    addSequential(new FixPosition());
    addSequential(new MoveByEncoder(1));//input actual distance once we get it 
    if(driver.getLocation() == 1){
      addSequential(new TurnByEncoder(90));
    }else{
      addSequential(new TurnByEncoder(-90));
    }
    //addSequential(new MoveByEncoder()); if to close to cargoship
    addSequential(new PistonOutput());
    addSequential(new MoveByEncoder(1));//input actual distance once we get it 
    if(driver.getLocation() == 1){
      addSequential(new TurnByEncoder(90));
    }else{
      addSequential(new TurnByEncoder(-90));
    }
    addSequential(new MoveByEncoder(1));//input actual distance once we get it
    if(driver.getLocation() == 1){
      addSequential(new TurnByEncoder(90));
    }else{
      addSequential(new TurnByEncoder(-90));
    }
    addSequential(new MoveByUltrasonic(.5));
    if(driver.getLocation() == 1){
      addSequential(new TurnByEncoder(-90));
    }else{
      addSequential(new TurnByEncoder(90));
    }
    addSequential(new MoveByUltrasonic(.5));
  }
}
