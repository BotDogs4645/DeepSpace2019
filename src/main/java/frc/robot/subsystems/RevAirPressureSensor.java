package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ReadAnalogueGauge;

public class RevAirPressureSensor extends Subsystem
{
    public static AnalogInput analogGauge;

    public RevAirPressureSensor()
    {
        analogGauge= new AnalogInput(RobotMap.analogGauge);
    }

    public double getAirPressure()
    {
        return 250.0 * (analogGauge.getVoltage()/5.0) - 25.0;
        //250(volatge/5V)-25 rev documentation
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ReadAnalogueGauge());
    }

}