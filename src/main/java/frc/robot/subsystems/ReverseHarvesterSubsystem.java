package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import frc.robot.Constants;

public class ReverseHarvesterSubsystem 
{
    private final SparkMax reverseHarvesterMotor = new SparkMax(Constants.ReverseHarvesterConstants.SCATTER_BAR_MOTOR, MotorType.kBrushed);

    public ReverseHarvesterSubsystem()
    {
        
    }

    public void spin(double speed)
    {
        reverseHarvesterMotor.set(speed);
    }
}
