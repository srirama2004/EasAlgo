
/*
Explanation:
Given a string, S. Find the length of the longest substring without repeating characters. (Hard)
Hint 1
Use a hash map (or set) to store the characters currently in the window. For each character, If it's not in the hash map, add it to the window and update the maximum length. If it's already in the hash map, move the left pointer forward until the duplicate is removed.
Hint 2
After processing each character, compute the length of the current window as right−left+1. Keep track of the maximum length encountered during the traversal.
*/

class Solution {
    public int longestNonRepeatingSubstring(String s) {
        int n=s.length();
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        int l=0,r=0;
        int maxlen=0;
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                l=Math.max(hash[s.charAt(r)]+1,l);
            }
            int len=r-l+1;
            maxlen=Math.max(len,maxlen);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxlen;
    }
}
