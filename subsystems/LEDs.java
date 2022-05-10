package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extra.led;
import java.lang.Thread;

public class LEDs extends SubsystemBase{
    private static AddressableLEDBuffer buffer;
    private static AddressableLED lights;

    public LEDs(){
        lights = new AddressableLED(5);
        buffer = new AddressableLEDBuffer(60);
        lights.setLength(buffer.getLength());
        lights.start();
    }

    public static void changeColor(led LED){
      for(int i = 0; i < buffer.getLength(); i++){
          buffer.setRGB(i, LED.getR(), LED.getG(), LED.getB());
          lights.setData(buffer);
      }
  }

    public static void turnOff(AddressableLED lights, AddressableLEDBuffer buffer){
      for(int i = 0; i < buffer.getLength(); i++){
          buffer.setRGB(i, 0, 0, 0);
      }
  }

    public static void rainbow(){
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

      public static void wave(){
        turnOff(lights, buffer);
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

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
