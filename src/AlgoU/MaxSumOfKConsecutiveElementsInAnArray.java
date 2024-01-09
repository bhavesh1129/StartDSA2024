package AlgoU;

public class MaxSumOfKConsecutiveElementsInAnArray {
    public static void main(String[] args) {
        int[] arr = {10, 12, 9, 8, 10, 15, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumOfKConElmInArray(arr, k));
    }

    private static int maxSumOfKConElmInArray(int[] nums, int k) {
        if (k > nums.length) {
            System.out.println("Invalid input: k is greater than the array length");
            return -1;
        }
        int MAX_SUM = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        MAX_SUM = currSum;
        for (int i = k; i < nums.length; i++) {
            currSum = currSum - nums[i - k] + nums[i];
            MAX_SUM = Math.max(MAX_SUM, currSum);
        }
        return MAX_SUM;
    }
}