/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainCommand;


public class ChassisSubsystem extends Subsystem {

  //stating motor controllers and ports associating with it
  private VictorSP left1 = new VictorSP(RobotMap.left1port);
  private VictorSP left2 = new VictorSP(RobotMap.left2port);
  private VictorSP left3 = new VictorSP(RobotMap.left3port); 

  private VictorSP right1 = new VictorSP(RobotMap.right1port); 
  private VictorSP right2 = new VictorSP(RobotMap.right2port);
  private VictorSP right3 = new VictorSP(RobotMap.right3port);

  //grouping 
  public SpeedControllerGroup leftSide = new SpeedControllerGroup(left1, left2, left3);
  public SpeedControllerGroup rightSide = new SpeedControllerGroup(right1, right2, right3); 

  //setting inversions
  public ChassisSubsystem(){
    left1.setInverted(false);
    left2.setInverted(false);
    left3.setInverted(true);
    right1.setInverted(false);
    right2.setInverted(false);
    right3.setInverted(true);
  } 
  //method for tank-drive driving style
  public void tankDrive(double speed){
    leftSide.set(speed);
    rightSide.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DrivetrainCommand());
  }
}