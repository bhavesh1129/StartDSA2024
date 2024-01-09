package AlgoU;

import java.util.Arrays;

public class MaxElementInAnArrayOfKSizeWindow {
    public static void main(String[] args) {
        int[] arr = {1};
        int k = 1;
        int[] res = maxElmInArrOfKSizeWin(arr, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] maxElmInArrOfKSizeWin(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        int max = Integer.MIN_VALUE, j = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
        }
        res[j++] = max;
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i - k] == max) {
                max = findMax(arr, i - k + 1, i);
            }
            res[j++] = max;
        }
        return res;
    }

    private static int findMax(int[] arr, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, arr[k]);
        }
        return max;
    }
}
