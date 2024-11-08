// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class MoveForTime extends Command {
  private Drivetrain m_drivetrain;
  private double m_speed;
  private Timer m_timer = new Timer();
  private double m_amountOfTime;
  /** Creates a new MoveForTime. */
  public MoveForTime(Drivetrain drivetrain, double speed, double amountOfTime) {
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_amountOfTime = amountOfTime;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.

  private double timeStarted;
  
  @Override
  public void initialize() {
    m_timer.start();
    timeStarted = m_timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.setRightSpeed(m_speed);
    m_drivetrain.setLeftSpeed(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setRightSpeed(0);
    m_drivetrain.setLeftSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_timer.get() - timeStarted >= m_amountOfTime) {
      m_drivetrain.setRightSpeed(0);
      m_drivetrain.setLeftSpeed(0);
      return true;
    }
      return false;
  }
}
