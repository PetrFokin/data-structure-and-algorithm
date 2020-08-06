package algorithm;

import java.util.*;
import java.util.stream.Collectors;

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
        for(int i = 0; i < arr.length; i++) {
            arr[i] = mergedList.get(i);
        }

    }

    private static void sortBucket(List<Integer> bucket) {
        for(int i = 1; i < bucket.size(); i++) {
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
