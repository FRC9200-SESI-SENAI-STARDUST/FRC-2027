package first.robot.mechanisms;

import org.wpilib.command3.Command;
import org.wpilib.command3.Mechanism;
import org.wpilib.math.system.DCMotor;
import org.wpilib.math.system.Models;
import org.wpilib.simulation.FlywheelSim;
import org.wpilib.telemetry.Telemetry;

public class Intake implements Mechanism   {

    private double voltageAplicada = 0;

    private final DCMotor motor_coleta = DCMotor.getKrakenX60(1);

    private final FlywheelSim flywheelSim =
        new FlywheelSim( Models.flywheelFromPhysicalConstants(motor_coleta, 0.004, 1.0), motor_coleta);
    
    public Intake () {}

    private void setarVoltage(double voltage) {
        voltageAplicada = Math.max(-12.0, Math.min(12.0, voltage));
    }


    private void pararMotor() {
        voltageAplicada = 0.0;
    }

    public double pegarRPM() {
        return flywheelSim.getAngularVelocity() * 60 / (2.0 * Math.PI);
    }

    public void simulationPeriodic() {
        flywheelSim.setInputVoltage(voltageAplicada);

        flywheelSim.update(0.020);

        Telemetry.log("Intake/Coletor/RPM", pegarRPM());
        
        Telemetry.log("Intake/Coletor/Voltage", voltageAplicada);
    }

    public Command girar() {

        return runRepeatedly(() -> {
            setarVoltage(6.0);
        }).whenCanceled(this::pararMotor).named("Shooter Spin");
    }
}
