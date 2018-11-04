package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

//*In theory* this should also be compatible with tank drive.

@TeleOp(name ="WestCoastDriveLite", group ="TeleOp")
public class WestCoastDriveUltraLite extends LinearOpMode{
    public static final double SPEED = 0.5;

    /* Declare OpMode members. */
    HardwareConfigUltraLite robot           = new HardwareConfigUltraLite();   //Configs hardware


    @Override
    public void runOpMode () throws InterruptedException
    {

        robot.init(hardwareMap);
        //loads hardwareMap

        double drive;
        double turn;
        double leftValue;
        double rightValue;

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Shock drone going live!");
        telemetry.update();

        waitForStart();

        telemetry.addData("Say", "ASSUMING DIRECT CONTROL");
        telemetry.update();

        while(opModeIsActive())
        {
            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            // This way it's also easy to just drive straight, or just turn.
            drive = -gamepad1.left_stick_y;
            turn  =  gamepad1.right_stick_x;

            // Combine drive and turn for blended motion.
            leftValue  = -(drive + turn);
            rightValue = -(drive - turn);

            //sets maxes for each value
            leftValue = Range.clip(leftValue, -SPEED, SPEED);
            rightValue = Range.clip(rightValue, -SPEED, SPEED);



            robot.motorFL.setPower(leftValue);
            robot.motorFR.setPower(rightValue);

            telemetry.addData("Say", "Left: "+ leftValue+"        Right: "+ rightValue+"\n" +
                    "Power: "+ drive +"        Turn: "+turn);
            telemetry.update();

            //idle();
        }
    }
}

