package HW2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Task 3
        List<Integer> testList = Arrays.asList(1, 1, 2, 3, 3, 2);
        Arrays.stream(testList.toArray()).forEach(value -> System.out.printf("%d ", (int)value));
        System.out.println();
        var result = TaskMethods.removeDuplicates(testList);
        Arrays.stream(result.toArray()).forEach(value -> System.out.printf("%d ", (int)value));
        System.out.println();

        // Task 4
        TaskMethods.compareLinkedAndArrayLists();

        // Task 5
        String testStr = "Съешь ещё этих мягких французских булок, да выпей же чаю";
        var entries = TaskMethods.buildDictionary(testStr);
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("args = test");
    }
}
