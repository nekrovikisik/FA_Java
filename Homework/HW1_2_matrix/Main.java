package HW1_2_matrix;

public class Main {
    public static void main(String[] args)  {
        double[][] matrix_arr1 =  { {1,2,3},
                                    {3,3,2},
                                    {2,7,6},
                                    {3,2,5},
                                    {9,3,3},
        };

        double[][] matrix_arr2 = {{1,1,3,3,6},
                                  {3,5,7,1,4},
                                  {5,6,2,6,3}};

        double[][] matrix_arr3 =  {{1, 4, 6},
                                   {2, 3, 4},
                                   {3, 4, 1}};
        Matrix matrix1 = new Matrix(matrix_arr1);
        Matrix matrix2 = new Matrix(matrix_arr2);
        Matrix matrix3 = new Matrix(matrix_arr3);
        System.out.println("Матрица 1");
        matrix1.show();
        System.out.println("Матрица 2");
        matrix2.show();

        System.out.println("Сложение матрицы 1 и транспонированной матрицы 2:");
        Matrix matrix2_t = matrix2.t();
        Matrix res_plus = Matrix.add_substract(matrix1, matrix2_t, '+');
        res_plus.show();

        System.out.println("\nВычитание матрицы 1 и транспонированной матрицы 2:");
        Matrix res_minus = Matrix.add_substract(matrix1, matrix2_t, '-');


        System.out.println("\n\nТранспонирование матрицы 1:");
        Matrix res_t2 = matrix1.t();
        res_t2.show();

        System.out.println("\n\nУмножение матрицы 1 на число 5:");
        Matrix res_multiply_to_digit = Matrix.multiply_to_digit(5, matrix1);
        res_multiply_to_digit.show();

        System.out.println("\n\nПроизведение матрицы 1 и матрицы 2:");
        Matrix res_multiply= Matrix.multiply(matrix1, matrix2);
        res_multiply.show();

        System.out.println("Квадратная матрица 2");
        matrix2.show();

        System.out.println("\n\nВозведение в пятую степень квадратной матрицы 5:");
        Matrix res_pow = Matrix.pow(5, matrix3);
        res_pow.show();
    }
}
