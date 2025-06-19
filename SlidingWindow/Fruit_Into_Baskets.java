
/*
Explanation:
There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.

The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:
1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
3) Once reaching a tree with fruit that cannot fit into any basket, stop.
Return the maximum number of fruits that can be picked.                          (Hard)
*/

class Solution {
    public int totalFruits(int[] fruits) {
    
        int n=fruits.length;
        int maxLen=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=0,r=0;
        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0)
                map.remove(fruits[l]);
                l++;
            
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
return maxLen;
    }
}
