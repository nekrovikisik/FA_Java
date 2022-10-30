package HW1_3_figures;

import java.util.ArrayList;

public class Box extends Shape {
    /**
     * Коробка-класс, проверяющая, достаточно ли места для добавления новых фигур.
     * Критерий -объем фигуры. now - состояние коробки по объему.
     * box - коробка, сюда добавляются фигуры.
     * add - который добавляет фигуру. Поступает shape на вход (объем фигуры).
     */
    private double now;
    private ArrayList<Shape> box = new ArrayList<Shape>();

    public Box(double now){
        super(now);
        this.now = now;
    }
    public boolean add(Shape shape){

        if (now >= shape.getVolume()){
            box.add(shape);
            now -= shape.getVolume();
            System.out.println("Состояние склада - "+ now);
            return true;
        }
        else{
            return false;
        }
    }
}
