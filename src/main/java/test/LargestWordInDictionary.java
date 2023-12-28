package test;

import java.util.*;

public class LargestWordInDictionary {
    public static void main(String[] args) {
        String[] dictionary1 = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String input1 = "eot";
        System.out.println(findLargestWord(dictionary1, input1)); // Output: "toe"

        String[] dictionary2 = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String input2 = "ogtdes";
        List<String> result2 = findLargestWords(dictionary2, input2);
        System.out.println(result2); // Output: ["dogs", "toes"]
    }

    public static String findLargestWord(String[] dictionary, String input) {
        List<String> validWords = findValidWords(dictionary, input);
        if (validWords.isEmpty()) {
            return null;
        }

        return Collections.max(validWords, Comparator.comparingInt(String::length));
    }

    public static List<String> findLargestWords(String[] dictionary, String input) {
        List<String> validWords = findValidWords(dictionary, input);
        if (validWords.isEmpty()) {
            return Collections.emptyList();
        }

        int maxLength = Collections.max(validWords, Comparator.comparingInt(String::length)).length();

        List<String> largestWords = new ArrayList<>();
        for (String word : validWords) {
            if (word.length() == maxLength) {
                largestWords.add(word);
            }
        }

        return largestWords;
    }

    private static List<String> findValidWords(String[] dictionary, String input) {
        List<String> validWords = new ArrayList<>();

        for (String word : dictionary) {
            if (canFormWord(word, input)) {
                validWords.add(word);
            }
        }

        return validWords;
    }

    private static boolean canFormWord(String word, String input) {
        if (word.length() != input.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : input.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word.toCharArray()) {
            if (!charCount.containsKey(ch) || charCount.get(ch) == 0) {
                return false;
            }
            charCount.put(ch, charCount.get(ch) - 1);
        }
        return true;
    }
}