package NeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOFfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int n = 4;
        int[] arr = {1,2,3,4};
        int[] res = productOfArrExceptSelfOptimised(arr, n);
        System.out.println(Arrays.toString(res));
    }

    private static int[] productOfArrExceptSelf(int[] arr, int n) {
        int[] res = new int[n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    res[i] = temp * arr[j];
                    temp = res[i];
                }
            }
            temp = 1;
        }
        return res;
    }

    private static int[] productOfArrExceptSelfOptimised(int[] nums, int n){
        int[] result = new int[n];
        for (int i = 0, tmp = 1; i < n; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = n - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
