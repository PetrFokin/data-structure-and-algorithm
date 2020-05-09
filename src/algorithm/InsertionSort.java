package algorithm;

public class InsertionSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1)
            throw new IllegalArgumentException("The array must have more than one elements");
        for(int i = 1; i < arr.length; i++) {
            int unsortedElement = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > unsortedElement) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
