package algorithm.sorting.iterative;

import java.util.Arrays;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 * <p>
 * Time complexity:
 * - Best: O(n)
 * - Average: O(n^2)
 * - Worst: O(n^2)
 * Space complexity:
 * - Worst: O(1)
 * Stable: YES
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        boolean sorted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (sorted)
                break;
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 100, 7, 3, 11, -4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
