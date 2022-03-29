// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  WPI_VictorSPX m_rearRight = new WPI_VictorSPX(1);
    WPI_VictorSPX m_frontRight = new WPI_VictorSPX(2);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);

    WPI_VictorSPX m_rearLeft = new WPI_VictorSPX(3);
    WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(4);
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
        m_drive.arcadeDrive(-joystick.getY() * 0.6, joystick.getTwist() * 0.5);
    } else {
        m_drive.arcadeDrive(-joystick.getY() * 0.80, joystick.getTwist() * 0.65);
    }
  }
  public void driveWithAuton(double speed, long drivetime) {
    m_drive.arcadeDrive(speed, 0);
    long targettime = System.currentTimeMillis() +  drivetime;
    while(System.currentTimeMillis() < targettime);
    m_drive.arcadeDrive(0, 0);

    m_drive.arcadeDrive(speed, 0);
    long hittime = System.currentTimeMillis() +  drivetime;
    while(System.currentTimeMillis() < hittime);
  }

  public void stop() {
    m_drive.arcadeDrive(0, 0);
  }
}

  