package algorithm;

public class QuickSort {

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int r = partition(arr, start, end);
            sort(arr, start, r - 1);
            sort(arr, r + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
