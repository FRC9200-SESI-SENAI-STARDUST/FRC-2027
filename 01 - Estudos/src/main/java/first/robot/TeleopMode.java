package first.robot;

import org.wpilib.opmode.OpMode;
import org.wpilib.opmode.Teleop;
import org.wpilib.telemetry.Telemetry;

@Teleop
public class TeleopMode implements OpMode {

    public TeleopMode(Robot robot) {

        robot.controller
            .rightStick()
            .whileTrue(
                robot.intake.girar()
            );
    }
}