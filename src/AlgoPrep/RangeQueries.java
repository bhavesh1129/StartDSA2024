package AlgoPrep;

import java.util.Arrays;

import static AlgoPrep.PrefixSumAlgo.findPrefixSumOptimised;

public class RangeQueries {
    public static void main(String[] args) {
        int[] arr = {-2, 7, 3, 5, 6, 3, 9, -8, 4, 2};
        int[][] matrix = {{4, 8}, {3, 7}, {1, 3}, {0, 4}, {6, 9}, {7, 7}};
        int[] res = rangeQuery(arr, matrix);
        System.out.println(Arrays.toString(res));
    }

    private static int[] rangeQueryOptimised(int[] arr, int[][] matrix) {
        int[] res = new int[arr.length];
        int[] prefixSumArray = findPrefixSumOptimised(arr);

        for (int i = 0; i < matrix.length; i++) {
            int leftIndex = matrix[i][0];
            int rightIndex = matrix[i][1];
            if (leftIndex > 0) {
                res[i] = prefixSumArray[rightIndex] - prefixSumArray[leftIndex - 1];
            } else {
                res[i] = prefixSumArray[rightIndex];
            }
        }
        return res;
    }

    private static int[] rangeQuery(int[] arr, int[][] matrix) {
        int[] res = new int[arr.length];
        for (int i = 0; i < matrix.length; i++) {
            int leftIndex = matrix[i][0];
            int rightIndex = matrix[i][1];
            int sum = 0;
            for (int j = leftIndex; j <= rightIndex; j++) {
                sum += arr[j];
            }
            res[i] = sum;
        }
        return res;
    }
}
