   
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RevAirPressureSensor extends Subsystem
{
    public static AnalogInput analogInputNumber;

    public RevAirPressureSensor(int pAnalogInput)
    {
        analogInputNumber= new AnalogInput(pAnalogInput);
    }

    public double getAirPressure()
    {
        return 250.0 * (analogInputNumber.getVoltage()/5.0) - 25.0;
        //250(volatge/5V)-25 rev documentation
    }

    @Override
    protected void initDefaultCommand() {

    }

}