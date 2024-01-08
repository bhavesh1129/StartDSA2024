package AlgoU;

import java.util.Scanner;
public class ToeplitzMatrix {
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
        int result = isToeplitzMatrix(matrix, M, N) ? 1 : 0;
        System.out.println(result);
    }

    private static boolean isToeplitzMatrix(int[][] matrix, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i < M - 1 && j < N - 1) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
