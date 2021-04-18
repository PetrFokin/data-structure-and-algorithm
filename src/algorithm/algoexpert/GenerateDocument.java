package algorithm.algoexpert;

import java.util.Map;
import java.util.stream.Collectors;

public class GenerateDocument {

    public static void main(String[] args) {
        System.out.println(new GenerateDocument().generateDocument("", " "));
    }

    public boolean generateDocument(String characters, String document) {
        Map<String, Integer> charactersMap = characters.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toMap(c -> c, c -> 1, (existing, replacement) -> existing + 1));

        Map<String, Integer> documentMap = document.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toMap(c -> c, c -> 1, (existing, replacement) -> existing + 1));

        var entrySet = documentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            var value = charactersMap.get(entry.getKey());
            if (value == null || entry.getValue() > value)
                return false;
        }

        return true;
    }
}
