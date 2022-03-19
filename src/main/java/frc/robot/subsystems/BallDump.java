package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallDump extends SubsystemBase {

    // motor controller
    WPI_TalonSRX ballDumpMotor = new WPI_TalonSRX(1);


    // Need two limit switches
    DigitalInput toplimitSwitch = new DigitalInput(0);
    DigitalInput bottomlimitSwitch = new DigitalInput(1);

    public BallDump() {
        ballDumpMotor.configFactoryDefault();
    }

    // Map movement to a button
      // Need method to move (need to specify a speed for the bucket movement)
      // Need 3 position (one limit, the other limit, some point between)
    public void moveBallDump(Joystick joystick) {

        // One button will go to one limit switch (6)
        boolean moveBucketAllTheWayUp = joystick.getRawButton(3);

        // One button will go to other limit switch (4)
        boolean moveBucketAllTheWayDown = joystick.getRawButton(1);

        if(moveBucketAllTheWayUp) {
            if (toplimitSwitch.get()) {
                // We are going up and top limit is tripped so stop
                ballDumpMotor.set(0);
            } else {
                // We are going up but top limit is not tripped so go at normal speed
                ballDumpMotor.set(0.25);
            }
        }

        if(moveBucketAllTheWayDown) {
            if (bottomlimitSwitch.get()) {
                // We are going up and top limit is tripped so stop
                ballDumpMotor.set(0);
            } else {
                // We are going up but top limit is not tripped so go at normal speed
                ballDumpMotor.set(-0.25);
            }
        }

        // One button to move up while pushed down (6)
        boolean moveBucketUp = joystick.getRawButtonPressed(6);
        boolean stopBucketUp = joystick.getRawButtonReleased(6);

        // One button to move down while pushed down (4)
        boolean moveBucketDown = joystick.getRawButtonPressed(4);
        boolean stopBucketDown = joystick.getRawButtonReleased(4);

        if (moveBucketUp) {
            ballDumpMotor.set(0.25);
        } else if(stopBucketUp) {
            ballDumpMotor.set(0.0);
        }

        if (moveBucketDown) {
            ballDumpMotor.set(-0.25);
        } else if(stopBucketDown) {
            ballDumpMotor.set(0.0);
        }
    }
}