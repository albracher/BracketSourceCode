package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;


public class HardwareConfig {
    /* Public OpMode members. */
    public DcMotor motorFR = null;
    public DcMotor motorFL = null;
    public DcMotor motorRR = null;
    public DcMotor motorRL = null;
    public DcMotor slide = null;
    public DcMotor armL = null;
    public DcMotor armR = null;
    public DcMotor intakeL = null;
    public DcMotor intakeR = null;

    public static final double MID_SERVO = 0.5;//legacy code, can be removed
    public ColorSensor colorSensor;//legacy code, can be removed


    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public HardwareConfig() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        motorFR = hwMap.get(DcMotor.class, "motorFR");
        motorFL = hwMap.get(DcMotor.class, "motorFL");
        motorRR = hwMap.get(DcMotor.class, "motorRR");
        motorRL = hwMap.get(DcMotor.class, "motorRL");
        slide = hwMap.get(DcMotor.class, "slide");
        armL = hwMap.get(DcMotor.class, "armL");
        armR = hwMap.get(DcMotor.class, "armR");
        intakeL = hwMap.get(DcMotor.class, "intakeL");
        intakeR = hwMap.get(DcMotor.class, "intakeR");
        colorSensor = hwMap.colorSensor.get("color");//legacy code, can be removed


        motorFR.setDirection(DcMotor.Direction.REVERSE);// Set to REVERSE if using AndyMark motors
        motorFL.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        motorRR.setDirection(DcMotor.Direction.REVERSE);// Set to REVERSE if using AndyMark motors
        motorRL.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        slide.setDirection(DcMotor.Direction.FORWARD);//requires testing
        armL.setDirection(DcMotor.Direction.FORWARD);//requires testing
        armR.setDirection(DcMotor.Direction.REVERSE);//requires testing
        intakeL.setDirection(DcMotor.Direction.FORWARD);//requires testing
        intakeR.setDirection(DcMotor.Direction.REVERSE);//requires testing


        // Set all motors to zero power
        motorFR.setPower(0);
        motorFL.setPower(0);
        motorRR.setPower(0);
        motorRL.setPower(0);
        slide.setPower(0);
        armL.setPower(0);
        armR.setPower(0);
        intakeL.setPower(0);
        intakeR.setPower(0);


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //Not using encoders for non drive train to allow for more direct control of power.
        //Arm uses encoders to make sure motors stay in sync
        //same with intake
    }
}