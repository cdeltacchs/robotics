// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.OperatorConstants;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DefaultDriveCommand extends Command {

  private DriveSubsystem driveTrain;

  private double speed;
  private double turn;
  private boolean ampLimit;
  private boolean voltLimit;

  /** Creates a new DefaultDriveCommand. */
  public DefaultDriveCommand(DriveSubsystem driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = 0;
    turn = 0;
    ampLimit = false;
    voltLimit = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = OperatorConstants.joystickOne.getRawAxis(1);
    turn = OperatorConstants.joystickOne.getRawAxis(0);
    ampLimit = OperatorConstants.joystickOne.getRawButtonPressed(7);
    voltLimit = OperatorConstants.joystickOne.getRawButtonPressed(8);

    driveTrain.set(speed, turn, ampLimit, voltLimit);
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
