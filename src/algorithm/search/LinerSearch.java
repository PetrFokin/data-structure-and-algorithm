package algorithm.search;

/**
 * Very simple for implementation algorithm for searching value but with not good time complexity.
 * Not sorted array can be used for searching.
 *
 * Time complexity:
 *  - Best: O(1)
 *  - Average: O(n)
 *  - Worst: O(n)
 *  Space complexity:
 *  - Worst: O(1)
 */
public class LinerSearch {

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
