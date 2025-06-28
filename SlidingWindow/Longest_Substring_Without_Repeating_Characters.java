
/*
Explanation:
Given a string, S. Find the length of the longest substring without repeating characters.
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
