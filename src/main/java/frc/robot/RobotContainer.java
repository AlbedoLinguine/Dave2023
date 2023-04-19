// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivebase2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  // private final Drivebase drivebase;
  Drivebase2 drivebase2;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    // drivebase = new Drivebase(new WPI_TalonSRX(2), new WPI_TalonSRX(8), new
    // WPI_TalonSRX(5),new WPI_TalonSRX(3), new WPI_TalonSRX(1), new
    // WPI_TalonSRX(4));
    drivebase2 = new Drivebase2();
    configureBindings();
  }

  // 14
  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    drivebase2.setDefaultCommand(
        // new RunCommand(() ->
        // drivebase2.drive(-driverController.getLeftY(),-driverController.getRightY()),
        // drivebase2
        new RunCommand(() -> {
          drivebase2.arcadeDrive(-driverController.getLeftY(), -driverController.getLeftX());
        },
            drivebase2));

    driverController.leftTrigger().onTrue(new InstantCommand(() -> {
      drivebase2.setMax(1);
    })).onFalse(new InstantCommand(() -> {
      drivebase2.setMax(0.3);
    }));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new WaitCommand(0);
  }

}
