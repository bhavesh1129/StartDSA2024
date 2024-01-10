package AlgoU;

import java.util.Arrays;

import static AlgoU.PrefixSumAlgoIn2DMatrix.findPrefixSumIn2DMatrixOptimised;

public class RangeQueriesIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {7, 1, -6, 3, 13},
                {10, 5, -1, 0, 9},
                {6, 4, -3, 8, 11},
                {13, -8, -5, 12, 4},
                {3, 2, 1, 9, 8},
                {4, 3, -2, 6, 5}};
        int[][] rangeMatrix = {
                {2, 1},
                {4, 3},
                {3, 2},
                {5, 4},
                {0, 0},
                {2, 1},
                {0, 0},
                {1, 3},
                {0, 0},
                {3, 2},
                {0, 0},
                {5, 4}};
        int[] res = rangeQueryIn2DMatrixOptimised(matrix, rangeMatrix);
        System.out.println(Arrays.toString(res));
    }

    private static int[] rangeQueryIn2DMatrixOptimised(int[][] matrix, int[][] rangeMatrix) {
        int[] res = new int[rangeMatrix.length / 2];
        int[][] prefixSumMatrix = findPrefixSumIn2DMatrixOptimised(matrix);
        for (int i = 0; i < rangeMatrix.length; i += 2) {
            int row1 = rangeMatrix[i][0];
            int col1 = rangeMatrix[i][1];
            int row2 = rangeMatrix[i + 1][0];
            int col2 = rangeMatrix[i + 1][1];
            int sum = prefixSumMatrix[row2][col2];
            if (row1 > 0) {
                sum -= prefixSumMatrix[row1 - 1][col2];
            }
            if (col1 > 0) {
                sum -= prefixSumMatrix[row2][col1 - 1];
            }
            if (row1 > 0 && col1 > 0) {
                sum += prefixSumMatrix[row1 - 1][col1 - 1];
            }
            res[i / 2] = sum;
        }
        return res;
    }

    private static int[] rangeQueryIn2DMatrix(int[][] matrix, int[][] rangeMatrix) {
        int[] res = new int[rangeMatrix.length / 2];
        int x = 0;
        for (int i = 0; i < rangeMatrix.length; i += 2) {
            int row1 = rangeMatrix[i][0];
            int col1 = rangeMatrix[i][1];
            int row2 = rangeMatrix[i + 1][0];
            int col2 = rangeMatrix[i + 1][1];
            int sum = 0;
            for (int j = row1; j <= row2; j++) {
                for (int k = col1; k <= col2; k++) {
                    sum += matrix[j][k];
                }
            }
            res[x++] = sum;
        }
        return res;
    }
}
