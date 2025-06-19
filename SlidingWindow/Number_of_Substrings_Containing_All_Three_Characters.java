
/*
Explanation:
Given a string s , consisting only of characters 'a' , 'b' , 'c'.Find the number of substrings that contain at least one occurrence of all these characters 'a' , 'b' , 'c'. (Hard)
*/

class Solution {    
    public int numberOfSubstrings(String s) {
        //your code goes here
        int[] lastseen={-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            lastseen[s.charAt(i)-'a']=i;
            count+=1+Math.min(Math.min(lastseen[0],lastseen[1]),lastseen[2]);
        }
return count;
    }
}
