package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;


// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
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

    // private final MotorControllerGroup leftGroup = new MotorControllerGroup(L_F_MOTOR, L_B_MOTOR);
    // private final MotorControllerGroup rightGroup = new MotorControllerGroup(R_F_MOTOR, R_B_MOTOR);

    public DriveSubsystem()
    {
        SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
        leftFollowerConfig.follow(L_F_MOTOR);

        SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();
        rightFollowerConfig.follow(R_F_MOTOR);


        L_B_MOTOR.configure(leftFollowerConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        R_B_MOTOR.configure(rightFollowerConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
        drive = new DifferentialDrive(L_F_MOTOR, R_F_MOTOR);
    }

    //private final DifferentialDrive drive = new DifferentialDrive(L_F_MOTOR, R_F_MOTOR);

    public void drive(double forward, double turn)
    {
        drive.arcadeDrive(forward, turn);
    }
}
