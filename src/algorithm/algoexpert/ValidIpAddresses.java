package algorithm.algoexpert;

import java.util.ArrayList;

public class ValidIpAddresses {

    public static void main(String[] args) {
        System.out.println(new ValidIpAddresses().validIPAddresses("1921680"));
    }

    public ArrayList<String> validIPAddresses(String string) {
        if (string.length() < 4 || string.length() > 12)
            return new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            String[] parts = new String[4];

            var firstPart = string.substring(0, i);
            parts[0] = firstPart;
            if (!isValid(firstPart)) continue;
            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                var secondPart = string.substring(i, j);
                parts[1] = secondPart;
                if (!isValid(secondPart)) continue;
                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    var thirdPart = string.substring(j, k);
                    var fourthPart = string.substring(k);
                    parts[2] = thirdPart;
                    parts[3] = fourthPart;

                    if (isValid(thirdPart) && isValid(fourthPart))
                        result.add(String.join(".", parts));
                }
            }
        }

        return result;
    }

    private boolean isValid(String string) {
        var parsedInt = Integer.parseInt(string);
        if (parsedInt > 255) return false;

        return string.length() == String.valueOf(parsedInt).length();
    }
}
