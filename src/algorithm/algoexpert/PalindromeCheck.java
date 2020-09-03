package algorithm.algoexpert;

public class PalindromeCheck {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     */
    public static boolean isPalindromeFirstSolution(String str) {
        if (str.length() == 1)
            return true;
        String reversedString = new StringBuilder(str).reverse().toString();
        return str.equals(reversedString);
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public static boolean isPalindrome(String str) {
        int k = 0;
        for(int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            if (str.charAt(i) == str.charAt(j))
                k++;
        }
        return k == str.length();
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }


}
