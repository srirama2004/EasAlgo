
/*
Explanation:
Given a graph of V vertices numbered from 0 to V-1. Find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n x n. Matrix[i][j] denotes the weight of the edge from i to j. If matrix[i][j]=-1, it means there is no edge from i to j.
*/

class Solution {
    public void shortest_distance(int[][] matrix) {
            int n=matrix.length;
            for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]==-1 || matrix[k][j]==-1)
                    continue;
                    else{
                        if(matrix[i][j]==-1){
                            matrix[i][j]=matrix[i][k]+matrix[k][j];
                        }
                        else
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }
                }
            }
    }
}
}


