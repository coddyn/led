package frc.robot.extra;

public class led {   
        private static int r;
        private static int g;
        private static int b;
        public led(int red, int green, int blue){
            r = red;
            g = green;
            b = blue;
        }
        public int getR(){
            return r;
        }
        public int getG(){
            return g;
        }
        public int getB(){
            return b;
        }
}
