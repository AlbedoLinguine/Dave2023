package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase2 extends SubsystemBase {
    WPI_TalonSRX leftBack = new WPI_TalonSRX(Constants.DriveConstants.LEFT_BACK);
    WPI_TalonSRX leftCenter = new WPI_TalonSRX(Constants.DriveConstants.LEFT_CENTER);
    WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.DriveConstants.LEFT_FRONT); 
    WPI_TalonSRX rightBack = new WPI_TalonSRX(Constants.DriveConstants.RIGHT_BACK);
    WPI_TalonSRX rightCenter = new WPI_TalonSRX(Constants.DriveConstants.RIGHT_CENTER);
    WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.DriveConstants.RIGHT_FRONT);

    MotorControllerGroup left = new MotorControllerGroup(leftBack, leftCenter, leftFront);
    MotorControllerGroup right = new MotorControllerGroup(rightBack, rightCenter, rightFront);

    DifferentialDrive dt = new DifferentialDrive(left, right);

    public Drivebase2() {
        left.setInverted(true);
        right.setInverted(false);

        dt.setMaxOutput(0.5);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        dt.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double forward, double turn) {
        dt.arcadeDrive(forward, turn);
    }

    public void setMax(double maxOutput) {
        dt.setMaxOutput(maxOutput);
    }
}
