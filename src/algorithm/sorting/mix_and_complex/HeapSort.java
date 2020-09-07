package algorithm.sorting.mix_and_complex;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This algorithm uses heap data structure but over current array because heap is completed binary tree and so we can get
 * left and right childs by following formulas: node index + 1 and node index + 2.
 * Algo consists of following steps:
 * - create heap
 * - sort by swap last element (max heap) with current index in loop and "heapify" heap in each interaction after swap
 * <p>
 * Time complexity:
 * - Best: O(n*log n)
 * - Average: O(n*log n)
 * - Worst: O(n*log n)
 * Space complexity:
 * - Worst: O(1)
 * Stable: No!!!!!
 * When use: When less space is available but worst time complexity better than quicksort
 */
public class HeapSort {
    public static void sort(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, heapSize, i);
        }

        for (int i = heapSize - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int index) {
        int root = index;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;

        if (leftChild < heapSize && arr[root] < arr[leftChild]) {
            root = leftChild;
        }

        if (rightChild < heapSize && arr[root] < arr[rightChild]) {
            root = rightChild;
        }

        if (root != index) {
            swap(arr, index, root);
            heapify(arr, heapSize, root);
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
