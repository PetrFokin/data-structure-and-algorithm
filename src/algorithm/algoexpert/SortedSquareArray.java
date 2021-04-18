package algorithm.algoexpert;

import java.util.Arrays;

public class SortedSquareArray {

    public static void main(String[] args) {
        int[] array =  {-10, -5, 0, 5, 10};
        System.out.println(Arrays.toString(new SortedSquareArray().sortedSquaredArray(array)));
    }

    public int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i] * array[i];
        }

        bubbleSort(result);
        return result;
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean sorted = false;
            if (sorted) break;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
