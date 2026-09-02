package org.firstinspires.ftc.teamcode.Main_Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class test2 extends OpMode {
    IMU_Setup imu = new IMU_Setup();
    Motor_Setup drive = new Motor_Setup();

    double forward,strafe,rotate;

    @Override
    public void init() {
        drive.init(hardwareMap,"fl","bl","fr","br");
        imu.intt(hardwareMap);

    }

    @Override
    public void loop() {
        drive.drive_field(-gamepad1.left_stick_y, gamepad1.left_stick_x,gamepad1.right_stick_x);


    }
}
