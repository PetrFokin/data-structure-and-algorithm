package algorithm.sorting.divide_and_conquer;

/**
 * Quicksort is a fast sorting algorithm that takes a divide-and-conquer approach to sorting lists.
 * The main idea is sorting recursively array to use for that pivot (in current implementation it's the last value) where
 * values which are less than pivot are moved to the left of the pivot.
 * <p>
 * Time complexity:
 * - Best: O(n*log n)
 * - Average: O(n*log n)
 * - Worst: O(n^2)
 * Space complexity:
 * - Worst: O(n)
 * Stable: NO
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int r = partition(arr, start, end);
            sort(arr, start, r - 1);
            sort(arr, r + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
