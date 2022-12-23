package HW_6_Scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
    static ArrayList<Task> allTasks = new ArrayList();

    public Scheduler(ArrayList allTasks) {
        this.allTasks = allTasks;
    }
//создание задачи
//    private void create(){ -- потом сделаю приватным, щас тест
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название задачи: ");
        String title = sc.nextLine();
        System.out.print("\nВведите краткое описание задачи: ");
        String description = sc.nextLine();
        System.out.print("\nВведите дату выполнения задачи: ");
        String endDate = sc.nextLine();
        Task task_ = new Task(title, description, endDate, false);
        allTasks.add(task_);
        System.out.println("Task added");
    }

    //удаление задачи по id
    public void deleteTask(int id) {
        allTasks.remove(id);
        System.out.println("Задача удалена");
    }

    private boolean findTask(int id) {
        for (int i = 0; i < allTasks.size(); i++) {
            Task this_task = allTasks.get(i);
            if (this_task.getId() == id)
                return true;
        }
        return false;
    }

        // TODO: обработка исключений в файле с вспомогательными функциями.
    public void editTask(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Какую задачу вы хотите отредактировать?\n Введите ее ID. ");
            int editedTask_ID = -1; //ID таска, который будет изменен
            Task this_task = null; // таск, который будет изменен
            String entityToEdit = ""; // что менять? тайтл, описание, дедлайн,
            while (editedTask_ID == -1) {
                try {
                    editedTask_ID = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Вы ввели фигню. Введите число.");
                }
            }
            while (!findTask(editedTask_ID)) {
                System.out.println("Задания с таким номером нет. \n Доступные задания:");
                for (int i = 0; i < allTasks.size(); i++) {
                    this_task = allTasks.get(i);
                    System.out.println("Задача id=" + this_task.getId() + ": " + this_task.getTitle());
                }
                System.out.println("Что вы хотите отредактировать: \n Нажмите"+
                        "1 - если название"+
                        "2 - если описание"+
                        "3 - если дедлайн"+
                        "4 - если факт выполнения"
                );
                int editSmthID = -1;
                while (editSmthID == -1) {
                    try {
                        editSmthID = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        System.out.println("Вы ввели фигню. Введите число.");
                    }


                    switch (editSmthID){
                        case 1:
                            entityToEdit = "название";
                            System.out.println("Введите "+ entityToEdit);
                            this_task.setTitle(sc.nextLine());
                            System.out.println(entityToEdit + " изменено");
                        case 2:
                            entityToEdit = "описание";
                            System.out.println("Введите "+ entityToEdit);
                            this_task.setTitle(sc.nextLine());
                            System.out.println(entityToEdit + " изменено");
                        case 3:
                            entityToEdit = "факт выполнения";
                            System.out.println("Введите "+ entityToEdit);
                            this_task.setTitle(sc.nextLine());
                            System.out.println(entityToEdit + " изменен");
                        case 4:
                            entityToEdit = "дедлайн";
                            System.out.println("Введите "+ entityToEdit);
                            this_task.setTitle(sc.nextLine());
                            System.out.println(entityToEdit + " изменено");


                    }
                }
                }

            }




        @Override
    public String toString() {
        String allTasks_str = "";
        for (Task task : allTasks)
            allTasks_str += task.toString();
        return allTasks_str;
    }

}
