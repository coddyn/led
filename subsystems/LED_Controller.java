package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.util.led;

public class LED_Controller extends SubsystemBase{
  public final PWMSparkMax LEDCONTROLLER;

  public LED_Controller(){
    this.LEDCONTROLLER = new PWMSparkMax(Constants.LEDPORT);
    //this.LEDCONTROLLER.setVoltage(5.0);
  }

  public void setColor(led color){
    //this.LEDCONTROLLER.setVoltage(5.0);
    this.LEDCONTROLLER.set(color.getValue());
  }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
