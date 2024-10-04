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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  private TalonFX m_rightPrimary = new TalonFX(DriveConstants.kRightPrimaryID);
  private CoreTalonFX m_rightSecondary = new CoreTalonFX(DriveConstants.kRightSecondaryID);
  private TalonFX m_leftPrimary = new TalonFX(DriveConstants.kLeftPrimaryID);
  private CoreTalonFX m_leftSecondary = new CoreTalonFX(DriveConstants.kLeftSecondaryID);
  private Follower m_leftFollower = new Follower(DriveConstants.kLeftPrimaryID, DriveConstants.kLeftOpposeMasterDirection);
  private Follower m_rightFollower = new Follower(DriveConstants.kRightPrimaryID, DriveConstants.kRightOpposeMasterDirection);
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
    // m_leftSecondary.setNeutralMode(idleModeValue);
    m_rightPrimary.setNeutralMode(idleModeValue);
    // m_rightSecondary.setControl(idleModeValue);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
