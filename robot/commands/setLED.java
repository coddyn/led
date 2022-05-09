package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDs;

public class setLED extends CommandBase{
    private final LEDs led;
    public setLED(LEDs light){
        led = light;
    }
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      
  }
}
