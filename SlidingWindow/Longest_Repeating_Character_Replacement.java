
/*
Explanation:
Given an integer k and a string s, any character in the string can be selected and changed to any other uppercase English character. This operation can be performed up to k times. After completing these steps, return the length of the longest substring that contains the same letter. (Hard)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        int maxFreq=0;
        int l=0,r=0;
        int[]hash=new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, hash[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
