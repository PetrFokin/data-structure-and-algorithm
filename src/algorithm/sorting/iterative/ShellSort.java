package algorithm.sorting.iterative;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Shell sort is a modified version of insertion sort.
 * The main idea is logical splitting unsorted array to sub array with calculated gap.
 * After that algorithm does some rude sort iterations till gap becomes with size 1.
 * Pure insertion sort is used on the final step of sorting.
 *
 * Algorithm doesn't have complex logic but determination of gap is the most difficult part of that.
 * here https://en.wikipedia.org/wiki/Shellsort is a comparison of different formulas for determination.
 *
 * I decided to use Knuth's formula: (3^k - 1) / 2
 * <p>
 * Time complexity (Knuth's increment sequence):
 * - Best: O(n)
 * - Average: O(n^3/2) ???
 * - Worst: O(n^3/2)
 * Space complexity:
 * - Worst: O(1)
 * Stable: NO
 *
 * Use for medium sized data sets.
 */
public class ShellSort {

    public static void sort(int[] arr) {
        int length = arr.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                int unsortedElement = arr[i];
                int j = i;
                while (j >= h && unsortedElement < arr[j - h]) {
                    swap(arr, j - h, j);
                    j -= h;
                }
            }
            h /= 3;
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
