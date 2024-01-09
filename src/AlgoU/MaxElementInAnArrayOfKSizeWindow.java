package AlgoU;

import java.util.Arrays;

public class MaxElementInAnArrayOfKSizeWindow {
    public static void main(String[] args) {
        int[] arr = {10, 12, 9, 8, 10, 15, 1, 3, 2};
        int k = 3;
        int[] res = maxElmInArrOfKSizeWin(arr, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] maxElmInArrOfKSizeWin(int[] arr, int k) {
        int[] res = new int[arr.length - k];
        int max = Integer.MIN_VALUE, j = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
        }
        res[j++] = max;
        for (int i = k; i < arr.length; i++) {
//            max = max -
        }
        return res;
    }
}
