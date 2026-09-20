package first.robot;

import org.wpilib.opmode.OpMode;
import org.wpilib.opmode.Teleop;

@Teleop
public class TeleopMode implements OpMode {

    public TeleopMode(Robot robot) {

        robot.controller
            .rightStick()
            .whileTrue(
                robot.intake
            );

    }
}