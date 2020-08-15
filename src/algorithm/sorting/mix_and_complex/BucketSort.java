package algorithm.sorting.mix_and_complex;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is a sorting algorithm that works by distributing the elements of an array into a number of buckets.
 * Each bucket is then sorted individually. By doing this, we can reduce the number of comparisons between the elements
 * and help cut the sorting time
 * <p>
 * <p>
 * Because this algorithm has not trivial logic I describe by steps:
 * 1) Find max value in incoming array - because this value is needed for calculation correct bucket
 * 2) Calculate bucket capacity by following function = root square from array size
 * 3) Create and fill list of lists
 * 4) Distribute values to particular bucket
 * 5) Sort each bucket separately (I used insertion sort)
 * 6) Merge buckets to original array
 * <p>
 * <p>
 * Time complexity:
 * - Best: O(n + k) - where k is number of buckets
 * - Average: O(n + k)
 * - Worst: O(n^2)
 * Space complexity:
 * - Worst: O(n)
 * Stable: YES
 * <p>
 * When use: In cases when array consists from random not equal values.
 * <p>
 * Attention:
 * Sorting degrades with little distinguishable elements because most of elements put in one bucket!
 * Algorithm demands knowledge about nature of sorted data!
 */
public class BucketSort {

    public static void sort(int[] arr) {
        int maxValue = findMaxValue(arr);
        int bucketCapacity = (int) Math.sqrt(arr.length);
        List<List<Integer>> buckets = new ArrayList<>(bucketCapacity);
        for (int i = 0; i < bucketCapacity; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int i : arr) {
            int index = i / maxValue * (bucketCapacity - 1);
            buckets.get(index).add(i);
        }

        buckets.forEach(BucketSort::sortBucket);
        List<Integer> mergedList = buckets.stream().flatMap(Collection::stream).collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mergedList.get(i);
        }

    }

    /**
     * This is implementation of insertion sort
     */
    private static void sortBucket(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int unsortedElement = bucket.get(i);
            int j = i;
            while (j > 0 && bucket.get(j - 1) > unsortedElement) {
                swap(bucket, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static int findMaxValue(int[] arr) {
        return Arrays.stream(arr).max().orElseThrow(() -> new IllegalArgumentException("Arrays shouldn't be empty"));
    }
}
