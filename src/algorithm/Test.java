package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static algorithm.TimSort.sort;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5000000; i++)
            list.add(ThreadLocalRandom.current().nextInt(100));
        int[] arr = list.stream().mapToInt(it -> it).toArray();
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
