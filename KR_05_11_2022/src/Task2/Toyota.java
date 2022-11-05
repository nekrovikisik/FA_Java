package Task2;

public class Toyota extends Car{
    private final int year;
    public Toyota(String color, int maxSpeed, int currentSpeed, String box, int price, int year) {
        super(color, box, maxSpeed, currentSpeed, price);
        this.year = year;
    }
    @Override
    public  String getName(){
        return "Toyota";
    }
    public int getYear(){
        return this.year;
    }
}