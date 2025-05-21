package bot.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Practice TeleOp")
public class TeleV1 extends OpMode {

    // Drivetrain motors
    private DcMotor fr, fl, br, bl;

    // Slide motors
    private DcMotor back, misumi;

    // Servos
    private Servo servo1, servo2;

    @Override
    public void init() {
        // Initialize motors
        fr = hardwareMap.get(DcMotor.class, "fr");
        fl = hardwareMap.get(DcMotor.class, "fl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl = hardwareMap.get(DcMotor.class, "bl");

        back = hardwareMap.get(DcMotor.class, "back");
        misumi = hardwareMap.get(DcMotor.class, "misumi");

        // Initialize servos
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");

        // Reverse left motors
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);

        // Adjust slide motor directions if needed
        back.setDirection(DcMotorSimple.Direction.REVERSE);
        misumi.setDirection(DcMotorSimple.Direction.REVERSE);

        // Reset encoders
        DcMotor[] motors = {fr, fl, br, bl, back, misumi};
        for (DcMotor motor : motors) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    @Override
    public void loop() {
        // Gamepad1: drivetrain control (mecanum)
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double flPower = y + x + rx;
        double blPower = y - x + rx;
        double frPower = y - x - rx;
        double brPower = y + x - rx;

        double max = Math.max(Math.abs(flPower), Math.max(Math.abs(blPower), Math.max(Math.abs(frPower), Math.abs(brPower))));
        if (max > 1.0) {
            flPower /= max;
            blPower /= max;
            frPower /= max;
            brPower /= max;
        }

        fl.setPower(flPower);
        bl.setPower(blPower);
        fr.setPower(frPower);
        br.setPower(brPower);

        // Gamepad2: slide control
        double slidePower = -gamepad2.left_stick_y;
        back.setPower(slidePower);
        misumi.setPower(slidePower);

        // Servos controlled by buttons
        if (gamepad2.a) {
            servo1.setPosition(1.0);
            servo2.setPosition(1.0);
        } else if (gamepad2.b) {
            servo1.setPosition(0.0);
            servo2.setPosition(0.0);
        }

        // Telemetry for encoders and servo positions
        telemetry.addData("FL Encoder", fl.getCurrentPosition());
        telemetry.addData("FR Encoder", fr.getCurrentPosition());
        telemetry.addData("BL Encoder", bl.getCurrentPosition());
        telemetry.addData("BR Encoder", br.getCurrentPosition());
        telemetry.addData("Back Slide Encoder", back.getCurrentPosition());
        telemetry.addData("Misumi Slide Encoder", misumi.getCurrentPosition());
        telemetry.addData("Servo1 Pos", servo1.getPosition());
        telemetry.addData("Servo2 Pos", servo2.getPosition());
        telemetry.update();
    }
}
