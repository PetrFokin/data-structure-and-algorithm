package algorithm.search;

import java.util.Arrays;

/**
 * One of the best and most popular algorithm for searching element.
 * Work ONLY with sorted array.
 * The main idea is recursive divide array to parts by compare searching value with medium value of array.
 * If value > med - search in right part of array
 * If value < med - search in left part of array
 *
 * Time complexity:
 *  - Best: O(1)
 *  - Average: O(log n)
 *  - Worst: O(log n)
 *  Space complexity:
 *  - Worst: O(1)
 */
public class BinarySearch {

    public static int search(int value, int[] arr) {
        Arrays.sort(arr);
        return search(value, arr, 0, arr.length);
    }

    private static int search(int value, int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if (value > arr[mid]) {
            if (start == mid)
                return -1;
            return search(value, arr, mid, end);
        } else if (value < arr[mid]) {
            if (start == mid)
                return -1;
            return search(value, arr, start, mid);
        } else return mid;
    }
}
