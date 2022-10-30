package HW1_3_figures;

public class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super( radius,Math.PI * radius * radius * height);
        this.height = height;
    }
}
