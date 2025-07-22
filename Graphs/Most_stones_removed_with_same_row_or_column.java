
/*
Explanation:
There are n stones at integer coordinate points on a 2D plane, with at most one stone per coordinate point. Some stones need to be removed.A stone can be removed if it shares the same row or the same column as another stone that has not been removed.

Given an array of stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the maximum possible number of stones that can be removed.
*/

class Solution {
    public int maxRemove(int[][] stones, int n) {
        int maxRow=0;
        int maxCol=0;
        for(int [] stone:stones){
            maxRow=Math.max(stone[0],maxRow);
             maxCol=Math.max(stone[1],maxCol);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        Map<Integer,Integer> sn=new HashMap<>();
        for(int[]stone:stones){
            int noder=stone[0];
            int nodec=stone[1]+maxRow+1;
            ds.unionBySize(noder,nodec);
            sn.put(noder,1);
            sn.put(nodec,1);
        }
        int k=0;
        for(int key:sn.keySet()){
            if(ds.findUPar(key)==key)
            k++;
        }
        return n-k;
    }
};

