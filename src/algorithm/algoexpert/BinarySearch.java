package algorithm.algoexpert;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return iterativeSearch(array, target);
    }

    private static int search(int[] array, int start, int end, int target) {
        int med = (start + end) / 2;
        if (target > array[med]) {
            if (start == med)
                return -1;
            return search(array, med, end, target);
        } else if (target < array[med]) {
            if (start == med)
                return -1;
            return search(array, start, med, target);
        } else {
            return med;
        }
    }

    private static int iterativeSearch(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left <= right) {
            int med = (left + right) / 2;
            if (target < array[med]) {
                right = med;
            } else if (target > array[med]) {
                left = med;
            } else {
                return med;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }
}
