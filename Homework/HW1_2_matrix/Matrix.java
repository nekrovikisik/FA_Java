package HW1_2_matrix;
import java.util.Arrays;

/*
        Реализуйте класс матрицы и методы
        Сложение и вычитание матриц.
        Умножение матрицы на число.
        Произведение двух матриц.
        Транспонированная матрица.
        Возведение матрицы в степень.
        Если метод, возвращает матрицу, то он должен возвращать новый объект, а не
        менять базовый.
*/

public class Matrix {
    private double[][] matrix;
    private int n;
    private int m;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    public Matrix t() { //Умножение матрицы на число
        double[][] t_matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t_matrix[i][j] = matrix[j][i];
            }
        }
        return new Matrix(t_matrix);
    }

    public void show() {
        try {
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }
        catch (Exception e){
            System.out.println("Невозможно вывести матриццу в консоль.");
        }
    }

    public int get_m() {
        return m;
    }

    public int get_n() {
        return n;
    }

    public double get_element(int n, int m) {
        return matrix[n][m];
    }
    public static Matrix multiply_to_digit(double k, Matrix my_matrix) {
        double[][] new_matrix = new double[my_matrix.get_n()][my_matrix.get_m()];
        for (int i = 0; i < my_matrix.get_n(); i++) {
             for (int j = 0; j < my_matrix.get_m(); j++) {
                 new_matrix[i][j] = my_matrix.get_element(i, j)*k;
              }
        }
        return new Matrix(new_matrix);

    }
    //Сложение и вычитание матриц.
    public static Matrix add_substract(Matrix first_matrix, Matrix second_matrix, char operation_type) {
        Matrix new_second_matrix;
        String operation_str;
        if (operation_type == '+'){
            new_second_matrix = multiply_to_digit(-1, second_matrix);
            operation_str = new String("Сложение");
        }
        else{
            new_second_matrix = second_matrix;
            operation_str = new String("Вычитание");
        }
        if (first_matrix.get_m() == new_second_matrix.get_m() && first_matrix.get_n() == new_second_matrix.get_n()) {
            double[][] res_matrix = new double[first_matrix.get_n()][first_matrix.get_m()];
            for (int i = 0; i < first_matrix.get_n(); i++) {
                for (int j = 0; j < first_matrix.get_m(); j++) {
                    res_matrix[i][j] = first_matrix.get_element(i, j) + new_second_matrix.get_element(i, j);
                    System.out.println(res_matrix[i]);
                }
            }
            return new Matrix(res_matrix);
        } else {
            System.out.println(operation_str+" невозможно");
            return null;
        }
    }
    public static Matrix multiply(Matrix first_matrix, Matrix second_matrix) {
        if (first_matrix.get_m() == second_matrix.get_n() && first_matrix.get_n() == second_matrix.get_m()) {
            double[][] m_matrix = new double[first_matrix.get_n()][second_matrix.get_m()];
            for (int i = 0; i < first_matrix.get_n(); i++) {
                for (int j = 0; j < second_matrix.get_m(); j++) {
                    for (int r = 0; r < second_matrix.get_n(); r++) {
                        m_matrix[i][j] += first_matrix.get_element(i, r) * second_matrix.get_element(r, j);
                    }
                }
            }
            return new Matrix(m_matrix);
        } else {
            System.out.println("Умножение невозможно");
            return null;
        }
    }
    public static Matrix pow(int q, Matrix my_matrix){
        Matrix[] m_mymatrix = new Matrix[q];
        for(int i=0; i<=q-1; i++){
            if (i==0){
                m_mymatrix[i] = Matrix.multiply(my_matrix,my_matrix);
            }
            else{
                m_mymatrix[i] = Matrix.multiply(m_mymatrix[i-1],my_matrix);
            }
        }
        return m_mymatrix[q-1];
    }
}
