package frc.robot;

import org.photonvision.PhotonPoseEstimator;

import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.apriltag.AprilTagFieldLayout.OriginPosition;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.Constants.PhotonConstants;
import frc.robot.lib.Arm;
import frc.robot.lib.Swerve;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;

public class RobotMap {
    
    /* Motor + sensor IDs */
    public static final int pigeonID = 5;
    
    /* Motor + sensor instances */
    public static WPI_Pigeon2 gyro;

    /* Class instances */
    public static Swerve swerve; 
    public static CTREConfigs ctreConfigs;
    public static AprilTagFieldLayout aprilTagFieldLayout;
    public static Field2d Field2d;
    public static Arm arm;

    /* Xbox controllers */
    public static XboxController manipulatorController;
    public static XboxController driverController;

    public static void init() {
        
        ctreConfigs = new CTREConfigs();
        manipulatorController = new XboxController(1);
        driverController = new XboxController(0);
        gyro = new WPI_Pigeon2(pigeonID);
        swerve = new Swerve();
        arm = new Arm();
        try {
            aprilTagFieldLayout = AprilTagFieldLayout.loadFromResource(AprilTagFields.k2023ChargedUp.m_resourceFile);
        } catch (Exception e) {
            DriverStation.reportError("Failed to load AprilTagFieldLayout", e.getStackTrace());
            aprilTagFieldLayout = null;
        }
        Field2d = new Field2d();
    }
}
