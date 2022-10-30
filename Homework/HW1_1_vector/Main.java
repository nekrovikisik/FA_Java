package HW1_1_vector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        double x1 = 2;
        double y1 = 1;
        double z1 = 5;

        double x2 = 7;
        double y2 = 2;
        double z2 = -3;

        Scanner scanner = new Scanner(System.in);

        Vector first_vector = new Vector(x1,y1,z1);
        Vector second_vector = new Vector(x2,y2,z2);

        double lenght_v1 = first_vector.lenVector();
        System.out.println("Длина вектора "+Vector.to_string(first_vector)+": "+ lenght_v1);

        double scalar = Vector.scalar_vectors(first_vector,second_vector);
        System.out.println("Скалярное произведение: "+ scalar);
        Vector vec_mult = Vector.vec_vectors(first_vector,second_vector);

        System.out.println("Векторное произведение: "+ Vector.to_string(vec_mult));

        double cosinus = Vector.cos_vectors(first_vector,second_vector);
        System.out.println("Косинус угла: "+cosinus);

        Vector vec_sum = Vector.sum_vectors(first_vector,second_vector);
        System.out.println("Сумма: "+Vector.to_string(vec_sum));
        Vector vec_diff = Vector.diff_vectors(first_vector,second_vector);
        System.out.println("Разность: "+Vector.to_string(vec_diff));

        System.out.println("Введите количество элементов в массиве:");
        int n = scanner.nextInt();
        Vector[] vectors  = Vector.vectors(n);
        Vector.print_vectors(vectors);
    }
}
