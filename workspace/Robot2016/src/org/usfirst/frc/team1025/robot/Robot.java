package org.usfirst.frc.team1025.robot;

//import org.usfirst.frc.team1025.robot.commands.Autonomous.*;
import org.usfirst.frc.team1025.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
   
	public static BasketArmSubsystem basketarmSubsystem ;
	public static BasketRollerSubsystem basketrollerSubsystem;
    public static BigArmSubsystem bigarmSubsystem;
	public static CameraSubsystem cameraSubsystem;
    public static CatapultReturnSubsystem catapultreturnSubsystem;
	public static ChassisSubsystem chassisSubsystem;
    public static ClimberArmSubsystem climberarmSubsystem;
    public static ClimberWinchSubsystem climberwinchSubsystem;
    
    private Command autonomousCommand;
	public SendableChooser autoChooser;
	public SendableChooser autonomousDirectionChooser;


    public void robotInit() {
        cameraSubsystem = new CameraSubsystem();
        chassisSubsystem = new ChassisSubsystem();
        basketarmSubsystem = new BasketArmSubsystem();
        basketrollerSubsystem = new BasketRollerSubsystem();
        bigarmSubsystem = new BigArmSubsystem();
        catapultreturnSubsystem = new CatapultReturnSubsystem();
        climberarmSubsystem = new ClimberArmSubsystem();
        climberwinchSubsystem = new ClimberWinchSubsystem();
       
        oi = new OI();

		autoChooser = new SendableChooser();
		

        
        chassisSubsystem.stop();
       
       
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
    }

    public void teleopInit() {
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }
        chassisSubsystem.stop();
       
    }

    public void disabledInit(){
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }

    public void updateStatus() {
        //SmartDashboard.putNumber("Num Totes in Robot",  numTotesInRobot);

        cameraSubsystem.updateStatus();
        chassisSubsystem.updateStatus();
        basketarmSubsystem.updateStatus();
        basketrollerSubsystem.updateStatus();
        bigarmSubsystem.updateStatus();
        catapultreturnSubsystem.updateStatus();
        climberarmSubsystem.updateStatus();
        climberwinchSubsystem.updateStatus();
    
    }
    
   
}
