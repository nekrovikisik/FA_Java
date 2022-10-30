package HW1_3_figures;

public class Ball extends SolidOfRevolution {
    Ball(double radius){
        super(radius,Math.PI*Math.pow(radius,3)*4/3);
    }

}
