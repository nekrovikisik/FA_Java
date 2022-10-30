package HW1_3_figures;

public class Shape {
    /**
     * Этот класс отвечает за объем. .
     * Box,SolidOfRevolution, Pyramid - наследники.
     */
    private  double volume;

    public Shape(double volume){
        this.volume = volume;
    }
    public double getVolume(){
        return volume;
    }
}