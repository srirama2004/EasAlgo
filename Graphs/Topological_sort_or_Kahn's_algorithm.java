
/*
Explanation:
Given a Directed Acyclic Graph (DAG) with V vertices labeled from 0 to V-1.The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Find any Topological Sorting of that Graph.

In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).

The Output will be True if your topological sort is correct otherwise it will be False.
*/

class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
                  int[] indegree=new int[V];
                  int[] ans=new int[V];
                  int ind=0;
                  for(int i=0;i<V;i++){
                    for(int node:adj.get(i))
                    indegree[node]++;
                  }
                  Queue<Integer>q=new LinkedList<>();
                  for(int i=0;i<V;i++){
                    if(indegree[i]==0)
                    q.add(i);
                  }
                  while(!q.isEmpty()){
                    int node=q.poll();
                    ans[ind++]=node;
                    for(int adjnode:adj.get(node)){
                           indegree[adjnode]--;
                           if(indegree[adjnode]==0)
                           q.add(adjnode);
                    }
                  }
                  return ans;
    }
}
