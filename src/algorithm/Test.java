package algorithm;

import algorithm.search.BinarySearch;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int [] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(BinarySearch.search(3, arr));
        System.out.println(BinarySearch.search(-7, arr));
    }
}
