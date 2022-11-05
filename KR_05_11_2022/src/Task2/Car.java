package Task2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Car {
    private final String color, type_box;
    private final int maxSpeed;
    private int currentSpeed;
    public int price;
    public Car(String color,String type_box, int maxSpeed, int currentSpeed, int price){
        this.color = color;
        this.type_box = type_box;
        this.maxSpeed = maxSpeed;
        this.currentSpeed =currentSpeed;
        this.price = price;
    }
    public void start() {
        //считываем скорость с клавиатуры и прибавляем при возможности
        Scanner scan = new Scanner(System.in);
        int speed = scan.nextInt();
        accelerate(speed);
    }
    public void stop() {
        currentSpeed = 0;
    }
    private void accelerate(int speed) {
        if (speed + currentSpeed <= maxSpeed)
            currentSpeed = speed + currentSpeed;
    }
    public  String getName(){
        return "Car";
    }
    @Override
    public String toString(){
        return String.format("color = %s, type_box = %s, maxSpeed = %d, currentSpeed = %d, price = %d", color, type_box,maxSpeed,currentSpeed,price);
    }
    /*
    public static void main(String[] args) {
        System.out.println("Задача 2");
        Audi audi = new Audi("red", 220, 120, "auto", 5000000, 2020);
        Toyota toyota = new Toyota("white", 180, 80, "auto", 2000000,5);
        Map<Car, Integer> map = new HashMap<>();
        map.put(audi, 1);
        map.put(toyota, 1);
        System.out.println(map);
        Garage garage = new Garage(map, 2);
    }*/
}
