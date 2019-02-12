/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static Joystick joyLeft = new Joystick(0); // port subject to change
  public static Joystick joyRight = new Joystick(1);
  Button buttonnFOut = new JoystickButton(joyRight, 6);//not real button #, TBD
  Button buttonFIn = new JoystickButton(joyRight, 7);//not real button #, TBD
  Button buttonBOut = new JoystickButton(joyRight, 4);//not real button #, TBD
  Button buttonBIn = new JoystickButton(joyRight, 2);//not real button #, TBD
  
/*
  Button buttonnFOut = new JoystickButton(rightStick, 5);//not real button #, TBD
  Button buttonFIn = new JoystickButton(rightStick, 6);//not real button #, TBD
  Button buttonBOut = new JoystickButton(rightStick, 3);//not real button #, TBD
  Button buttonBIn = new JoystickButton(rightStick, 4);//not real button #, TBD
*/
  public OI(){



  }
  
  
}


