// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

/* 
   *
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

    // Controls the ports for both of the Joysticks
    public static final int kJoystickOnePort = 0;
    public static final int kJoystickTwoPort = 1;

    
    public static final int kTTBEncoderChannelA = 0;
    public static final int kTTBEncoderChannelB = 1;

    public static final int kLFMCPort = 21; // Left Front Motor Controller
    public static final int kLRMCPort = 22; // Left Rear Motor Controller
    public static final int kRFMCPort = 23; // Right Front Motor Controller
    public static final int kRRMCPort = 24; // Right Rear Motor Controller

    public static final int kLWMCPort = 96; // Left Wench Motor Controller
    public static final int kRWMCPort = 97; // Right Wench Motor Controller
    
    public static final int kLGMCPort = 98; // Left Grabber Motor Controller
    public static final int kRGMCPort = 99; // Right Grabber Motor Controller

    // Init encoders
    public static final Encoder ttbEncoder = new Encoder(kTTBEncoderChannelA, kTTBEncoderChannelB);

    // Init joystick controllers
    public static final Joystick joystickOne = new Joystick(kJoystickOnePort);
    public static final Joystick joystickTwo = new Joystick(kJoystickTwoPort);

    // Init drivetrain motor controllers
    public static final TalonSRX leftFrontMotor = new TalonSRX(kLFMCPort);
    public static final TalonSRX leftRearMotor = new TalonSRX(kLRMCPort);
    public static final TalonSRX rightFrontMotor = new TalonSRX(kRFMCPort);
    public static final TalonSRX rightRearMotor = new TalonSRX(kRRMCPort);

    // Init wench motor controllers
    public static final TalonSRX leftWenchMotor = new TalonSRX(kLWMCPort);
    public static final TalonSRX rightWenchMotor = new TalonSRX(kRWMCPort);

    // Init grabber motor controllers
    public static final TalonSRX leftGrabberMotor = new TalonSRX(kLGMCPort);
    public static final TalonSRX rightGrabberMotor = new TalonSRX(kRGMCPort);
  }
}