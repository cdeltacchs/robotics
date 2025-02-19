// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // Reset motors to default values
    OperatorConstants.leftFrontMotor.configFactoryDefault();
    OperatorConstants.leftRearMotor.configFactoryDefault();
    OperatorConstants.rightFrontMotor.configFactoryDefault();
    OperatorConstants.rightRearMotor.configFactoryDefault();
    
    // Set motors to either invert/not-invert
    OperatorConstants.leftFrontMotor.setInverted(true);
    OperatorConstants.leftRearMotor.setInverted(true);
    OperatorConstants.rightFrontMotor.setInverted(false);
    OperatorConstants.rightRearMotor.setInverted(false);

    // Reset encoder
    OperatorConstants.ttbEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Encoder Value: ", OperatorConstants.ttbEncoder.getDistance());

    SmartDashboard.putNumber("Joystick One X-Axis: ", OperatorConstants.joystickOne.getRawAxis(0));
    SmartDashboard.putNumber("Joystick One Y-Axis: ", OperatorConstants.joystickOne.getRawAxis(1));
    SmartDashboard.putNumber("Joystick One Z-Axis: ", OperatorConstants.joystickOne.getRawAxis(2));
  }

  // For Teleop
  public void set(double speed, double turn) {
    double leftSpeed = ((speed + turn)/4.0);
    double rightSpeed = ((speed - turn)/4.0);
    
    SmartDashboard.putNumber("Left Speed: ", leftSpeed);
    OperatorConstants.leftRearMotor.set(TalonSRXControlMode.Follower,OperatorConstants.leftFrontMotor.getDeviceID());
    OperatorConstants.leftFrontMotor.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    
    SmartDashboard.putNumber("Right Speed: ", rightSpeed);
    OperatorConstants.rightRearMotor.set(TalonSRXControlMode.Follower, OperatorConstants.rightFrontMotor.getDeviceID());
    OperatorConstants.rightFrontMotor.set(TalonSRXControlMode.PercentOutput, rightSpeed);
  }

  // For Autonomous
  public void tankMode(double left, double right) {}

  // To stop all motors
  public void stop() {
    OperatorConstants.leftFrontMotor.neutralOutput();
    OperatorConstants.leftRearMotor.neutralOutput();
    OperatorConstants.rightFrontMotor.neutralOutput();
    OperatorConstants.rightRearMotor.neutralOutput();
  }
}
