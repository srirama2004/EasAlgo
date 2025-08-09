
/*
Explanation:
Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough times produces a string that starts with s.
*/

class Solution {
    int getLongestPrefix(String s) {
        // code here
      int n = s.length();

        // Start from largest proper prefix and go down
        for (int len = n - 1; len >= 1; len--) {
           boolean value = true;

           
            for(int i=len; i < n;i++)
            {
                if(s.charAt(i)!=s.charAt(i%len)){
                    value = false;
                    break;
                }
            }

             if(value)return len;
            }
       
        return -1; // no such prefix
    }

}
