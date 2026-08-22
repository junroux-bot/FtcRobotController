package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class ftcmiancode extends OpMode {

    @Override
    public void init() {
        telemetry.addData("hello","world");
        double motorspeed = 0.75;
        if (motorspeed>0){
            telemetry.addData("motor direction","forward");
        }else {
            telemetry.addData("motot directon","backward");
        }

    }

    @Override
    public void loop() {

    }
}
