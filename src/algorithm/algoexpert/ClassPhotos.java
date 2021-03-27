package algorithm.algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClassPhotos {

    public static boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        var color = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";

        for (int i = 0; i < redShirtHeights.size(); i++) {
            var redShirtHeight = redShirtHeights.get(i);
            var blueShirtHeight = blueShirtHeights.get(i);

            if (color.equals("RED")) {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
        }

        return true;
        //return isEqualHeights(redShirtHeights, blueShirtHeights) || isEqualHeights(blueShirtHeights, redShirtHeights);
    }

    //this is a first solution, it's nasty obvious
    private static boolean isEqualHeights(List<Integer> list1, List<Integer> list2) {
        Collections.sort(list2);
        var tempList = new CopyOnWriteArrayList<>(list2);
        var counter = 0;
        for (int i : list1) {
            for (int j = 0; j < tempList.size(); j++) {
                var value = tempList.get(j);
                if (value > i) {
                    tempList.remove(j);
                    counter++;
                    break;
                }
            }
        }

        return counter == list1.size();
    }

    public static void main(String[] args) {
        var blue = Arrays.asList(125);
        var red = Arrays.asList(126);
        System.out.println(classPhotos(red, blue));
    }
}
