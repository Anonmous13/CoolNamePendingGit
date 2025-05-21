package bot.opmode.TeleOp;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Pose2dDual;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import static java.lang.Math.PI;
import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@TeleOp(name = "Pedro Pathing TeleOp")
public class PedroTeleOp extends OpMode {
    private double wheelCircumference = Math.PI * 100;
    private Follower follower;
    private final Pose startPose = new Pose(0, 0, 0);

    private DcMotorEx back, misumi;
    private CRServo wrist, hanger, intake, outtake;

    private enum State {
        HOME,
        INTAKE,
        OUTTAKE
    }
    State state = State.HOME;

    @Override
    public void init() {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        follower.setStartingPose(startPose);

        // Initialize slide motors
        back = hardwareMap.get(DcMotorEx.class, "back");
        misumi = hardwareMap.get(DcMotorEx.class, "misumi");

        // Set directions as needed
        back.setDirection(DcMotorSimple.Direction.REVERSE);
        misumi.setDirection(DcMotorSimple.Direction.FORWARD);

        // Reset and set to RUN_USING_ENCODER for slides
        back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        misumi.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        misumi.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        follower.startTeleopDrive();
    }

    @Override
    public void loop() {
        // Drivetrain control via Pedro Pathing follower
        follower.setTeleOpMovementVectors(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, true);
        follower.update();

        // Slide control with gamepad2 left stick Y axis
        double slidePower = -gamepad2.left_stick_y; // push up to go up
        back.setPower(slidePower);
        misumi.setPower(slidePower);

        // Telemetry
        telemetry.addData("X", follower.getPose().getX());
        telemetry.addData("Y", follower.getPose().getY());
        telemetry.addData("Heading (deg)", Math.toDegrees(follower.getPose().getHeading()));
        telemetry.addData("Back Slide Encoder", back.getCurrentPosition());
        telemetry.addData("Misumi Slide Encoder", misumi.getCurrentPosition());
        telemetry.update();
    }

    @Override
    public void stop() {
    }
}
