package algorithm.algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {
    public static void main(String[] args) {
        System.out.println(new TandemBicycle().tandemBicycle(
                new int[]{5, 5, 3, 9, 2},
                new int[]{3, 6, 7, 2, 1},
                false
        ));
    }

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        if (fastest)
            blueShirtSpeeds = Arrays.stream(blueShirtSpeeds).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        else
            Arrays.sort(blueShirtSpeeds);
        System.out.println(Arrays.toString(redShirtSpeeds));
        System.out.println(Arrays.toString(blueShirtSpeeds));
        int sum = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return sum;
    }
}
