package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class BallDump extends SubsystemBase {

    // motor controller
    WPI_VictorSPX ballDumpMotor = new WPI_VictorSPX(5);


    public BallDump() {
        ballDumpMotor.configFactoryDefault();
    }

    // Map movement to a button
      // Need method to move (need to specify a speed for the bucket movement)
      // Need 3 position (one limit, the other limit, some point between)
    public void moveBallDump(Joystick joystick) {


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