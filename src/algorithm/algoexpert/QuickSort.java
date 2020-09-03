package algorithm.algoexpert;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = sortAndGetPivot(arr, start, end);
            sort(arr, start, pivot);
            sort(arr, pivot, end);
        }
    }

    private static int sortAndGetPivot(int[] arr, int start, int end) {
        int pivot = start;
        int i = start;
        for (int j = start + 1; j < end; j++) {
            if (arr[j] >= arr[pivot]) {
                swap(arr, pivot, i);
                i++;
            }
        }
        return i;
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
