package AlgoU;

import java.util.Arrays;
import java.util.Scanner;

public class SphinxAndRangeSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int queriesCount = sc.nextInt();
        int[][] queryArr = new int[queriesCount][2];
        for (int i = 0; i < queriesCount; i++) {
            for (int j = 0; j < 2; j++) {
                queryArr[i][j] = sc.nextInt();
            }
        }
        int[] res = findSphinxAndRangeSum(arr, queriesCount, queryArr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findSphinxAndRangeSum(int[] arr, int queriesCount, int[][] queryArr) {
        int[] prefixArr = new int[arr.length];
        int[] res = new int[queriesCount];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        for (int i = 0; i < queryArr.length; i++) {
            int leftIndex = queryArr[i][0];
            int rightIndex = queryArr[i][1];
            if (leftIndex > 1) {
                res[i] = prefixArr[rightIndex - 1] - prefixArr[leftIndex - 2];
            } else {
                res[i] = prefixArr[rightIndex - 1];
            }
        }
        return res;
    }
}
