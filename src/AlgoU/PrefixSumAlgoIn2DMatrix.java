package AlgoU;

import java.util.Arrays;

public class PrefixSumAlgoIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {7, 1, -6, 3, 13},
                {10, 5, -1, 0, 9},
                {6, 4, -3, 8, 11},
                {13, -8, -5, 12, 4},
                {3, 2, 1, 9, 8},
                {4, 3, -2, 6, 5}};
        int[][] res = findPrefixSumIn2DMatrixOptimised(matrix);
        int[][] res2 = findPrefixSumIn2DMatrix(matrix);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("----------------------------------------");
        for (int[] i : res2) {
            System.out.println(Arrays.toString(i));
        }
    }

    protected static int[][] findPrefixSumIn2DMatrixOptimised(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // Note: A(i1,j1) B(i2,j2) ->
                // (prefix[i2][j2]-prefix[i1-1][j2]-prefix[i2][y1-1]+prefix[i1-1][j1-1])
                int sum = matrix[i][j];
                if (i > 0) {
                    sum += res[i - 1][j];
                }
                if (j > 0) {
                    sum += res[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum -= res[i - 1][j - 1];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    private static int[][] findPrefixSumIn2DMatrix(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int x = 0; x <= i; x++) {
                    for (int y = 0; y <= j; y++) {
                        sum += matrix[x][y];
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}
