package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    WPI_TalonSRX motorLeftBack;
    WPI_TalonSRX motorLeftCenter;
    WPI_TalonSRX motorLeftFront;
    WPI_TalonSRX motorRightBack;
    WPI_TalonSRX motorRightCenter;
    WPI_TalonSRX motorRightFront;

    public Drivebase(WPI_TalonSRX motorLeftBack, WPI_TalonSRX motorLeftCenter, WPI_TalonSRX motorLeftFront,
            WPI_TalonSRX motorRightBack, WPI_TalonSRX motorRightCenter, WPI_TalonSRX motorRightFront) {
        this.motorLeftBack = motorLeftBack;
        this.motorLeftCenter = motorLeftCenter;
        this.motorLeftFront = motorLeftFront;
        this.motorRightBack = motorRightBack;
        this.motorRightCenter = motorRightCenter;
        this.motorRightFront = motorRightFront;

        this.motorLeftCenter.follow(motorLeftBack);
        this.motorLeftFront.follow(motorLeftBack);

        this.motorRightCenter.follow(motorRightBack);
        this.motorRightFront.follow(motorRightBack);

        this.motorLeftBack.setNeutralMode(NeutralMode.Coast);
        this.motorRightBack.setNeutralMode(NeutralMode.Coast);

        this.motorLeftBack.setInverted(false);
        this.motorRightBack.setInverted(true);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        this.motorLeftBack.set(leftSpeed);
        this.motorRightBack.set(rightSpeed);
    }

}
