package HW1_3_figures;

public class SolidOfRevolution extends Shape {
    /**
     * Данный класс наследуется от Shape.
     * radius - параметр радиуса.
     */
    private double radius;

    public SolidOfRevolution(double radius,double volume){
        super(volume);
        System.out.println("Значение объекта - "+ volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
