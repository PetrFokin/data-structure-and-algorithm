package algorithm.algoexpert;

public class LongestPalindromicSubstring {

    //TODO: write more elegant solution with O(n^2), because current time complexity is O(n^3)
    public static String longestPalindromicSubstring(String str) {
        String max = "";
        for(int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String s = (str.substring(i, j + 1));
                String reversed = new StringBuilder(s).reverse().toString();
                if (s.equals(reversed)) {
                    if (s.length() > max.length()) {
                        max = s;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
}
