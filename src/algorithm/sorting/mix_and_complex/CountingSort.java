package algorithm.sorting.mix_and_complex;

/**
 * Because this algorithm contains not simple logic I write algorithm steps:
 * 1) First, we should count the occurrence of each number in the input array.
 * If we represent the countings with array C, then C[i] represents the frequency of number i in the input array.
 * 2) Computing the summation of n consecutive elements in C, we can know how many elements are less than or
 * equal to number n-1 in the input array
 * 3) Fill sorted array depends on index from accumulation array
 * <p>
 * Time complexity:
 * - Best: O(n + k) where k is the range of the non-negative key values
 * - Average: O(n + k)
 * - Worst: O(n + k)
 * Space complexity:
 * - Worst: O(k)
 * Stable: YES
 * <p>
 * When use: In cases when array consists with small range of possible values!
 */
public class CountingSort {

    public static void sort(int[] arr, int length) {
        int[] countedArr = new int[length];
        int[] accumulationArr = new int[length];
        int[] sortedArr = new int[arr.length];

        for (int i : arr) {
            countedArr[i]++;
        }

        int accumulator = 0;
        for (int i = 0; i < countedArr.length; i++) {
            accumulator += countedArr[i];
            accumulationArr[i] = accumulator;
        }

        for (int i : arr) {
            int index = accumulationArr[i];
            accumulationArr[i]++;
            sortedArr[index - 1] = i;
        }

        copyArray(sortedArr, arr);
    }

    private static void copyArray(int[] sortedArr, int[] originalArr) {
        System.arraycopy(sortedArr, 0, originalArr, 0, sortedArr.length);
    }
}
