package algorithm.sorting.interactive;

/**
 * Insertion sort is a simple sorting algorithm. The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 * <p>
 * Time complexity:
 * - Best: O(n)
 * - Average: O(n^2)
 * - Worst: O(n^2)
 * Space complexity:
 * - Worst: O(1)
 * Stable: YES
 * <p>
 * When use: when the data is nearly sorted (because it is adaptive) or when the problem size is small (because it has low overhead).
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1)
            throw new IllegalArgumentException("The array must have more than one elements");
        for (int i = 1; i < arr.length; i++) {
            int unsortedElement = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > unsortedElement) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
