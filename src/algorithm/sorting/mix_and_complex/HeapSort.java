package algorithm.sorting.mix_and_complex;

/**
 *
 */
public class HeapSort {
    public static void sort(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2 - 1; i >=0; i--) {
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
}
