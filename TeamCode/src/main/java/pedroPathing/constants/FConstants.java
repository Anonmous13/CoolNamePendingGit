package pedroPathing.constants;

import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.localization.Localizers;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FConstants {
    static {
        FollowerConstants.localizers = Localizers.THREE_WHEEL_IMU;


        FollowerConstants.leftFrontMotorName = "fl";
        FollowerConstants.leftRearMotorName = "bl";
        FollowerConstants.rightFrontMotorName = "fr";
        FollowerConstants.rightRearMotorName = "br";


        FollowerConstants.leftFrontMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.leftRearMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.rightFrontMotorDirection = DcMotorSimple.Direction.FORWARD;
        FollowerConstants.rightRearMotorDirection = DcMotorSimple.Direction.FORWARD;

//        FollowerConstants.useVoltageCompensationInAuto = true;
//        FollowerConstants.nominalVoltage = 13.0;

        FollowerConstants.mass = 13.3; //FollowerConstants.mass = 6.078138

        FollowerConstants.xMovement = 58.49314300817902;
        FollowerConstants.yMovement = 39.80977742497427;
        FollowerConstants.forwardZeroPowerAcceleration = -52.31087325087609;
        FollowerConstants.lateralZeroPowerAcceleration = -93.82746990758454;

        FollowerConstants.translationalPIDFCoefficients.setCoefficients(0.15,0,0.0023,0);
        FollowerConstants.useSecondaryTranslationalPID = true;
        FollowerConstants.secondaryTranslationalPIDFCoefficients.setCoefficients(0.235,0,0.05,0);

        FollowerConstants.headingPIDFCoefficients.setCoefficients(2.48,0,0.099,0);
        FollowerConstants.useSecondaryHeadingPID = true;
        FollowerConstants.secondaryHeadingPIDFCoefficients.setCoefficients(2,0,0.1,0);

        FollowerConstants.drivePIDFCoefficients.setCoefficients(0.125,0,0.00145,0.6,0.46);
        FollowerConstants.useSecondaryDrivePID = true ;
        FollowerConstants.secondaryDrivePIDFCoefficients.setCoefficients(0.1,0,0.00005,0.6,0);

        FollowerConstants.zeroPowerAccelerationMultiplier = 4;
        FollowerConstants.centripetalScaling = 0.0002;

        FollowerConstants.pathEndTimeoutConstraint = 50;
        FollowerConstants.pathEndTValueConstraint = 0.995;
        FollowerConstants.pathEndVelocityConstraint = 0.1;
        FollowerConstants.pathEndTranslationalConstraint = 0.1;
        FollowerConstants.pathEndHeadingConstraint = 0.007;

        FollowerConstants.useBrakeModeInTeleOp = true;

        //FollowerConstants.localizers = Localizers.THREE_WHEEL_IMU;
    }
}