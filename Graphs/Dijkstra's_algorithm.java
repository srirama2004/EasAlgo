
/*
Explanation:
Given a weighted, undirected graph of V vertices, numbered from 0 to V-1, and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that edge . 

Given a source node S. Find the shortest distance of all the vertex from the source vertex S. Return a list of integers denoting shortest distance between each node and source vertex S. If a vertex is not reachable from source then its distance will be 109.
*/

import java.util.*;
class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );
        int[]dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S]=0;
        pq.add(new int[]{0,S});
        while(!pq.isEmpty()){
            int dis=pq.peek()[0];
            int node=pq.peek()[1];
            pq.poll();
            for(ArrayList<Integer>it:adj.get(node)){
                int adjnode=it.get(0);
                int edgewt=it.get(1);
                if(dis+edgewt<dist[adjnode]){
                    dist[adjnode]=dis+edgewt;
                    pq.add(new int[]{dist[adjnode],adjnode});
                }
            }
        }
       return dist;
    }
}

