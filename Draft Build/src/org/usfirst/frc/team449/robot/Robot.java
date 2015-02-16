package org.usfirst.frc.team449.robot;

import org.usfirst.frc.team449.robot.subsystems.Arms;
import org.usfirst.frc.team449.robot.subsystems.Drive;
import org.usfirst.frc.team449.robot.subsystems.Elevator;
import org.usfirst.frc.team449.robot.subsystems.Intake;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.IMAQdxBufferNumberMode;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//sometime should check if these could be made private
	public static final RobotMap robotMap = new RobotMap("config.txt");
	
	public static final Elevator	elevator	= new Elevator(Robot.robotMap);
	public static final Arms		elevatorArm	= new Arms(Robot.robotMap);
	public static final Drive		drive		= new Drive(Robot.robotMap);
	public static final Intake 		intake		= new Intake(Robot.robotMap);
	
	public static final OI 			OI 			= new OI(Robot.robotMap);
	
	public static final Compressor c = new Compressor();
	
	//public static CameraServer camera;
	
	Command autonomousCommand;
	
    int session;
    Image frame;

	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("Robot Init Started");
		// instantiate the command used for the autonomous period
        autonomousCommand = null;
        c.start();
        
        //camera = CameraServer.getInstance();
        //camera.setQuality(50);
        //camera.startAutomaticCapture("cam0");
                
        //frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        //session = NIVision.IMAQdxOpenCamera("cam0",
        //        NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();


    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //SmartDashboard.putNumber("Encoder position", Robot.elevator.getEncoderReading());

        //SmartDashboard.putBoolean("TopLimit", Robot.elevator.isTouchingTop());
        //SmartDashboard.putBoolean("BottomLimit", Robot.elevator.isTouchingBottom());
    
        //SmartDashboard.putNumber("Left drive encoder", Robot.drive.getLeftVel());
        //SmartDashboard.putNumber("Right drive encoder", Robot.drive.getRightVel());
        
        // Update Grabber status
        SmartDashboard.putBoolean("grabberStatus", elevatorArm.getArmState());
        
        // Update Elevator position
        SmartDashboard.putBoolean("isAtTopPosition", elevator.getPosition() == Elevator.ELEVATOR_THIRD_POSITION);
        SmartDashboard.putBoolean("isAtMiddlePosition", elevator.getPosition() == Elevator.ELEVATOR_SECOND_POSITION);
        SmartDashboard.putBoolean("isAtBottomPosition", elevator.getPosition() == Elevator.ELEVATOR_THIRD_POSITION);
        
        // Update Drive mode
        SmartDashboard.putBoolean("driveMode", drive.getControlMode() == Drive.PID);
        SmartDashboard.putNumber("Encoder position", Robot.elevator.getEncoderPosition());

        SmartDashboard.putBoolean("TopLimit", Robot.elevator.isTouchingTop());
        SmartDashboard.putBoolean("BottomLimit", Robot.elevator.isTouchingBottom());
    
        SmartDashboard.putBoolean("LeftLimit", Robot.intake.getSwitchState());
        //SmartDashboard.putNumber("Left drive encoder", Robot.drive.getLeftVel());
        //SmartDashboard.putNumber("Right drive encoder", Robot.drive.getRightVel());

        //NIVision.IMAQdxStartAcquisition(session);
        //NIVision.IMAQdxGrab(session, frame, 1);
        
        //CameraServer.getInstance().setImage(frame);
        //NIVision.IMAQdxStopAcquisition(session);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}