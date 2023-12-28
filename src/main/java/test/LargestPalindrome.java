package test;

public class LargestPalindrome {

    public static void main(String[] args) throws InterruptedException {
        // Check for palindromes centered between two characters

        System.out.println(findLongestPalindrome("hellosannasmith"));
    }

    public static String findLongestPalindrome(String str) {
        int n = str.length();
        int maxLength = 1;
        int startIndex = 0;

        // Check for palindromes centered around single characters
        for (int i = 0; i < n; i++) {
            int right = i;
            while (right < n && str.charAt(i) == str.charAt(right)) {
                if (right - i + 1 > maxLength) {
                    maxLength = right - i + 1;
                    startIndex = i;
                }
                right++;
            }
        }

        // Check for palindromes centered between two characters
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                int left = i - 1;
                int right = i;
                while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                    if (right - left + 1 > maxLength) {
                        maxLength = right - left + 1;
                        startIndex = left;
                    }
                    left--;
                    right++;
                }
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }
}
