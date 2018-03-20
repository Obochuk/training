public class Runner {
    public static void run() {
        int size = 4;
        int[][] matrix = new int[size][size];

        /* Generate 'random' matrix*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = size * i + j;
            }
        }

        SquareMatrix squareMatrix = SquareMatrix.create(matrix);
        System.out.println(squareMatrix);
        squareMatrix.turnAgainstClock();
        System.out.println(squareMatrix);
    }

}
