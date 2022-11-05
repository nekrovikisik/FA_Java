package Task2;

public class Mercedes extends Car{
    private final int year;
    public Mercedes(String color, int maxSpeed, int currentSpeed, String box, int price, int year) {
        super(color, box, maxSpeed, currentSpeed, price);
        this.year = year;
    }
    @Override
    public  String getName(){
        return "Mercedes";
    }
    public int getYear(){
        return this.year;
    }
}