package algorithm.sorting.iterative;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
 * from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 *
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 *
 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Time complexity:
 * - Best: O(n^2)
 * - Average: O(n^2)
 * - Worst: O(n^2)
 * Space complexity:
 * - Worst: O(1)
 * Stable: NO (only in implementation with linkedlist)
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int currentValue = array[j];
                if (currentValue < min) {
                    min = currentValue;
                    swap(array, i, j);
                }
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(100);
        }

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
