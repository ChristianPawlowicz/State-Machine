package frc.robot.subsystems.drive;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Robot;
import frc.robot.lib.StateMachine;
import frc.robot.lib.Transition;

public class DrivetrainStateMachine extends StateMachine {

    public TeleopState teleopSwerve = new TeleopState();
    public FollowTag aprilTagState = new FollowTag();

    private static XboxController driverController = Robot.driverController;

    public DrivetrainStateMachine() {

        Supplier<Boolean> checkAButton = () -> {
            return driverController.getAButton();
        };

        Supplier<Boolean> checkBButton = () -> {
            return driverController.getBButton();
        };

        teleopSwerve.addTransition(new Transition(checkAButton, aprilTagState));
        aprilTagState.addTransition(new Transition(checkBButton, teleopSwerve));

        setCurrentState(teleopSwerve);
    }
    
}
