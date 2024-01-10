package AlgoU;

import java.util.Arrays;

public class PrefixSumAlgo {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = findPrefixSumOptimised(arr);
        System.out.println(Arrays.toString(res));
    }

    protected static int[] findPrefixSumOptimised(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] + arr[i]; // Note:(prefix[i]=prefix[i-1]+arr[i])
        }
        return res;
    }

    private static int[] findPrefixSum(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            res[i] = sum;
        }
        return res;
    }
}
