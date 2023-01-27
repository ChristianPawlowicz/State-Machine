package frc.robot;

import org.photonvision.PhotonCamera;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.lib.RoboLionsPID;
import frc.robot.lib.Swerve;

public class RobotMap {
    
    /* Motor IDs */
    public static final int pigeonID = 5;
    
    /* Motor instances */
    public static Pigeon2 gyro;

    /* Class instances */
    public static Swerve swerve; 
    public static RoboLionsPID rotationPID;
    public static CTREConfigs ctreConfigs;
    public static SwerveModule[] swerveModules;
    public static PhotonCamera camera;
    public static AprilTagFieldLayout aprilTagFieldLayout;

    /* Xbox controllers */
    public static XboxController manipulatorController;
    public static XboxController driverController;

    public static void init() {
        
        ctreConfigs = new CTREConfigs();
        manipulatorController = new XboxController(1);
        driverController = new XboxController(0);
        gyro = new Pigeon2(pigeonID);
        swerveModules = new SwerveModule[] {
            new SwerveModule(0, Constants.Swerve.Mod0.constants),
            new SwerveModule(1, Constants.Swerve.Mod1.constants),
            new SwerveModule(2, Constants.Swerve.Mod2.constants),
            new SwerveModule(3, Constants.Swerve.Mod3.constants)
        };
        rotationPID = new RoboLionsPID();
        swerve = new Swerve();
        camera = new PhotonCamera("Arducam_0V9281_USB_Camera");
        try {
            aprilTagFieldLayout = AprilTagFieldLayout.loadFromResource(AprilTagFields.k2023ChargedUp.m_resourceFile);
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }
}
