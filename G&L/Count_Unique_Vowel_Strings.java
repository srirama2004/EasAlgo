
/*
Explanation:
You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:

Identify all unique vowels (a, e, i, o, u) present in the string.
For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string.
Return the total number of such distinct strings.
*/

class Solution {
    public int vowelCount(String s) {
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> vowelCount = new HashMap<>();

        // Count occurrences of each vowel
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }

        int uniqueVowels = vowelCount.size();
        if (uniqueVowels == 0) return 0;

        int combinations = 1;
        for (int count : vowelCount.values()) {
            combinations *= count;
        }

        int permutations = factorial(uniqueVowels);

        return combinations * permutations;
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}

