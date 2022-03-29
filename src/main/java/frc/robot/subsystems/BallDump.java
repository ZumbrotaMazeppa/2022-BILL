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

        if (joystick.getRawButton(4)) {
            ballDumpMotor.set(-0.25);
        } else {
            ballDumpMotor.set(0.0);
        }

        if (joystick.getRawButton(3)) {
            ballDumpMotor.set(-0.25);
        } else {
            ballDumpMotor.set(0.0);
        }
    }
}