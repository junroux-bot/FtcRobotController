package org.firstinspires.ftc.teamcode.Main_Code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class test extends OpMode {
    Motor_Setup Drive = new Motor_Setup();
    IMU_Setup imu = new IMU_Setup();
    limelight_Setup camera = new limelight_Setup();

    @Override
    public void init() {
        Drive.init(hardwareMap,"fl","bl","fr","br");
        imu.intt(hardwareMap);
        camera.camera_init(hardwareMap,"limelight",8);
        camera.start();

    }

    @Override
    public void loop() {
        Drive.drive(gamepad1.left_stick_y,gamepad1.left_stick_x, gamepad1.right_stick_x,gamepad1);
        telemetry.addData("distance",camera.get_DistanceFrom(camera.GetCamera_data("ta")));

    }
}
