
/*
Explanation:
Given a string nums representing a non-negative integer, and an integer k, find the smallest possible integer after removing k digits from num.
*/

class Solution {
    public String removeKdigits(String nums, int k) {
       Stack<Character>st=new Stack<>();
       int n=nums.length(); 
       for(int i=0;i<n;i++){
        char digit=nums.charAt(i);
        while(!st.isEmpty() && k>0 && st.peek()>digit){
        st.pop();
        k--;
        }
        st.push(digit);
       }
       while(!st.isEmpty() && k>0){
        st.pop();
        k--;
       }
       if(st.isEmpty()) return "0";
       StringBuilder res=new StringBuilder();
       while(!st.isEmpty()){
        res.append(st.pop());
       }
       while(res.length()>0 && res.charAt(res.length()-1)=='0'){
        res.deleteCharAt(res.length()-1);
       }
       res.reverse();
       if(res.length()==0)
       return "0";
       return res.toString();
    }
}
