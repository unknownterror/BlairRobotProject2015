package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	//======================Universal constants====================
	
	public final int ENCODER_PPR;
	
	//======================Elevator Constants=====================
	
	public final int ELEVATOR_ARM_SOLENOID_FWD; //Channels for the elevator's arm solenoid forward port.
	public final int ELEVATOR_ARM_SOLENOID_REV; //Channels for the elevator's arm solenoid reverse thing.
	public final int ELEVATOR_BRAKE_SOLENOID_FWD; //Channels for the elevator's brake solenoid forward thing.
	public final int ELEVATOR_BRAKE_SOLENOID_REV; //Channels for the elevator's brake solenoid reverse thing.
	
	public final int ELEVATOR_TOP_LIMIT; //Channel for the elevator's top limit switch.
	public final int ELEVATOR_BOTTOM_LIMIT; //Channel for the elevator's bottom limit switch.
	public final int ELEVATOR_LEFT_LIMIT; //Channel for the elevator's left limit switch.
	public final int ELEVATOR_RIGHT_LIMIT; //Channel for the elevator's right limit switch
	
	public final int ELEVATOR_ENCODER_CHANNEL_A;//Channel A for the elevator's encoder.
	public final int ELEVATOR_ENCODER_CHANNEL_B; //Channel B for the elevator's encoder.
	
	public final int ELEVATOR_LEFT_MOTOR; // Port for the elevator's left motor
	public final int ELEVATOR_RIGHT_MOTOR; //Port for the elevator's right motor
	
	public final double ELEVATOR_P;
	public final double ELEVATOR_I;
	public final double ELEVATOR_D;
	public final double ELEVATOR_PID_TOLERANCE_RANGE;
	
	//============================Drive Constants=======================

	public final int DRIVE_L1; //motor controller channel for the left 1 drive motor
	public final int DRIVE_L2; //motor controller channel for the left 1 drive motor
	public final int DRIVE_R1; //motor controller channel for the right 1 drive motor
	public final int DRIVE_R2; //motor controller channel for the right 1 drive motor
	
	public final int DRIVE_ENCODER_RA; // Channel A for right encoder
	public final int DRIVE_ENCODER_RB; //channel B for right encoder
	
	public final int DRIVE_ENCODER_LA; //channel A for left encoder
	public final int DRIVE_ENCODER_LB; //channel B for left encoder

	//drive PID parameters
	public final double DRIVE_P;
	public final double DRIVE_I;
	public final double DRIVE_D;
	public final double DRIVE_F;
	
	public final int DRIVE_MAX_RATE; //Hard limit for Drive speed under PID control in Rotations per second
	public final boolean DRIVE_DEFAULT_MODE; //default mode for drive control true = PID, false = Manual
	//===========================Controller Ports/Scheme======================

	public final int JOYSTICK_0; //Joystick usb port for Joystick 0
	public final int JOYSTICK_1; //Joystick usb port for Joystick 1
	public final int JOYSTICK_2; //Joystick usb port for Joystick 2
	public final int JOYSTICK_3; //Joystick usb port for Joystick 3
	
	public final int DRIVE_MANUAL_TOGGLE_JOYSTICK;// the joystick with the button to toggle manual mode for the drive system
	public final int DRIVE_MANUAL_TOGGLE_BUTTON; //the button number on DRIVE_MANUAL_TOGGLE_JOYSTICK that toggles manual mode for the drive system
	
	public final int ELEVATOR_UP_BUTTON;//Button for moving elevator up.
	public final int ELEVATOR_DOWN_BUTTON; //Button for moving elevator down.
	public final int ELEVATOR_ARMS_TOGGLE_BUTTON; //Button to toggle the elevator arms
	/**
	 * 
	 * @param configFile
	 */
	public RobotMap(String configFile)
	{
		this.ENCODER_PPR = 512;
		
		this.JOYSTICK_0 = 1;
		this.JOYSTICK_1 = 2;
		this.JOYSTICK_2 = 3;
		this.JOYSTICK_3 = 4;
		
		this.DRIVE_L1 = 0;
		this.DRIVE_L2 = 1;
		
		this.DRIVE_R1 = 2;
		this.DRIVE_R2 = 3;
		
		this.ELEVATOR_TOP_LIMIT = 0;
		this.ELEVATOR_BOTTOM_LIMIT = 1;
		this.ELEVATOR_LEFT_LIMIT = 2;
		this.ELEVATOR_RIGHT_LIMIT = 3;
		
		this.ELEVATOR_ARM_SOLENOID_FWD = 0;
		this.ELEVATOR_ARM_SOLENOID_REV = 1;
		this.ELEVATOR_BRAKE_SOLENOID_FWD = 2;
		this.ELEVATOR_BRAKE_SOLENOID_REV = 3;
		
		this.ELEVATOR_ENCODER_CHANNEL_A = 0;
		this.ELEVATOR_ENCODER_CHANNEL_B = 1;
		
		this.ELEVATOR_P = 0.05;
		this.ELEVATOR_I = 0;
		this.ELEVATOR_D = 0;

		this.ELEVATOR_LEFT_MOTOR = 0;
		this.ELEVATOR_RIGHT_MOTOR = 1;
		
		this.ELEVATOR_PID_TOLERANCE_RANGE = 0.001;
		
		this.ELEVATOR_UP_BUTTON = 3;
		this.ELEVATOR_DOWN_BUTTON = 2;
		
		this.ELEVATOR_ARMS_TOGGLE_BUTTON = 1;
		
		this.DRIVE_ENCODER_RA = 0;
		this.DRIVE_ENCODER_RB = 1;
		this.DRIVE_ENCODER_LA = 2;
		this.DRIVE_ENCODER_LB = 3;
		
		this.DRIVE_MAX_RATE = 512;
		
		this.DRIVE_P = 0.05;
		this.DRIVE_I = 0;
		this.DRIVE_D = 0;
		this.DRIVE_F = 0.05;

		this.DRIVE_MANUAL_TOGGLE_JOYSTICK 	= 1;
		this.DRIVE_MANUAL_TOGGLE_BUTTON 	= 1;
		
		this.DRIVE_DEFAULT_MODE = Drive.MANUAL;
	}//end RobotMap()
}//end class
