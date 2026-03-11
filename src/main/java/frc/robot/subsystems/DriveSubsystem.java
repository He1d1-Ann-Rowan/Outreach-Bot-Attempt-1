package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem 
{
    private final PWMSparkMax L_F_MOTOR = new PWMSparkMax(0);
    private final PWMSparkMax L_B_MOTOR = new PWMSparkMax(1);
    private final PWMSparkMax R_F_MOTOR = new PWMSparkMax(2);
    private final PWMSparkMax R_B_MOTOR = new PWMSparkMax(3);

    // private final MotorControllerGroup leftGroup = new MotorControllerGroup(L_F_MOTOR, L_B_MOTOR);
    // private final MotorControllerGroup rightGroup = new MotorControllerGroup(R_F_MOTOR, R_B_MOTOR);

    public DriveSubsystem()
    {
        L_F_MOTOR.addFollower(L_B_MOTOR);
        R_F_MOTOR.addFollower(R_B_MOTOR);
    }

    private final DifferentialDrive drive = new DifferentialDrive(L_F_MOTOR, R_F_MOTOR);

    public void drive(double forward, double turn)
    {
        drive.arcadeDrive(forward, turn);
    }
}
