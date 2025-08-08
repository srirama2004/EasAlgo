
/*
Explanation:
Given a string s, of lowercase english alphabets, find the length of the longest proper prefix which is also a suffix.
Note: Prefix and suffix can be overlapping but they should not be equal to the entire string.
*/


class Solution {
    int getLPSLength(String s) {
        // code here
        int n=s.length();
        int p=0;
        int su=1;
        int count=0;
        int pos=1;
        while(p<n && su<n){
            if(s.charAt(p)==s.charAt(su)){
                p++;
                su++;
                count++;
            }
            else{
                p=0;
                count=0;
                pos++;
                su=pos;
            }
        }
        return count;
    }
} 
