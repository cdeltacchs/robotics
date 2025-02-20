// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  TalonSRXConfiguration config = new TalonSRXConfiguration();

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

    // Set Motor Controller Amp Configuration
    config.peakCurrentLimit = OperatorConstants.kPeakCurrentLimit;
    config.peakCurrentDuration = OperatorConstants.kPeakCurrentDuration;
    config.continuousCurrentLimit = OperatorConstants.kContinousCurrentLimit;
    OperatorConstants.leftFrontMotor.configAllSettings(config);
    OperatorConstants.leftRearMotor.configAllSettings(config);
    OperatorConstants.rightFrontMotor.configAllSettings(config);
    OperatorConstants.rightRearMotor.configAllSettings(config);

    // Set Motor Controller Volt Configuration
    OperatorConstants.leftFrontMotor.configVoltageCompSaturation(OperatorConstants.kVoltageCompensation);
    OperatorConstants.leftRearMotor.configVoltageCompSaturation(OperatorConstants.kVoltageCompensation);
    OperatorConstants.rightFrontMotor.configVoltageCompSaturation(OperatorConstants.kVoltageCompensation);
    OperatorConstants.rightRearMotor.configVoltageCompSaturation(OperatorConstants.kVoltageCompensation);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Encoder Value: ", OperatorConstants.ttbEncoder.getDistance());

    SmartDashboard.putNumber("Joystick One X-Axis: ", OperatorConstants.joystickOne.getRawAxis(0));
    SmartDashboard.putNumber("Joystick One Y-Axis: ", OperatorConstants.joystickOne.getRawAxis(1));
    SmartDashboard.putNumber("Joystick One Z-Axis: ", OperatorConstants.joystickOne.getRawAxis(2));

    SmartDashboard.putNumber("Left Front Motor % Output: ", OperatorConstants.leftFrontMotor.getMotorOutputPercent());
    SmartDashboard.putNumber("Left Front Motor Amp Output: ", OperatorConstants.leftFrontMotor.getStatorCurrent());
    
    SmartDashboard.putNumber("Left Rear Motor % Output: ", OperatorConstants.leftRearMotor.getMotorOutputPercent());
    SmartDashboard.putNumber("Left Rear Motor Amp Output: ", OperatorConstants.leftRearMotor.getStatorCurrent());

    SmartDashboard.putNumber("Right Front Motor % Output: ", OperatorConstants.rightFrontMotor.getMotorOutputPercent());
    SmartDashboard.putNumber("Right Front Motor Amp Output: ", OperatorConstants.rightFrontMotor.getStatorCurrent());

    SmartDashboard.putNumber("Right Rear Motor % Output: ", OperatorConstants.rightRearMotor.getMotorOutputPercent());
    SmartDashboard.putNumber("Right Rear Motor Ampt Output: ", OperatorConstants.rightRearMotor.getStatorCurrent());
  }

  // For Teleop
  public void set(double speed, double turn, boolean ampLimit, boolean voltLimit) {
    double leftSpeed = ((speed + turn)/4.0);
    double rightSpeed = ((speed - turn)/4.0);

    if (ampLimit) {
      enableAmpLimit();
    } else {
      disableAmpLimit();
    }

    if (voltLimit) {
      enableVoltLimit();
    } else {
      disableVoltLimit();
    }

    OperatorConstants.leftFrontMotor.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    OperatorConstants.leftRearMotor.set(TalonSRXControlMode.PercentOutput, leftSpeed);

    OperatorConstants.rightFrontMotor.set(TalonSRXControlMode.PercentOutput, rightSpeed);
    OperatorConstants.rightRearMotor.set(TalonSRXControlMode.PercentOutput, rightSpeed);
    
    // Old Code - Follow Method
    // SmartDashboard.putNumber("Left Speed: ", leftSpeed);
    // OperatorConstants.leftRearMotor.set(TalonSRXControlMode.Follower,OperatorConstants.leftFrontMotor.getDeviceID());
    // OperatorConstants.leftFrontMotor.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    
    // SmartDashboard.putNumber("Right Speed: ", rightSpeed);
    // OperatorConstants.rightRearMotor.set(TalonSRXControlMode.Follower, OperatorConstants.rightFrontMotor.getDeviceID());
    // OperatorConstants.rightFrontMotor.set(TalonSRXControlMode.PercentOutput, rightSpeed);
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

  private void enableAmpLimit() {
    OperatorConstants.leftFrontMotor.enableCurrentLimit(true);
    OperatorConstants.leftRearMotor.enableCurrentLimit(true);
    OperatorConstants.rightFrontMotor.enableCurrentLimit(true);
    OperatorConstants.rightRearMotor.enableCurrentLimit(true);
  }

  private void disableAmpLimit() {
    OperatorConstants.leftFrontMotor.enableCurrentLimit(false);
    OperatorConstants.leftRearMotor.enableCurrentLimit(false);
    OperatorConstants.rightFrontMotor.enableCurrentLimit(false);
    OperatorConstants.rightRearMotor.enableCurrentLimit(false);
  }

  private void enableVoltLimit() {
    OperatorConstants.leftFrontMotor.enableVoltageCompensation(true);
    OperatorConstants.leftRearMotor.enableVoltageCompensation(true);
    OperatorConstants.rightFrontMotor.enableVoltageCompensation(true);
    OperatorConstants.rightRearMotor.enableVoltageCompensation(true);
  }

  private void disableVoltLimit() {
    OperatorConstants.leftFrontMotor.enableVoltageCompensation(false);
    OperatorConstants.leftRearMotor.enableVoltageCompensation(false);
    OperatorConstants.rightFrontMotor.enableVoltageCompensation(false);
    OperatorConstants.rightRearMotor.enableVoltageCompensation(false);
  }
}
