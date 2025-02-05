// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  // Initialize Left Motors
  private TalonSRX leftFrontMotor = new TalonSRX(21);
  private TalonSRX leftRearMotor = new TalonSRX(23);

  // Initialize Right Motors
  private TalonSRX rightFrontMotor = new TalonSRX(22);
  private TalonSRX rightRearMotor = new TalonSRX(24);

  // Initialize Encoder
  private Encoder encoder = new Encoder(1,2);

  // Initialize Joystick
  Joystick joystickOne = new Joystick(0);

  
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // Reset motors to default values
    leftFrontMotor.configFactoryDefault();
    leftRearMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    rightRearMotor.configFactoryDefault();
    
    // Set motors to either invert/not-invert
    leftFrontMotor.setInverted(true);
    leftRearMotor.setInverted(true);
    rightFrontMotor.setInverted(false);
    rightRearMotor.setInverted(false);

    // Reset encoder
    encoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Encoder Value: ", getEncoderValue());
    SmartDashboard.putNumber("Joystick One Y-Axis: ", getYAxisValue(joystickOne));
    SmartDashboard.putNumber("Joystick One X-Axis: ", getXAxisValue(joystickOne));
  }

  public double getEncoderValue() {
    return encoder.getDistance();
  }

  public double getYAxisValue(Joystick joystickOne) {
    return joystickOne.getRawAxis(1);
  }

  public double getXAxisValue(Joystick joystickOne) {
    return joystickOne.getRawAxis(0);
  }

  // For Teleop
  public void set(double speed, double turn) {
    double leftSpeed = ((speed + turn)/4.0);
    double rightSpeed = ((speed - turn)/4.0);
    
    SmartDashboard.putNumber("Left Speed: ", leftSpeed);
    leftRearMotor.set(TalonSRXControlMode.Follower,leftFrontMotor.getDeviceID());
    leftFrontMotor.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    
    SmartDashboard.putNumber("Right Speed: ", rightSpeed);
    rightRearMotor.set(TalonSRXControlMode.Follower, rightFrontMotor.getDeviceID());
    rightFrontMotor.set(TalonSRXControlMode.PercentOutput, rightSpeed);
  }

  // For Autonomous
  public void tankMode(double left, double right) {}

  // To stop all motors
  public void stop() {
    leftFrontMotor.neutralOutput();
    leftRearMotor.neutralOutput();
    rightFrontMotor.neutralOutput();
    rightRearMotor.neutralOutput();
  }
}
