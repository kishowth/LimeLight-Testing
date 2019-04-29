/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DrivetrainCommand extends Command {
  public DrivetrainCommand() {
    requires(Robot.chassisSubsystem);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    double LeftSpeed = Robot.m_oi.getLeftSpeed();
    double RightSpeed = Robot.m_oi.getRightSpeed();
    
    Robot.chassisSubsystem.leftSide.set(LeftSpeed);
    Robot.chassisSubsystem.rightSide.set(RightSpeed);
    


  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {}


  @Override
  protected void interrupted() {}
}
