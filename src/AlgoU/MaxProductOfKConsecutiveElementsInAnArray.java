package AlgoU;

import java.util.ArrayList;

public class MaxProductOfKConsecutiveElementsInAnArray {
    public static void main(String[] args) {
        int[] arr = {-2, 4, -3, 4, 5, 0, 6, 7, 8};
        int k = 3;
        System.out.println(maxProductOfKConElmInArrayOptimised(arr, k));
    }

    private static int maxProductOfKConElmInArrayOptimised(int[] arr, int k) {
        //Note: Taking care of 0 value in an array
        int countOfZero = 0, maxNonZeroProduct = 1, currProduct = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (arr[i] == 0) {
                countOfZero++;
            } else {
                currProduct *= arr[i];
            }
        }
        list.add(currProduct);
        maxNonZeroProduct = currProduct;

        for (int i = k; i < arr.length; i++) {
            if (arr[i - k] == 0) {
                countOfZero--;
            } else if (arr[i] == 0) {
                countOfZero++;
            }
            if (arr[i - k] != 0) {
                if (arr[i] == 0) {
                    currProduct = currProduct / arr[i - k];
                } else { //ignoring 0 value from the array
                    currProduct = (currProduct * arr[i]) / arr[i - k];
                }
                list.add(currProduct);
            }
//            System.out.print(countOfZero + " ");
            maxNonZeroProduct = Math.max(maxNonZeroProduct, currProduct);
        }
//        System.out.println();
        System.out.println(list);
        return maxNonZeroProduct;
    }

    private static int maxProductOfKConElmInArray(int[] arr, int k) {
        int maxProduct = 1;
        int currProduct = 1;
        for (int i = 0; i < k; i++) {
            currProduct *= arr[i];
        }
        maxProduct = currProduct;
        for (int i = k; i < arr.length; i++) {
            if (arr[i - k] != 0) {
                currProduct = (currProduct * arr[i]) / arr[i - k];
                maxProduct = Math.max(currProduct, maxProduct);
            }
        }
        return maxProduct;
    }
}
