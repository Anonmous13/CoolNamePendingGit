package pedroPathing.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class LConstants {
    static {
        PinpointConstants.forwardY = 8;
        PinpointConstants.strafeX = -12.3;
        PinpointConstants.distanceUnit = DistanceUnit.INCH;
        PinpointConstants.hardwareMapName = "pinpoint";
        PinpointConstants.useYawScalar = false;
        PinpointConstants.yawScalar = 1.0;
        PinpointConstants.useCustomEncoderResolution = false;
        PinpointConstants.encoderResolution = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD;
        PinpointConstants.customEncoderResolution = 13.26291192;
        PinpointConstants.forwardEncoderDirection = GoBildaPinpointDriver.EncoderDirection.REVERSED;
        PinpointConstants.strafeEncoderDirection = GoBildaPinpointDriver.EncoderDirection.FORWARD;

//        ThreeWheelIMUConstants.forwardTicksToInches = .[INPUT];
//        ThreeWheelIMUConstants.strafeTicksToInches = .[INPUT];
//        ThreeWheelIMUConstants.turnTicksToInches = [INPUT];
//        ThreeWheelIMUConstants.leftY = [INPUT];
//        ThreeWheelIMUConstants.rightY = [INPUT];
//        ThreeWheelIMUConstants.strafeX = [INPUT];
//        ThreeWheelIMUConstants.leftEncoder_HardwareMapName = "leftOdo";
//        ThreeWheelIMUConstants.rightEncoder_HardwareMapName = "rightOdo";
//        ThreeWheelIMUConstants.strafeEncoder_HardwareMapName = "strafeOdo";
//        ThreeWheelIMUConstants.leftEncoderDirection = Encoder.REVERSE;
//        ThreeWheelIMUConstants.rightEncoderDirection = Encoder.REVERSE;
//        ThreeWheelIMUConstants.strafeEncoderDirection = Encoder.FORWARD;
//        ThreeWheelIMUConstants.IMU_HardwareMapName = "9 Axis IMU";
//        ThreeWheelIMUConstants.IMU_Orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.LEFT);
    }
}



