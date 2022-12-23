package HW_6_Scheduler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static HW_6_Scheduler.Main.enterCorrectDate;

public class Scheduler {
    static ArrayList<Task> allTasks = new ArrayList();

    public Scheduler(ArrayList allTasks) {
        Scheduler.allTasks = allTasks;
    }

    //создание задачи
//    private void create(){ -- потом сделаю приватным, щас тест
    public Task create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название задачи: ");
        String title = sc.nextLine();
        System.out.print("\nВведите краткое описание задачи: ");
        String description = sc.nextLine();
        System.out.print("\nВведите дату выполнения задачи: ");
        String endDate = enterCorrectDate();
        Task task_ = new Task(title, description, endDate, false);
//        allTasks.add(task_);
        System.out.println("Task added");
        return task_;
    }

    //удаление задачи по id
    public void deleteTask(int id) {
        allTasks.remove(id);
        System.out.println("Задача удалена");
    }

    private boolean findTask(int id) {
        for (int i = 0; i < allTasks.size(); i++) {
            Task this_task = allTasks.get(i);
            if (this_task.getId() == id) return true;
        }
        return false;
    }

    // TODO: обработка исключений в файле с вспомогательными функциями.
    public void editTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Какую задачу вы хотите отредактировать?\n Введите ее ID. ");
        int editedTask_ID = -1; //ID таска, который будет изменен
        Task this_task = null; // таск, который будет изменен
        String entityToEdit = ""; // что менять? тайтл, описание, дедлайн,

        System.out.println("Что вы хотите отредактировать: \n Нажмите" + "1 - если название" + "2 - если описание" + "3 - если дедлайн" + "4 - если факт выполнения");
        int editSmthID = -1;
        while (editSmthID == -1) {
            try {
                int possible_task_id = Integer.parseInt(sc.nextLine());
                while (!findTask(possible_task_id)) {
                    System.out.println("Задания с таким номером нет. \n Доступные задания:");
                    for (int i = 0; i < allTasks.size(); i++) {
                        this_task = allTasks.get(i);
                        System.out.println("Задача id=" + this_task.getId() + ": " + this_task.getTitle());
                    }
                    possible_task_id = Integer.parseInt(sc.nextLine());
                }
                editSmthID = possible_task_id;

            } catch (NumberFormatException ex) {
                System.out.println("Вы ввели фигню. Введите число.");
            }


            switch (editSmthID) {
                case 1:
                    entityToEdit = "название";
                    System.out.println("Введите " + entityToEdit);
                    this_task.setTitle(sc.nextLine());
                    System.out.println(entityToEdit + " изменено");
                case 2:
                    entityToEdit = "описание";
                    System.out.println("Введите " + entityToEdit);
                    this_task.setDescription(sc.nextLine());
                    System.out.println(entityToEdit + " изменено");
                case 3:
                    entityToEdit = "факт выполнения";
                    System.out.println("Введите " + entityToEdit);
                    this_task.setisDone(!this_task.getisDone());
                    System.out.println(entityToEdit + " изменен на " + this_task.getisDone());
                case 4:
                    entityToEdit = "дедлайн";
                    System.out.println("Введите " + entityToEdit);
                    String newDeadline = enterCorrectDate();
                    System.out.println(entityToEdit + " изменен на " + newDeadline);


            }
        }
    }


    public ArrayList filterByIsDone() {
        ArrayList<Task> filteredTasks = filterTasks(1, "");

        return filteredTasks;
    }

    public ArrayList filterByIsNotDone() {
        ArrayList<Task> filteredTasks = filterTasks(2, "");
        return filteredTasks;
    }

    public ArrayList filterByStartDate() {
        System.out.println("Введите корректную дату начала таска в формате dd-mm-yyyy");
        String myStartDate = enterCorrectDate();
        ArrayList<Task> filteredTasks = filterTasks(3, myStartDate);
        if (filteredTasks.size() == 0) {
            System.out.println("Заданий с началом таска " + myStartDate + " нет");
        } else {
            return filteredTasks;
        }
        return null;
    }

    public ArrayList filterByDeadLine() {
        System.out.println("Введите корректную дату дедлайна в формате dd-mm-yyyy");
        String myDeadLine = enterCorrectDate();
        ArrayList<Task> filteredTasks = filterTasks(4, myDeadLine);
        if (filteredTasks.size() == 0) {
            System.out.println("Заданий с дедлайном " + myDeadLine + " нет");
        } else {
            return filteredTasks;
        }
        return null;
    }


    private ArrayList filterTasks(int cryteria, String filter_date) {
        ArrayList<Task> filteredTasks = new ArrayList();
        for (Task task : allTasks) {
            switch (cryteria) {
                case 1:
//                    flag_done = true;
                    if (task.getisDone()) filteredTasks.add(task);
                case 2:
//                    flag_done = false;
                    if (!task.getisDone()) filteredTasks.add(task);
                case 3:
//                    по начальной дате
                    if (task.getStartDate().equals(filter_date)) filteredTasks.add(task);
                case 4:
//                    по конечной дате
                    if (task.getEndDate().equals(filter_date)) filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void showTasks(ArrayList<Task> myTasks) {
//        Вывод всех заданий
        try {
            System.out.println("myTasks size=" + myTasks.size());
            for (Task task : myTasks) {
                System.out.println(task.toString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Список заданий пуст.");
        }
    }
//Осталась фильтрация:
//
//    Просмотреть список ВЫПОЛНЕННЫХ заданий
//    Просмотреть список НЕВЫПОЛНЕННЫХ заданий
//    Пункты 4-6 на конкретную дату ВЫПОЛНЕНИЯ
//    Пункты 4-6 на конкретную дату СОЗДАНИЯ
//    Просмотреть детальную информацию о задании


//    @Override
//    public String toString(ArrayList myTasks) {
//        String allTasks_str = "";
//        for (Task task : allTasks) {
//            System.out.println(myTasks.get(i).toString() + "\n");
//            allTasks_str += task.toString();
//        return allTasks_str;
//        }
//    }

}
