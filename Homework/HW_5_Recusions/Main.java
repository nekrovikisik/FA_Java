package HW_5_Recusions;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    //    Дано натуральное число n. Выведите все числа от 1 до n.
    public static void Task1(int i) {
        if (i > 0) {
            System.out.print(i + "  ");
            Task1(i - 1);
        }
    }

    //    Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
//    Используйте перебор и двоичный поиск для решения этой задачи. Сравните время
//    выполнения обоих решений для больших массивов (например, 100000000 элементов).
    public static int Task2_binary_search(int[] mySearchedArr, int element, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) return -1; // нет в массиве такого числа
        int elementPos = -1;

        int midIndex = (lowIndex + highIndex) / 2;
//        System.out.println("midIntex = " + midIndex);
//        System.out.println("mySearchedArr[midIndex] = " + mySearchedArr[midIndex]);
        if (element == mySearchedArr[midIndex]) {
            System.out.println("В массиве mySearchedArr = " + Arrays.toString(mySearchedArr) + ", найден " + element + " с индексом = " + midIndex);
            return midIndex;
        } else if (element < mySearchedArr[midIndex]) {
//                двигаемся левее от midIndex
            Task2_binary_search(mySearchedArr, element, lowIndex, midIndex - 1);
        } else if (element > mySearchedArr[midIndex]) {
//                двигаемся правее от midIndex
            Task2_binary_search(mySearchedArr, element, midIndex + 1, highIndex);
        }
        return -1;
    }

    public static int Task2_simple_search(int[] mySearchedArr, int element) {
        for (int i = 0; i < mySearchedArr.length; i++) {
            if (mySearchedArr[i] == element)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("Задание 1");
        Task1(10);
        System.out.println();

        System.out.println("Задание 2");
        int num = 100000;
        int[] myArr = IntStream.generate(() -> new Random().nextInt(num)).limit(num).toArray();
        int myElement = new Random().nextInt(num);
        long time1 = System.nanoTime();
        Task2_binary_search(myArr, myElement, 0, myArr.length - 1);
        time1 = System.nanoTime() - time1;
        System.out.printf("Binary search %,9.3f ms\n", time1 / 1_000_000.0);
        long time2 = System.nanoTime();
        Task2_simple_search(myArr, myElement);
        time2 = System.nanoTime() - time2;
        System.out.printf("Simple search %,9.3f ms\n", time2 / 1_000_000.0);
        System.out.println("Чем больше длина массива для поиска тем эффективнее бинарный поиск");

    }
}