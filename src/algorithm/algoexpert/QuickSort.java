package algorithm.algoexpert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // implement with right pivot
        int pivot = arr[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] <= pivot) {
                i++; //it's important trick, because cursor places on the last small element and after compare move to next place for insertion
                swap(arr, i, j);
            }
        }

        //for this implementation need additional swap in the end of algorithm
        swap(arr, start, i);
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
