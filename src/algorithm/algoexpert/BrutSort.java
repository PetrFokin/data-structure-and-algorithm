package algorithm.algoexpert;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BrutSort {

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int indexOfSmallestValue = 0;
        int indexOfLargestValue = arr.length - 1;

        for (int idx = arr.length - 1; idx >= 0; idx--) {
            int smallestValue = arr[indexOfSmallestValue];
            int largestValue = arr[indexOfLargestValue];
            if (smallestValue > largestValue) {
                result[idx] = smallestValue;
                indexOfSmallestValue++;
            } else {
                result[idx] = largestValue;
                indexOfLargestValue--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -5, 0, 5, 10};
        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(100);
        }*/

        System.out.println(Arrays.toString(sort(arr)));
    }
}
