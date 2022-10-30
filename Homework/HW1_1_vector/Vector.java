package HW1_1_vector;

public class Vector {
    private double x;
    private double y;
    private double z;

    /**
     *
     * @param x - первая координата
     * @param y - вторая координата
     * @param z - третья координата
     */

    public Vector(double x,double y,double z){ // конструктор с параметрами в виде списка координат x, y, z
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lenVector(){ // метод, вычисляющий длину вектора Math.sqrt()
        return Math.sqrt(x*x+y*y+z*z);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public static String to_string(Vector my_vector) {
        return ("("+my_vector.getX()+", "+my_vector.getY()+", "+my_vector.getZ()+")");
    }
    //метод, вычисляющий скалярное произведение
    public static double scalar_vectors(Vector first_vector, Vector second_vector){
        return first_vector.getX()*second_vector.getX()+first_vector.getY()*second_vector.getY()+
                first_vector.getZ()*second_vector.getZ();
    }
    //метод, вычисляющий векторное произведение с другим вектором
    public static Vector vec_vectors(Vector first_vector, Vector second_vector) {
        return new Vector(
                first_vector.getY() * second_vector.getZ() - first_vector.getZ() * second_vector.getY(),
                first_vector.getZ() * second_vector.getX() - first_vector.getX() * second_vector.getZ(),
                first_vector.getX() * second_vector.getY() - first_vector.getY() * second_vector.getX());
    }
    //метод, вычисляющий угол между векторами (или косинус угла): косинус угла
    //между векторами равен скалярному произведению векторов, деленному на
    //произведение модулей (длин) векторов
    public static double cos_vectors(Vector first_vector, Vector second_vector){
        double scalar = Vector.scalar_vectors(first_vector,second_vector);
        double lenght_v1 = first_vector.lenVector();
        double lenght_v2= second_vector.lenVector();
        return scalar/(lenght_v1*lenght_v2);
    }
    //методы для суммы и разности
    public static Vector sum_vectors(Vector first_vector, Vector second_vector) {
        return new Vector(first_vector.getX() + second_vector.getX(),
                first_vector.getY() + second_vector.getY(),
                first_vector.getZ() + second_vector.getZ());
    }

    public static Vector diff_vectors(Vector first_vector, Vector second_vector) {
        return new Vector(first_vector.getX() - second_vector.getX(),
                first_vector.getY() - second_vector.getY(),
                first_vector.getZ() - second_vector.getZ());
    }
    public static Vector[] vectors(int n){
        Vector[] vectors = new Vector[n];
        for (int i = 0; i<n; i++){
            vectors[i] = new Vector(Math.random(),Math.random(),Math.random());
        }
        return vectors;
    }
    public static void print_vectors(Vector[] vectors){
        System.out.println("Новые вектора");
        for (int i= 0; i< vectors.length; i++){
            System.out.println(i+1+"-ый вектор: "+to_string(vectors[i]));
        }
    }
}
