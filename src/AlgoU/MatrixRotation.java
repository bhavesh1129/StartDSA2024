package AlgoU;

import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[][] matrix = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] resMatrix = matrixRotationBy90DegreeAC(matrix, M);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(resMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixRotationBy90DegreeAC(int[][] matrix, int M) {
        int[][] resMatrix = new int[M][M];
        int k = 0;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                resMatrix[k][j] = matrix[j][i];
            }
            k++;
        }
        return resMatrix;
    }
}