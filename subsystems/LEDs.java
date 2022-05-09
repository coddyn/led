package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extra.led;
import java.lang.Thread;
import frc.robot.RobotContainer;



public class LEDs extends SubsystemBase{
    private AddressableLEDBuffer buffer;
    private AddressableLED lights;
    private Joystick stick;

    public LEDs(){
        lights = new AddressableLED(5);
        buffer = new AddressableLEDBuffer(60);
        lights.setLength(buffer.getLength());
        led.changeColor(lights, buffer, Constants.green);
    }
    private void rainbow(){
        var m_rainbowFirstPixelHue = 1;
        for(var i = 0; i < buffer.getLength(); i++){
          final var hue = (m_rainbowFirstPixelHue + (i * 180 / buffer.getLength())) % 180;
          buffer.setHSV(i, hue, 255, 128);
          buffer.getLED(i);
        }
        m_rainbowFirstPixelHue += 3;
        m_rainbowFirstPixelHue %= 180;
        lights.setData(buffer);
      }
    private void setLed(){
        if(stick.getRawButtonPressed(1)){
          led.changeColor(lights, buffer, Constants.red);
        }
        else if(stick.getRawButtonPressed(2)){
          led.changeColor(lights, buffer, Constants.orange);
        }
        else if(stick.getRawButtonPressed(3)){
          led.changeColor(lights, buffer, Constants.yellow);
        }
        else if(stick.getRawButtonPressed(4)){
          led.changeColor(lights, buffer, Constants.green);
        }
        else if(stick.getRawButtonPressed(5)){
          led.changeColor(lights, buffer, Constants.blue);
        }
        else if(stick.getRawButtonPressed(6)){
          led.changeColor(lights, buffer, Constants.purple);
        }
        else if(stick.getRawButtonPressed(7)){
          //wave effect
            led.turnOff(lights, buffer);
            try{
              for(int i = 0; i < buffer.getLength(); i++){
              if(i % 6 == 0){  
              Thread.sleep(200);
              buffer.setRGB(i, Constants.red.getR(), Constants.red.getG(), Constants.red.getB());
              lights.setData(buffer);
              if(i >= 6){
                buffer.setRGB(i-6, 0, 0, 0);
              }
              }
              else if(i%6 == 1){
              Thread.sleep(200);
              buffer.setRGB(i, Constants.orange.getR(), Constants.orange.getG(), Constants.orange.getB());
              lights.setData(buffer);
              if(i >= 7){
                buffer.setRGB(i-6, 0, 0, 0);
              }
              }
              else if(i%6 == 2){
              Thread.sleep(200);
              buffer.setRGB(i, Constants.yellow.getR(), Constants.yellow.getG(), Constants.yellow.getB());
              lights.setData(buffer);
              if(i >= 8){
                buffer.setRGB(i-6, 0, 0, 0);
              }
              }
              else if(i%6 == 3){
              Thread.sleep(200);
              buffer.setRGB(i, Constants.green.getR(), Constants.green.getG(), Constants.green.getB());
              lights.setData(buffer);
              if(i >= 9){
                buffer.setRGB(i-6, 0, 0, 0);
              }
              }
              else if(i%6 == 4){
              Thread.sleep(200);
              buffer.setRGB(i, Constants.blue.getR(), Constants.blue.getG(), Constants.blue.getB());
              lights.setData(buffer);
              if(i >= 10){
                buffer.setRGB(i-6, 0, 0, 0);
              }
              }
              else if(i%6 == 5){
                Thread.sleep(200);
                buffer.setRGB(i, Constants.purple.getR(), Constants.purple.getG(), Constants.purple.getB());
                lights.setData(buffer);
                if(i >= 11){
                  buffer.setRGB(i-6, 0, 0, 0);
                }
              }
            }
            }
            catch(Exception e){
              System.out.print(e);
            }
    
          }
        else if(stick.getRawButtonPressed(8)){
          rainbow();
        }
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
