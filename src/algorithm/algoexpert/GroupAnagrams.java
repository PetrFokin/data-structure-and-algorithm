package algorithm.algoexpert;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String alphabet = String.valueOf(arr);
            if (result.containsKey(alphabet)) {
                result.get(alphabet).add(word);
            } else {
                result.put(alphabet, new ArrayList<>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");
        System.out.println(groupAnagrams(words));
    }
}
