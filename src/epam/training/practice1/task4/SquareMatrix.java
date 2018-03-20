final public class SquareMatrix {
    int[][] matrix;

    private SquareMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * create {@code SquareMatrix} object
     * @param matrix not null, not empty array of arrays, all with equal sizes,- for all matrix.length = matrix[i]=length
     * @return {@code SquareMatrix} with specified internal state
     */
    public static SquareMatrix create(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Argument must not be null");
        if (matrix.length == 0)
            throw new IllegalArgumentException("The size of matrix can not be 0");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length)
                throw new IllegalArgumentException("Argument must be array of arrays, all must have equal sizes!" +
                        "Matrix.length=" + matrix.length + " Matrix[" + i + "].length=" + matrix[i].length);
        }

        return new SquareMatrix(matrix);
    }

    /**
     * change location of internal values of square matrix such,
     * that it becomes turned against clock direction of movement
     * @return turned square matrix
     */
    public int[][] turnAgainstClock() {
        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) { // border -> center
            for (int j = i; j < length - 1 - i; j++) { // left -> right
                // swap 4 angels
                final int LEFT_BOTTOM_CORNER = matrix[length - i - 1][j];
                final int LEFT_UPPER_CORNER = matrix[j][i];
                final int RIGHT_BOTTOM_CORNER = matrix[length - j - 1][length - i - 1];
                final int RIGHT_UPPER_CORNER = matrix[i][length - j - 1];

                matrix[length - i - 1][j] = LEFT_UPPER_CORNER; // leftBottom = leftUpper
                matrix[length - j - 1][length - i - 1] = LEFT_BOTTOM_CORNER; // rightBottom = leftBottom
                matrix[i][length - j - 1] = RIGHT_BOTTOM_CORNER; // rightUpper = rightBottom
                matrix[j][i] = RIGHT_UPPER_CORNER; // leftUpper = rightUpper
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(matrix[i][j]).append(" ");
            }
            builder.append("\n");
        }
        builder.append("}");
        return new String(builder);
    }
}
