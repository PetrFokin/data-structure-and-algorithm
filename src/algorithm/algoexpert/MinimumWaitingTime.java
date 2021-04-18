package algorithm.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 6};
        System.out.println(new MinimumWaitingTime().minimumWaitingTime(arr));
    }

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int result = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            result += duration * queriesLeft;
        }
        return result;
    }
}
