
/*
Explanation:
Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.
Note: The returned array of majority elements should be sorted.
*/

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        Map<Integer ,Integer> m=new HashMap<>();
        int n=arr.length/3;
         ArrayList<Integer> l=new  ArrayList<>();
        for(int a:arr){
            m.put(a,m.getOrDefault(a,0)+1);
        }
        
        for(int k:m.keySet()){
            
            if(m.get(k)>n){
                l.add(k);
            }
        }
        
          Collections.sort(l);
        
        return l;
    }
}
