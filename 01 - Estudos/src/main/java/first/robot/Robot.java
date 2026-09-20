// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import org.wpilib.command3.Scheduler;
import org.wpilib.command3.button.CommandGamepad;
import org.wpilib.command3.button.CommandXboxController;
import org.wpilib.framework.OpModeRobot;
import first.robot.constants.DriverConstants;
import first.robot.mechanisms.Intake;


public class Robot extends OpModeRobot {

  public final Intake intake = new Intake();

  public CommandXboxController controller = new CommandXboxController(0);

  public Robot() {}

  @Override
  public void robotPeriodic() {
    Scheduler.getDefault().run();
  }

  @Override
  public void simulationPeriodic() {
    intake.simulationPeriodic();
  }
}
