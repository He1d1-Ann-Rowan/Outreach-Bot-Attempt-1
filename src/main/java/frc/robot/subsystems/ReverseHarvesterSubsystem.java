package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class ReverseHarvesterSubsystem 
{
    private final PWMSparkMax reverseHarvesterMotor = new PWMSparkMax(4);

    public ReverseHarvesterSubsystem()
    {

    }

    public void spin(double speed)
    {
        reverseHarvesterMotor.set(speed);
    }
}
