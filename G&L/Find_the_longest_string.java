
/*
Explanation:
Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 
*/

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isWord = true;
    }

    private boolean allPrefixesExist(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if (node == null || !node.isWord) return false;
        }
        return true;
    }

    public String longestString(String[] arr) {
        for (String word : arr) {
            insert(word);
        }

        Arrays.sort(arr); // lexicographical order

        String result = "";
        for (String word : arr) {
            if (allPrefixesExist(word)) {
                if (word.length() > result.length() || 
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}
