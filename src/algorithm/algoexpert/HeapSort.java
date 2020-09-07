package algorithm.algoexpert;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class HeapSort {

    public static void sort(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }

        for (int i = heapSize - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int rootIndex = index;
        int leftIndex =  rootIndex * 2 + 1;
        int rightIndex = rootIndex * 2 + 2;


        if (leftIndex < heapSize && arr[rootIndex] < arr[leftIndex]) {
            rootIndex = leftIndex;
        }

        if (rightIndex < heapSize && arr[rootIndex] < arr[rightIndex]) {
            rootIndex = rightIndex;
        }

        if (rootIndex != index) {
            swap(arr, index, rootIndex);
            heapify(arr, rootIndex, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(100);
        }

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
