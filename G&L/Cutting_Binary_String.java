
/*
Explanation:
You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this string into the minimum number of non-empty substrings such that:

Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
No substring should have leading zeros.
Return the minimum number of such pieces the string can be divided into.
Note: If it is not possible to split the string in this way, return -1.
*/

class Solution {
    
     void f(String str, HashSet<String>set, int psf,int ans[]) {
		if(str.length()==0) {
			ans[0]=Math.min(ans[0], psf);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			String pre=str.substring(0,i+1);
			if(set.contains(pre)) {
				f(str.substring(i+1),set,psf+1,ans);
			}
		}	
		
	} 
    
    public int cuts(String s) {
        HashSet<String> set =new HashSet<>();
		long temp=1;
		set.add("1");
		for(int i=0;i<13;i++) {
			temp=temp*5;
			String str=Long.toBinaryString(temp);
			set.add(str);
		}
	
		int ans[]= {Integer.MAX_VALUE};
		f(s,set,0,ans);
    	return ans[0]==Integer.MAX_VALUE?-1:ans[0]; 
        
    }
}
