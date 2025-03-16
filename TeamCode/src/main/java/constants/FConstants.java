package constants;

import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.localization.Localizers;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FConstants {
    static {
        FollowerConstants.localizers = Localizers.PINPOINT;


        FollowerConstants.leftFrontMotorName = "lf_drive";
        FollowerConstants.leftRearMotorName = "lb_drive";
        FollowerConstants.rightFrontMotorName = "rf_drive";
        FollowerConstants.rightRearMotorName = "rb_drive";


        FollowerConstants.leftFrontMotorDirection = DcMotorSimple.Direction.FORWARD;
        FollowerConstants.leftRearMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.rightFrontMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.rightRearMotorDirection = DcMotorSimple.Direction.FORWARD;

//        FollowerConstants.useVoltageCompensationInAuto = true;
//        FollowerConstants.nominalVoltage = 13.0;

        FollowerConstants.mass = 10.3;

        FollowerConstants.xMovement = 62.69362209292151;
        FollowerConstants.yMovement = 48.79572547663962;

        FollowerConstants.forwardZeroPowerAcceleration =  -35.04510292153005;
        FollowerConstants.lateralZeroPowerAcceleration = -63.39203880361718;

        FollowerConstants.translationalPIDFCoefficients.setCoefficients(0.15,0,0.0023,0);
        FollowerConstants.useSecondaryTranslationalPID = true;
        FollowerConstants.secondaryTranslationalPIDFCoefficients.setCoefficients(0.235,0,0.05,0);

        FollowerConstants.headingPIDFCoefficients.setCoefficients(2.48,0,0.099,0);
        FollowerConstants.useSecondaryHeadingPID = false;
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
    }
}