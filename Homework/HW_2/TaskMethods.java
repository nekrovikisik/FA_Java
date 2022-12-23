package HW_2;

import java.util.*;

public class TaskMethods {

    // Task 3
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    // Task 4
    private static void addRandomValues(List<Double> list) {
        for (long i = 0; i < 1e6; ++i) {
            list.add(Math.random());
        }
    }

    private static long selectValuesCalcTime(List<Double> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e5; ++i) {
            list.get((int)(Math.random() * (list.size() - 1)));
        }
        return System.currentTimeMillis() - start;
    }

    public static void compareLinkedAndArrayLists() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        addRandomValues(arrayList);
        addRandomValues(linkedList);
        long timeArrayList = selectValuesCalcTime(arrayList);
        long timeLinkedList = selectValuesCalcTime(linkedList);
        System.out.printf("ArrayList: %d\n", timeArrayList);
        System.out.printf("LinkedList: %d\n", timeLinkedList);
    }

    // Task 5
    public static ArrayList<Map.Entry<Character, Integer>> buildDictionary(String input) {
        input = input.toLowerCase(Locale.ROOT);
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < input.length(); ++i){
            char cur = input.charAt(i);
            if((cur >= 'а' && cur <= 'я') || cur == 'ё'){
                map.compute(cur, (ch, num)  -> num == null ? 1 : num + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        return entries;
    }
}
