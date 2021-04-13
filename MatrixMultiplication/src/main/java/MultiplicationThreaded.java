public class MultiplicationThreaded {
    private static final int THREADS_COUNT = 4;

    public static void multi(int[][]matrix1, int[][]matrix2){
        Thread[] threads = new Thread[THREADS_COUNT];
        int per = (int) matrix1.length / THREADS_COUNT;
        int[][] matrixResult = new int[matrix1.length][matrix2[0].length];

        for(int i=0; i < THREADS_COUNT; i++){
            threads[i] = new MatrixMultiplicationThread(matrix1, matrix2, matrixResult,per * i, per * (i + 1));
            threads[i].start();
        }
        for (Thread thread : threads){
            try{
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}