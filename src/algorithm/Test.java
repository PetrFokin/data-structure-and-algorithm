package algorithm;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int [] arr = {2, 78, 34, 7, 0, 1024, 156, 97, 99, 13, 37};
        int [] arr2 = {2, 2, 1};
        InsertionSort.sort(arr);
        QuickSort.sort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
}
