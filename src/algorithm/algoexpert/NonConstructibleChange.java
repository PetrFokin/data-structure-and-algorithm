package algorithm.algoexpert;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        System.out.println(new NonConstructibleChange().nonConstructibleChange(new int[]{1, 5, 1, 1, 1, 10, 15, 20, 100}));
    }

    public int nonConstructibleChange(int[] coins) {
        if (coins.length == 0)
            return 1;

        Arrays.sort(coins);
        int result = 0;
        for (int i : coins) {
            int possibleMin = result + 1;
            if (possibleMin < i) {
                return possibleMin;
            }

            result += i;
        }

        return result + 1;
    }

}
