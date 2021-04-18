package algorithm.algoexpert;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWordsInString("this      string     has a     lot of   whitespace"));
    }

    public String reverseWordsInString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if (Character.isWhitespace(charAt)) {
                stringBuilder.insert(0, word);
                stringBuilder.insert(0, charAt);
                word = new StringBuilder();
            } else {
                word.append(charAt);
                if (i == string.length() - 1)
                    stringBuilder.insert(0, word);
            }
        }


        return stringBuilder.toString();
    }
}
