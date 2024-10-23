// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.opencv.core.Core;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.core.CoreTalonFX;
import com.ctre.phoenix6.signals.ControlModeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  private TalonFX m_rightPrimary = new TalonFX(DriveConstants.kRightPrimaryID);
  private TalonFX m_rightSecondary = new TalonFX(DriveConstants.kRightSecondaryID);
  private TalonFX m_leftPrimary = new TalonFX(DriveConstants.kLeftPrimaryID);
  private TalonFX m_leftSecondary = new TalonFX(DriveConstants.kLeftSecondaryID);
  private Follower m_leftFollower = new Follower(DriveConstants.kLeftPrimaryID, DriveConstants.kLeftOpposeMasterDirection);
  private Follower m_rightFollower = new Follower(DriveConstants.kRightPrimaryID, DriveConstants.kRightOpposeMasterDirection);
  private final Field2d m_field = new Field2d();
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_leftSecondary.setControl(m_leftFollower);
    m_rightSecondary.setControl(m_rightFollower);
  }

  public void setRightSpeed(double rightSpeed){
    m_rightPrimary.set(rightSpeed);
  }

  public void setLeftSpeed(double leftSpeed){
    m_leftPrimary.set(leftSpeed);
  }

  public void setIdleMode(NeutralModeValue idleModeValue){
    m_leftPrimary.setNeutralMode(idleModeValue);
    m_leftSecondary.setNeutralMode(idleModeValue);
    m_rightPrimary.setNeutralMode(idleModeValue);
    m_rightSecondary.setNeutralMode(idleModeValue);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Shuffleboard.getTab("Elevator")
      .add("Encoder Position", 5);
    Shuffleboard.getTab("Elevator")
      .add("Top Limit Switch", true);
    Shuffleboard.getTab("Elevator")
      .add("Bottom Limit Switch", false);
    Shuffleboard.getTab("Intake")
      .add("Motor Temperature", 45);
    Shuffleboard.getTab("Intake")
      .add("Output Current", 23);
    Shuffleboard.getTab("Intake")
      .add("Limit Switch", true);
    Shuffleboard.getTab("Pivot")
      .add("Motor Current x4 motors", 34);
    Shuffleboard.getTab("Pivot")
      .add("Forward Limit Switch", false);
    Shuffleboard.getTab("Pivot")
      .add("Backward Limit Switch", false);
    Shuffleboard.getTab("Shooter")
      .add("Motor Temperature", 65);
    Shuffleboard.getTab("Shooter")
      .add("Motor Current", 54);
    Shuffleboard.getTab("Swerve")
      .add("Wheel Angles x4", 12);
    Shuffleboard.getTab("Swerve")
      .add("Motor Total Current", 32);
    Shuffleboard.getTab("Swerve")
      .add("Pose X", 3.4);
    Shuffleboard.getTab("Swerve")
      .add("Pose Y", 2.4);
    Shuffleboard.getTab("Swerve")
      .add("Field", m_field);
    Shuffleboard.getTab("Swerve")
      .add("Drive velocity x4 motors", 35);
    Shuffleboard.getTab("Swerve")
      .add("Drive motor position x4 motors", 3);
    Shuffleboard.getTab("Swerve")
      .add("Turn motor position x4", 56);
    Shuffleboard.getTab("Swerve")
      .add("Reset encoders button", false);
    Shuffleboard.getTab("Swerve")
      .add("Reset heading button", true);
    Shuffleboard.getTab("Wrist")
      .add("Encoder Position", 34.5);
    Shuffleboard.getTab("Wrist")
      .add("Forward Limit Switch", false);
    Shuffleboard.getTab("Wrist")
      .add("Backward Limit Switch", true);
    Shuffleboard.getTab("Wrist")
      .add("Motor Current", 23.4);
  }
}
