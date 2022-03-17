// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  WPI_TalonSRX m_rearRight = new WPI_TalonSRX(2);
    WPI_TalonSRX m_frontRight = new WPI_TalonSRX(1);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);

    WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(4);
    WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(3);
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);

    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  
  public DriveTrain() {

    m_frontLeft.configFactoryDefault();
    m_frontRight.configFactoryDefault();
    m_rearLeft.configFactoryDefault();
    m_rearRight.configFactoryDefault();
    m_right.setInverted(true);
  }

  public void driveWithJoystick(Joystick joystick) {
    double throttle = -joystick.getThrottle();
    if (throttle < 0.5) {
        m_drive.arcadeDrive(joystick.getY() * 0.65, joystick.getTwist() * 0.5);
    } else {
        m_drive.arcadeDrive(joystick.getY(), joystick.getTwist() * 0.65);
    }
}
}

  