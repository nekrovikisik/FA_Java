package HW_6_Scheduler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {
    private static int counter = 0;
    private boolean isDone;
    private int id;
    private String startDate;
    private String endDate;
    private String title;
    private String description;


    public Task( String title, String description, String endDate, boolean isDone) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();
        this.startDate = dtf.format(now);

        this.endDate = endDate;
        this.isDone = isDone;
    }


    public String getStartDate() {
        return startDate;
    }


    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setisDone(boolean isDone) {
        this.isDone = isDone;
    }
    public boolean getisDone() {
        return isDone;
    }



    @Override
    public String toString() {
        return "Задача\n" +
                "id: " + id +
                "\nЦель: " + title +
                "\nОписание: " + description +
                "\nДата создания: " + startDate +
                "\nДата выполнения: " + endDate +
                "\nВыполнено? " + (isDone?"да" : "Нет") + "\n\n\n";
    }
}

