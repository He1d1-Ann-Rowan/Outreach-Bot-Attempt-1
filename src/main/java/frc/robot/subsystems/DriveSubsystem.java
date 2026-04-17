package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class DriveSubsystem 
{
    private final SparkMax m_leftMotor = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax m_rightMotor = new SparkMax(2, MotorType.kBrushed);


    private final DifferentialDrive m_drive;

    public DriveSubsystem()
    {
        m_drive = new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);
        SendableRegistry.addChild(m_drive, m_leftMotor);
        SendableRegistry.addChild(m_drive, m_rightMotor);

        //m_rightMotor.setInverted(false);
        //m_leftMotor.setInverted(true);
    }

    public void drive(double Forward, double Rotation)
    {

        m_rightMotor.setInverted(false);
        m_leftMotor.setInverted(true);

        System.out.println("Forward: " + Forward);
        System.out.println("Rotation: " + Rotation);
        m_drive.arcadeDrive(Forward, Rotation); 
    }
}
