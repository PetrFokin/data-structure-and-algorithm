package test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TestSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int currentValue = arr[j];
                if (min > currentValue) {
                    swap(arr, i, j);
                    min = currentValue;
                }
            }
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
