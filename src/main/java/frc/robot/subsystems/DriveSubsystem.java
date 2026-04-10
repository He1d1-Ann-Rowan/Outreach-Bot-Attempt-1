package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class DriveSubsystem 
{
    private final SparkMax L_F_MOTOR = new SparkMax(Constants.DriveConstants.L_F_MOTOR, MotorType.kBrushed);
    private final SparkMax L_B_MOTOR = new SparkMax(Constants.DriveConstants.L_B_MOTOR, MotorType.kBrushed);
    private final SparkMax R_F_MOTOR = new SparkMax(Constants.DriveConstants.R_F_MOTOR, MotorType.kBrushed);
    private final SparkMax R_B_MOTOR = new SparkMax(Constants.DriveConstants.R_B_MOTOR, MotorType.kBrushed);

    private final DifferentialDrive drive;

    public DriveSubsystem()
    {
        SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
        leftFollowerConfig.follow(L_F_MOTOR, true);

        SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();
        rightFollowerConfig.follow(R_F_MOTOR, true);

        L_B_MOTOR.configure(leftFollowerConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        R_B_MOTOR.configure(rightFollowerConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    

        drive = new DifferentialDrive(L_F_MOTOR, R_F_MOTOR);
        drive.setSafetyEnabled(false);
    }

    public void drive(double forward, double turn)
    {
        System.out.println("Yes");
        drive.arcadeDrive(forward, turn);
    }
}
