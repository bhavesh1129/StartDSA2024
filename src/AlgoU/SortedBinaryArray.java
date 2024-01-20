package AlgoU;

import java.util.Arrays;
import java.util.Scanner;

public class SortedBinaryArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = findFirstZeroAndOneIndexInASortedBinaryArray(arr, n);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findFirstZeroAndOneIndexInASortedBinaryArray(int[] arr, int n) {
        int[] res = new int[2];
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right < n) {
            res[0] = right;
        } else {
            res[0] = n;
        }
        if (left >= 0) {
            res[1] = left;
        } else {
            res[1] = -1;
        }
        return res;
    }
}
