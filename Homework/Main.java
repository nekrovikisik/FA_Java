import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
//    public ArrayList filterTasks(ArrayList myTasks, int cryteria, String filter_date){
//        ArrayList<Integer> filteredTasks = new ArrayList();
//        for (int i = 0; i < myTasks.size(); i++) {
////            System.out.println(myTasks.get(i).toString() + "\n");
//                    if (myTasks.get(i)==5) filteredTasks.add(i);
//        return filteredTasks;
//    }
public static String enterCorrectDate() {
    Scanner sc = new Scanner(System.in);
    boolean flg_correct = false;
    String myDeadLine = null;
    System.out.println("Введите корректную дату дедлайна в формате dd-mm-yyyy");
    while (!flg_correct) {
        myDeadLine = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        try {
            Date my_date = formatter.parse(myDeadLine);
            flg_correct = true;
        } catch (ParseException e) {
            System.out.println("Введите корректную дату дедлайна в формате dd-mm-yyyy");
        }
    }
    return myDeadLine;
}


    public static void main(String[] args) {
    String datedate = enterCorrectDate();
//        ArrayList<Integer> numbers = ArrayList("1", "2", "3", "4", "5", "6");
//        System.out.println("original list: " + numbers);
////        List<Integer> even = numbers.stream()
////                .map(s -> Integer.valueOf(s))
////                .filter(number -> number % 2 == 0)
////                .collect(Collectors.toList());
//            ArrayList<Integer> filteredTasks = new ArrayList();
//            for (int i = 0; i < myTasks.size(); i++) {
////            System.out.println(myTasks.get(i).toString() + "\n");
//                if (myTasks.get(i)==5) filteredTasks.add(i);
//
//
                System.out.println("processed list, only even numbers: " );

//        byte arr[] = {10, 20, 30, 40, 50};
//        ByteBuffer buffer = ByteBuffer.wrap(arr);
//        System.out.println("Initial buffer state: " + buffer);
//        System.out.println("First read from buffer: " + buffer.get());
//        System.out.println("Buffer state: " + buffer);
//        System.out.println("Second read from buffer: " + buffer.get());
//        System.out.println("Buffer state: " + buffer);
//        System.out.println("Read double (4 bytes): " + buffer.getDouble());
        }

}