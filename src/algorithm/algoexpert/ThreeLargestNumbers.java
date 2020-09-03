package algorithm.algoexpert;

import java.util.*;

public class ThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        if (array.length < 3)
            throw new IllegalArgumentException("Array must contain minimum 3 numbers");

        //can replace with manual sort algorithm
        if (array.length == 3) {
            Arrays.sort(array);
            return array;
        }

        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i : array) {
            compareAndUpdate(result, i);
        }

        return result;
    }

    private static void compareAndUpdate(int[] arr, int num) {
        if (num > arr[2])
            shift(arr, num, 2);
        else if (num > arr[1])
            shift(arr, num, 1);
        else if (num > arr[0])
            arr[0] = num;
    }

    private static void shift(int[] arr, int num, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                arr[i] = num;
                break;
            }
            else
                arr[i] = arr[i + 1];
        }
    }

    public static int[] findThreeLargestNumbersUglySolution(int[] array) {
        if (array.length < 3)
            throw new IllegalArgumentException("Array must contain minimum 3 numbers");

        if (array.length == 3) {
            Arrays.sort(array);
            return array;
        }

        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        int counter = 0;
        for (int i : array) {
            if (counter < 3) {
                treeMap.put(i, i);
                counter++;
                continue;
            }

            int min = treeMap.firstKey();
            if (i > min) {
                treeMap.remove(min);
                treeMap.put(i, i);
            }
        }

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = treeMap.pollFirstEntry().getKey();
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
    }
}
