package org.example.wordscounter;

import java.util.Arrays;

public class BalancedWordsCounter {

    public int count(String input) {
        if (input == null) {
            throw new RuntimeException("Input is null!");
        }
        if (!wordIsValid(input)) {
            throw new RuntimeException("Input should contain letters only!");
        }
        if (input.isEmpty()) {
            return 0;
        }

        int[] letterCounts = new int[26];
        for (int i = 0; i < input.length(); i++) {
            letterCounts[input.charAt(i) - 'a']++;
        }
        int[] distinctCounts = Arrays.stream(letterCounts)
                .filter(c -> c > 0)
                .distinct()
                .toArray();
        if (distinctCounts.length > 2) {
            return 0;
        }
        if (distinctCounts.length == 1) {
            return (input.length() * (input.length() + 1)) / 2;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                int[] subStringLetterCounts = new int[26];
                for (int k = i; k <= j; k++) {
                    subStringLetterCounts[input.charAt(k) - 'a']++;
                }
                int[] subStringDistinctCounts = Arrays.stream(subStringLetterCounts)
                        .filter(c -> c > 0)
                        .distinct()
                        .toArray();
                if (subStringDistinctCounts.length == 1 && subStringDistinctCounts[0] != distinctCounts[0]) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean wordIsValid(String input) {
        return input.matches("[a-zA-Z-]+") || input.matches("");
    }
}
