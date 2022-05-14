// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.color_commands.*;
import frc.robot.util.assignedButtons;

/** Add your docs here. */
public class Controller {
    private final XboxController controller;
    public Controller(XboxController controller){
        this.controller = controller;
    }

    public JoystickButton getButton(int button){
        return new JoystickButton(this.controller, button);
    }

    public void setButtons(){
        getButton(assignedButtons.blueButton)
        .whenPressed(new setBlue());

        getButton(assignedButtons.greenButton)
        .whenPressed(new setGreen());

        getButton(assignedButtons.rainbowButton)
        .whenPressed(new setRainbow());
        
        getButton(assignedButtons.redButton)
        .whenPressed(new setRed());
    }
}
