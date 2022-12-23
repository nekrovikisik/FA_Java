package HW_6_Scheduler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scheduler allTasks = new Scheduler(new ArrayList<>());
//        while ()
        allTasks.create();
        System.out.println(allTasks.toString());
    }
}
