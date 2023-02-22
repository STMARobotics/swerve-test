package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.LEDSubsystem.Mode;

/**
 * Default LED command to make the LEDs dance or go yellow when holding a cone.
 */
public class DefaultLEDCommand extends CommandBase {

  private final LEDSubsystem ledSubsystem;
  private final BooleanSupplier hasCone;
  public DefaultLEDCommand(LEDSubsystem ledSubsystem, BooleanSupplier hasCone) {
    this.ledSubsystem = ledSubsystem;
    this.hasCone = hasCone;

    addRequirements(ledSubsystem);
  }

  @Override
  public void execute() {
    if (hasCone.getAsBoolean()) {
      ledSubsystem.setMode(Mode.HAS_CONE);
    } else {
      ledSubsystem.setMode(Mode.BLUE_GOLD);
    }
  }
  
  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
  
}