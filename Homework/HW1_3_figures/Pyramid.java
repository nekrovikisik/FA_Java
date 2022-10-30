package HW1_3_figures;

public class Pyramid extends Shape {
    /**
     * Данный класс наследуется от Shape и отвечает за пирамиды.
     * h,s - параметры высоты и площади пирамиды. Значение площади передается в Shape.
     */
    private double s;
    private double h;

    public Pyramid(double s,double h){

        super(h*s*4/3);
        System.out.println("Значение объекта - "+ h*s*4/3);
        this.s = s;
        this.h = h;
    }
}
