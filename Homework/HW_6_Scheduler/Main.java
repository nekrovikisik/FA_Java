package HW_6_Scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static String enterCorrectDate() {
        Scanner sc = new Scanner(System.in);
        boolean flg_correct = false;
        String myDeadLine = null;
        while (!flg_correct) {
            myDeadLine = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            try {
                Date my_date = formatter.parse(myDeadLine);
                flg_correct = true;
            } catch (ParseException e) {
                System.out.println("Введите корректную дату в формате dd-mm-yyyy");
            }
        }
        return myDeadLine;
    }

    public static void main(String[] args) {
        ArrayList task_array = new ArrayList<>();
        Scheduler myScheduler = new Scheduler(task_array);
        Task new_task1 = myScheduler.create();
        task_array.add(new_task1);
        Task new_task2 = myScheduler.create();
        task_array.add(new_task2);
        Task new_task3 = myScheduler.create();
        task_array.add(new_task3);

        System.out.println("_______________________________________________________________");
        myScheduler.editTask();
//        myScheduler.showTasks(myScheduler.filterByIsDone());
    }
}
