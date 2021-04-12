import java.util.Random;

public class MatrixMultiplication {

    public static void main(String[] args){
        Random rnd = new Random();
        int[][] matrix1 = new int[500] [1000];
        int[][] matrix2 = new int[1000] [500];
        for(int i = 0; i< matrix1.length; i++){
            for(int j = 0; j < matrix1[i].length; j++){
                matrix1[i][j] = rnd.nextInt(100) + 1;
                matrix2[j][i] = rnd.nextInt(100) + 1;
            }
        }

        MultiplicationThreaded.multi(matrix1, matrix2);
    }
}
