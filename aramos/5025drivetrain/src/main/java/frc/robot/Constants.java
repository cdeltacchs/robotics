// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.nio.channels.Channel;

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
    
    //Left front motor controler
    public static final int kLFMCPort = 21;
    //Left rear motor controller
    public static final int kLRMCPort = 22;
    //right front motor controller 
    public static final int kRFMCPort = 23;
    //right rear motor controller
    public static final int kRRMCPort = 24;
    
    //initiallizing encoders
    public static final Encoder ttebEncoder = new Encoder (kTTBEncoderChannelA,kTTBEncoderChannelB);
    
    //Initialze controlers/joysticks
    public static final Joystick joystickOne = new Joystick(kJoystickOnePort);
    public static final Joystick joystickTwo = new Joystick(kJoystickTwoPort);
   
    //Initialize motor controlers
    public static final TalonSRX leftFrontMotor = new TalonSRX(kLFMCPort);
    public static final TalonSRX leftRearMootor = new TalonSRX(kLRMCPort);
    public static final TalonSRX righttFrontMotor = new TalonSRX(kRFMCPort);
    public static final TalonSRX rightRearMotor = new TalonSRX(kRRMCPort);

    //Initialize Wench Controllers
    //Create Left and right Wench
    public static final TalonSRX leftWench = new TalonSRX(96);
    public static final TalonSRX rightWench = new TalonSRX(97);
   
    //initialize Grabber Motor controlers
    public static final TalonSRX leftGrabberMotor = new TalonSRX(98);
    public static final TalonSRX rightGrabberMotor = new TalonSRX(99);
  }
}
