package algorithm.algoexpert;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public static String runLengthEncoding(String string) {
        // Write your code here.
        StringBuilder stringBuilder = new StringBuilder();

        int counter = 0;
        char letter = string.charAt(0);
        for (char value : string.toCharArray()) {
            if (letter != value || counter == 9) {
                stringBuilder.append(counter).append(letter);
                counter = 0;
                letter = value;
            }

            counter++;
        }

        return stringBuilder.append(counter).append(letter).toString();
    }
}
