package Task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 2");
        Mercedes mers = new Mercedes("red", 220, 120, "auto", 5000000, 2020);
        Toyota toyota = new Toyota("white", 180, 80, "auto", 2000000,5);
        int max_capacity = 2;
        Car[] my_cars = new Car[max_capacity];
        my_cars[0] = mers;
        my_cars[1] = toyota;
        try {
            for (int i = 0; i < max_capacity; i++) {
                System.out.println(my_cars[i]);
            }
        }
        catch (Exception e){
            System.out.println("Невозможно продать гараж в консоли.");
        }
        Garage garage = new Garage(my_cars, max_capacity);
    }
}
