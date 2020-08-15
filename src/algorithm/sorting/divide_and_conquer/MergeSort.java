package algorithm.sorting.divide_and_conquer;


/**
 * Merge sort is a "divide and conquer" algorithm. It divides input array in two halves, calls itself for the two halves
 * and then merges the two sorted halves.
 * <p>
 * Pros:
 * - Time-efficient with time complexity of O(n \log n)O(nlogn)
 * - Can be used for external sorting
 * - Highly parallelizable
 * - Stable sort
 * Cons:
 * - Marginally slower than quicksort in practice
 * -  Not as space-efficient as other sorting algorithms, e.g. block sort
 * <p>
 * <p>
 * Time complexity:
 * - Best: O(n*log n)
 * - Average: O(n*log n)
 * - Worst: O(n*log n)
 * Space complexity:
 * - Worst: O(n)
 * Stable: YES
 * <p>
 * When use: when possible donate a memory because algo uses additional memory for sorting.
 */
public class MergeSort {

    public static void sort(int[] arr, int size) {
        if (size < 2) {
            return;
        }

        int mid = size / 2;
        int[] l = new int[mid];
        int[] r = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < size; i++) {
            r[i - mid] = arr[i];
        }
        sort(l, mid);
        sort(r, size - mid);

        merge(arr, l, r);
    }

    private static void merge(int[] a, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < l.length) {
            a[k++] = l[i++];
        }
        while (j < r.length) {
            a[k++] = r[j++];
        }
    }
}
