package AlgoU;

import java.util.Scanner;

public class MatrixTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] result = matrixTraversal(matrix, M, N);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] matrixTraversal(int[][] matrix, int M, int N) {
        int top = 0, bottom = M - 1, left = 0, right = N - 1;
        int[] resArray = new int[M * N];
        int k = 0;
        while (top < bottom && left < right && k <= resArray.length) {
            //left to right
            for (int i = top, j = left; j <= right; j++) {
                resArray[k++] = matrix[i][j];
            }
            top++;
            //top to bottom
            for (int i = top, j = right; i <= bottom; i++) {
                resArray[k++] = matrix[i][j];
            }
            right--;
            //right to left
            for (int i = right, j = bottom; i >= left; i--) {
                resArray[k++] = matrix[j][i];
            }
            bottom--;
            //bottom to top
            for (int i = bottom, j = left; i >= top; i--) {
                resArray[k++] = matrix[i][j];
            }
            left++;
        }
        return resArray;
    }
}
