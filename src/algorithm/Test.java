package algorithm;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int [] arr = {2, 78, 34, 7, 0, 1024, 156, 97, 99, 13, 44};
        //MergeSort.sort(arr, 0, arr.length - 1);
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
