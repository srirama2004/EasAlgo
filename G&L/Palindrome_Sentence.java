
/*
Explanation:
Given a single string s, the task is to check if it is a palindrome sentence or not.
A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the same backward as forward after converting all uppercase letters to lowercase and removing all non-alphanumeric characters (including spaces and punctuation).
*/

class Solution {
    public boolean isChar(char ch){
        if(ch>='a' && ch<='z')return true;
        if(ch>='A' && ch<='Z')return true;
        if(ch>='0' && ch<='9')return true;
        return false;
    }
    public boolean isPalinSent(String s) {
        // code here
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(!isChar(s.charAt(i))){
                i++;
            }else if(!isChar(s.charAt(j))){
                j--;
            }else{
                char t1=Character.toLowerCase(s.charAt(i));
                char t2=Character.toLowerCase(s.charAt(j));
                if(t1!=t2){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
