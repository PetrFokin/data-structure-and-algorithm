package algorithm.algoexpert;

import java.util.Arrays;

public class CaesarCipherEncryptor {

    private static final int ALPHABET_LENGTH = 26;
    private static final int LAST_CHAR = 122;

    public static String caesarCypherEncryptor(String str, int key) {
        int smoothKey = key % ALPHABET_LENGTH;
        StringBuilder incryptedString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int newValue = str.codePointAt(i) + smoothKey;
            if (newValue > LAST_CHAR) {
                incryptedString.append((char) (newValue - ALPHABET_LENGTH));
            } else {
                incryptedString.append((char) newValue);
            }
        }
        return incryptedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 5));

    }
}
