package algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int med = (left + right) / 2;
            sort(arr, left, med);
            sort(arr, med + 1, right);
            merge(arr, left, med, right);
        }
    }

    private static void merge(int[] arr, int left, int med, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, med + 1);
        int[] rightArr = Arrays.copyOfRange(arr, med + 1, right + 1);

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (i == leftArr.length) {
                copy(k, arr, j, rightArr);
                break;
            }

            if (j == rightArr.length) {
                copy(k, arr, i, leftArr);
                break;
            }

            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
        }
    }

    private static void copy(int startTargetIndex, int[] targetArr, int startSourceIndex, int[] sourceArr) {
        for (int i = startTargetIndex, j = startSourceIndex; j < sourceArr.length; i++, j++) {
            targetArr[i] = sourceArr[j];
        }
    }
}
