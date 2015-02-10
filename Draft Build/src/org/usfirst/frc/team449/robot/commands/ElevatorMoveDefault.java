package org.usfirst.frc.team449.robot.commands;

import org.usfirst.frc.team449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * MoveDirect: Manual control for the elevator
 * note: it directly sets the brake.
 * sets the motor throttle based on direct joystick response
 * if the joystick is below the deadband, activate brake and set motor output to zero
 * if an override is depressed, force the brake to be turned off
 * (this is why I did direct brake access)
 *  started: hazheng 2/1/15
 */
public class ElevatorMoveDefault extends Command {
	
	private final double deadband = .1; //deadband for joystick response
	private final double joystick_scale =1; //assumes joystick vals are -1 to 1;
	
	private double joystick_val; //scaled joystick value
	
    public ElevatorMoveDefault() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.elevator.isPIDEnabled()) 
    		return;
    	
    	joystick_val = -joystick_scale*Robot.OI.getElevatorJoystickAxisY();// arbitrary assignment
    	System.out.println(joystick_val);
    	System.out.println(Robot.elevator.isTouchingBottom());
    	
    	if(Math.abs(joystick_val) > deadband)//if input is over deadband and no override 
    	{
    		//System.out.println("greater than deadband");
            //if limit switches aren't triggered in direction to move in
    		if(joystick_val > 0 && !(Robot.elevator.isTouchingTop()) || joystick_val < 0 && !(Robot.elevator.isTouchingBottom()))
    		{
    			SmartDashboard.putString("motion", "is moving");
        		Robot.elevator.releaseBrake();
    			Robot.elevator.setMotorManual(joystick_val);	
    	
    		}else
    		{
    			SmartDashboard.putString("motion", "is stopping");
        		Robot.elevator.setMotorManual(0);
        		Robot.elevator.activateBrake();
    		}//endif
  
    	}
    	else
		{
			SmartDashboard.putString("motion", "is stopping");
    		Robot.elevator.setMotorManual(0);
    		Robot.elevator.activateBrake();
		}//endif
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
