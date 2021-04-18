package algorithm.algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {
    public static void main(String[] args) {
        System.out.println(new SunsetViews().sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();

        int maxHeight = 0;
        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                int currentHeight = buildings[i];
                if (currentHeight > maxHeight) {
                    result.add(i);
                    maxHeight = currentHeight;
                }
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                int currentHeight = buildings[i];
                if (currentHeight > maxHeight) {
                    result.add(i);
                    maxHeight = currentHeight;
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
