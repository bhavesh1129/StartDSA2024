package AlgoU;

import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        String result = searchInSortedMatrix(matrix, M, N, k) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean searchInSortedMatrix(int[][] matrix, int M, int N, int k) {
        int i = 0, j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == k) {
                return true;
            } else if (k < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
