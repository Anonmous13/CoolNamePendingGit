package bot.tests;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous(name = "Pose, and Position Calculator")
public class stuffFinder extends OpMode {
    DcMotorEx back, misumi, frontLeft, frontRight, backLeft, backRight;
    private Follower follower;
    private CRServo wrist, linearWrist, intake, outtake;

    @Override
    public void init() {
//        back = hardwareMap.get(DcMotorEx.class, "back");
//        misumi = hardwareMap.get(DcMotorEx.class, "misumi");
//
//        claw = hardwareMap.get(CRServo.class, "claw");
//        wrist = hardwareMap.get(CRServo.class, "wrist");
//        scorer = hardwareMap.get(CRServo.class, "scorer");
//        linearWrist = hardwareMap.get(CRServo.class, "linearWrist");
//
//        back.setDirection(DcMotorSimple.Direction.REVERSE);
//        misumi.setDirection(DcMotorSimple.Direction.FORWARD);
        Timer pathTimer = new Timer();
        Constants.setConstants(FConstants.class, LConstants.class);
        }

    @Override
    public void loop() {
        follower.update();
//        telemetry.addData("Misumi Slide Position", misumi.getCurrentPosition());
//        telemetry.addData("Linear Slide Position", back.getCurrentPosition());
//        telemetry.addData("Misumi Slide Power", back.getPower());
//        telemetry.addData("Linear Slide Power", back.getPower());
//        telemetry.addData("Claw Power", claw.getPower());
//        telemetry.addData("Wrist Power", wrist.getPower());
//        telemetry.addData("Swing Arm Power", linearWrist.getPower());
//        telemetry.addData("Swing Arm Servo", scorer.getPower());
        telemetry.addData("X", follower.getPose().getX());
        telemetry.addData("Y", follower.getPose().getY());
        telemetry.addData("Heading in Degrees", Math.toDegrees(follower.getPose().getHeading()));
        telemetry.update();
    }
}
