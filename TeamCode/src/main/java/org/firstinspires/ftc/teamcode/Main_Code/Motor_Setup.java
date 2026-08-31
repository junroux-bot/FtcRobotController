package org.firstinspires.ftc.teamcode.Main_Code;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motor_Setup {
    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;

    public void init(HardwareMap hwmap, String fleft_motor, String bleft_motor, String fright_motor, String bright_motor) {
        frontLeftMotor = hwmap.dcMotor.get(fleft_motor);
        backLeftMotor = hwmap.dcMotor.get(bleft_motor);
        frontRightMotor = hwmap.dcMotor.get(fright_motor);
        backRightMotor = hwmap.dcMotor.get(bright_motor);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private double lastLeftRumble = 0.0;
    private double lastRightRumble = 0.0;
    public void drive(double y, double x, double rx, Gamepad gamepad) {
        double y_axis = -y;
        double x_axis =x* 1.1;
        double trun =-rx;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y_axis + x_axis + trun) / denominator;
        double backLeftPower = (y_axis - x_axis + trun) / denominator;
        double frontRightPower = (y_axis - x_axis - trun) / denominator;
        double backRightPower = (y_axis + x_axis - trun) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);


        if (gamepad != null) {
            double leftvibration = ((Math.abs(frontLeftPower) + Math.abs(backLeftPower)) / 2.0) * 0.7;
            double rightvibration = ((Math.abs(frontRightPower) + Math.abs(backRightPower)) / 2.0) * 0.7;

            if (leftvibration < 0.15) leftvibration = 0.0;
            if (rightvibration < 0.15) rightvibration = 0.0;

            if (Math.abs(leftvibration - lastLeftRumble) > 0.05 || Math.abs(rightvibration - lastRightRumble) > 0.05) {
                if (leftvibration > 0 || rightvibration > 0) {
                    gamepad.rumble(leftvibration, rightvibration, Gamepad.RUMBLE_DURATION_CONTINUOUS);
                } else {
                    gamepad.stopRumble();
                }
                lastLeftRumble = leftvibration;
                lastRightRumble = rightvibration;
            }
        }
    }
}

// Motor_control.init(hardwareMap,"fleft","bleft","fright","bright");

// Motor_control.drive(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x);
