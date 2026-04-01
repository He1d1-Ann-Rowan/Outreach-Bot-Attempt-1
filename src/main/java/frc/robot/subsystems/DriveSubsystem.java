package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;;

public class DriveSubsystem 
{
    private final SparkMax L_F_MOTOR = new SparkMax(0, MotorType.kBrushed);
    private final SparkMax L_B_MOTOR = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax R_F_MOTOR = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax R_B_MOTOR = new SparkMax(3, MotorType.kBrushed);

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
    }

    private final DifferentialDrive drive = new DifferentialDrive(L_F_MOTOR, R_F_MOTOR);

    public void drive(double forward, double turn)
    {
        drive.arcadeDrive(forward, turn);
    }
}
