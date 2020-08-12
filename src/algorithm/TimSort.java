package algorithm;

public class TimSort {

    public static void sort(int[] arr) {
        int run = findMinRunLength(arr.length);
        for (int i = 0; i < arr.length; i += run) {
            insertionSort(arr, i, i + run);
        }
        mergeSort(arr, run);
    }

    private static void mergeSort(int[] arr, int size) {
        if (size >= arr.length)
            return;

        for (int i = 0; i < arr.length; i += size * 2) {

            int left = i;
            int right = i + size * 2;
            right = Math.min(right, arr.length); //prevent out of bounds of array
            int med = left + size;

            if (med >= arr.length) //TODO: temp solution need more elegant for last array without couple
                break;

            int[] leftArr = new int[med - left];
            int[] rightArr = new int[right - med];

            for (int j = left, k = 0; k < leftArr.length; j++, k++) {
                leftArr[k] = arr[j];
            }

            for (int j = med, k = 0; k < rightArr.length; j++, k++) {
                rightArr[k] = arr[j];
            }

            merge(arr, leftArr, rightArr, left);
        }
        mergeSort(arr, size * 2);
    }

    /**
     * @param cursor - it needs for correct merge between sub arrays
     */
    private static void merge(int[] arr, int[] left, int[] right, int cursor) {
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[cursor++] = left[i++];
            } else {
                arr[cursor++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[cursor++] = left[i++];
        }
        while (j < right.length) {
            arr[cursor++] = right[j++];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findMinRunLength(int length) {
        int flag = 0;
        while (length >= 64) {
            flag |= length & 1;
            length >>= 1;
        }
        return length + flag;
    }

    private static void insertionSort(int[] arr, int start, int end) {
        end = Math.min(end, arr.length); //prevent out of bounds of array
        for (int i = start + 1; i < end; i++) { //check end
            int unsortedElement = arr[i];
            int j = i;
            while (j > start && arr[j - 1] > unsortedElement) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }
}
