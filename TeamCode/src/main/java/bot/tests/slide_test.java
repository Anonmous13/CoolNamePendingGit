package bot.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Slide TeleOp", group = "Linear Opmode")
public class slide_test extends LinearOpMode {

    private DcMotor slide;

    @Override
    public void runOpMode() {
        // Map the motor
        slide = hardwareMap.get(DcMotor.class, "slide");

        // Set motor direction if needed
        slide.setDirection(DcMotor.Direction.REVERSE);

        // Set run mode (important!)
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Optional: Set zero power behavior to BRAKE
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addLine("Slide TeleOp Ready");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double power = -gamepad1.left_stick_y;
            slide.setPower(power);
            slide.setTargetPosition(520);

            telemetry.addData("Slide Power", power);
            telemetry.addData("Slide Encoder Position", slide.getCurrentPosition());
            telemetry.update();
        }


    }

}
