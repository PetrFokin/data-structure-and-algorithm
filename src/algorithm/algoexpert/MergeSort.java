package algorithm.algoexpert;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    private static void sort(int[] arr, int size) {
        if (size < 2)
            return;
        int mid = size / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, size);
        sort(left, mid);
        sort(right, size - mid); //attention this need for correct size of right array
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int k = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
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
