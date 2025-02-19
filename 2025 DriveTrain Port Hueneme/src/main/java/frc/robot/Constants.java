// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    
    public static final int kJoystickOnePort = 0;
    public static final int kJoystickTwoPort = 1;
    
    public static final int kTTBEncoderChannelA = 0;
    public static final int kTTBEncoderChannelB = 1;

    // Initialize Amp/Volt Limits
    public static final int kPeakCurrentLimit = 40;
    public static final int kPeakCurrentDuration = 1500;
    public static final int kContinousCurrentLimit = 30;

    // Left Front Motor Controller Port
    public static final int kLFMCPort = 21;
    // Left Rear Motor Controller Port
    public static final int kLRMCPort = 22;
    // Right Front Motor Controller Port
    public static final int kRFMCPort = 23;
    // Right Rear Motor Controller Port
    public static final int kRRMCPort = 24;
    
    // Initialize Encoders
    public static final Encoder ttbEncoder = new Encoder(kTTBEncoderChannelA,kTTBEncoderChannelB);

    // Initialize Controllers/Joysticks
    public static final Joystick joystickOne = new Joystick(kJoystickOnePort);
    public static final Joystick joystickTwo = new Joystick(kJoystickTwoPort);

    // Initialize DriveTrain Motor Controllers
    public static final TalonSRX leftFrontMotor = new TalonSRX(kLFMCPort);
    public static final TalonSRX leftRearMotor = new TalonSRX(kLRMCPort);
    public static final TalonSRX rightFrontMotor = new TalonSRX(kRFMCPort);
    public static final TalonSRX rightRearMotor = new TalonSRX(kRRMCPort);

    // Initialize Wench Motor Controllers
    public static final TalonSRX leftWench = new TalonSRX(96);
    public static final TalonSRX rightWench = new TalonSRX(97);

    // Initialize Grabber Motor Controllers
    public static final TalonSRX leftGrabberMotor = new TalonSRX(98);
    public static final TalonSRX rightGrabberMotor = new TalonSRX(99);
  }
}
