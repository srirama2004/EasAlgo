
/*
Explanation:
Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters. (Hard)
*/

class Solution {
    public int kDistinctChar(String s, int k) {
        int n=s.length();
        int maxLen=0,l=0,r=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<n){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()>k){
                  char d=s.charAt(l);
                map.put(d,map.get(d)-1);
                if(map.get(d)==0)
                map.remove(d);
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        r++;
        }
return maxLen;
    }
}
