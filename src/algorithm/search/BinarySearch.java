package algorithm.search;

public class BinarySearch {

    public static int search(int value, int[] arr) {
        return search(value, arr, 0, arr.length);
    }

    private static int search(int value, int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if (value > arr[mid]) {
            if (start == mid)
                return -1;
            return search(value, arr, mid, end);
        } else if (value < arr[mid]) {
            if (start == mid)
                return -1;
            return search(value, arr, start, mid);
        } else return mid;
    }
}
