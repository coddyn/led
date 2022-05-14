package frc.robot.util;

public class led {   

    private double color;
    private boolean pulse;

    private led(double color, boolean pulse){
        this.color = color;
        this.pulse = pulse;
    }

    private led(double color){
        this.color = color;
    }

    public led pulse(){
        return new led(this.color, true);
    }

    public double getValue(){
        return this.color;
    }

    public static final led RAINBOW = new led(-0.99);
    public static final led GREEN = new led(0.77);
    public static final led RED = new led(0.61);
    public static final led BLUE = new led(0.87);
}
