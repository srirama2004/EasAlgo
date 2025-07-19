
/*
Explanation:
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi,weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distance Threshold. Find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance.



If there are multiple such cities, our answer will be the city with the greatest number.
*/

class Solution {

    public int findCity(int n, int m, int edges[][],
                 int distanceThreshold) {
      int[][]adjMat=new int[n][n];
      for(int[]row:adjMat)
      Arrays.fill(row,(int)1e9);
      for(int[]it:edges){
        adjMat[it[0]][it[1]]=it[2];
         adjMat[it[1]][it[0]]=it[2];
      }
      for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjMat[i][j]=Math.min(adjMat[i][j],adjMat[i][k]+adjMat[k][j]);
            }
        }
      }
      int cntcity=(int)1e9;
      int city=-1;
      for(int c=0;c<n;c++){
        int cnt=0;
        for(int i=0;i<n;i++){
            if(i!=c && adjMat[c][i]<=distanceThreshold)
            cnt++;
        }
        if(cntcity>=cnt){
            cntcity=cnt;
            city=c;
        }
      }
        return city;
    }
}


