package algorithm.algoexpert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int lvl) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof Integer)
                sum += (int) o;
            else if (o instanceof ArrayList)
                sum += productSum((ArrayList<Object>) o, lvl + 1);
        }
        return lvl * sum;
    }

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        List<Object> array2 = new ArrayList<>();
        array2.add(7);
        array2.add(-1);
        List<Object> array3 = new ArrayList<>();
        List<Object> array4 = new ArrayList<>();
        array3.add(6);
        array3.add(array4);
        array3.add(4);
        array4.add(-13);
        array4.add(8);
        array.add(5);
        array.add(2);
        array.add(array2);
        array.add(3);
        array.add(array3);
        System.out.println(productSum(array));

    }
}
