package frc.robot.util;
import edu.wpi.first.wpilibj.Joystick;


public class allButtons extends Joystick{

  public allButtons(int port){
    super(port);
  }

  public static final int buttonX = 1;
  public static final int buttonA = 2; 
  public static final int buttonB = 3; 
  public static final int buttonY = 4; 
  public static final int shoulderLeft = 5;
  public static final int shoulderRight = 6; 
  public static final int triggerLeft = 7;
  public static final int triggerRight = 8; 
}
