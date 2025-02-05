// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DefaultDriveCommand extends Command {

  private DriveSubsystem driveTrain;
  private Joystick joystickOne;

  private double speed;
  private double turn;

  /** Creates a new DefaultDriveCommand. */
  public DefaultDriveCommand(DriveSubsystem driveTrain, Joystick joystickOne) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.joystickOne = joystickOne;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = 0;
    turn = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = joystickOne.getRawAxis(1);
    turn = joystickOne.getRawAxis(0);

    driveTrain.set(speed, turn);

    // if((joystickOne.getRawAxis(1) > 0.2) || (joystickOne.getRawAxis(1) < -0.2)) {
    //   driveTrain.set(speed, turn);
    // } else {
    //   driveTrain.set(0,0);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
