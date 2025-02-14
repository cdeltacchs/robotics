// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // Defaults the motor value of rotations to 0
    OperatorConstants.leftFrontMotor.configFactoryDefault();
    OperatorConstants.leftRearMotor.configFactoryDefault();
    OperatorConstants.rightFrontMotor.configFactoryDefault();
    OperatorConstants.rightRearMotor.configFactoryDefault();
    
    // Inverts the left motors and doesn't for the right motors for correct rotations
    OperatorConstants.leftFrontMotor.setInverted(true);
    OperatorConstants.leftRearMotor.setInverted(true);
    OperatorConstants.rightFrontMotor.setInverted(false);
    OperatorConstants.rightRearMotor.setInverted(false);

    // Defaults the encoder values
    OperatorConstants.ttbEncoder.reset();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Value: ", OperatorConstants.ttbEncoder.getDistance());
    SmartDashboard.putNumber("Joystick 1 X Axis: ", OperatorConstants.joystickOne.getRawAxis(0));
    SmartDashboard.putNumber("Joystick 1 Y Axis: ", OperatorConstants.joystickOne.getRawAxis(1));
    SmartDashboard.putNumber("Joystick 1 Z Axis: ", OperatorConstants.joystickOne.getRawAxis(2));
    SmartDashboard.putString("Does it work? ", "Yes");
  }
}