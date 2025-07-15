
/*
Explanation:
There are a total of N tasks, labeled from 0 to N-1. Given an array arr where arr[i] = [a, b] indicates that you must take course b first if you want to take course a. Find if it is possible to finish all tasks.
*/

class Solution {
    private int[] topoSort(int V, 
        ArrayList<Integer>[] adj) {
	    int[] inDegree = new int[V];
		for (int i = 0; i < V; i++) {	    
			for(int it : adj[i]) {
			    inDegree[it]++;
			}
		}
        int[] ans = new int[V];
        int idx = 0;
	    Queue<Integer> q = new LinkedList<>();
	    for(int i = 0; i < V; i++) {
	        if(inDegree[i] == 0) q.add(i);
	    }
	    while(!q.isEmpty()) {
	        int node = q.poll();
	        ans[idx++] = node;
	        for(int it : adj[node]) {
	            inDegree[it]--;
	            if(inDegree[it] == 0) q.add(it);
	        }
	    }
	    return Arrays.copyOfRange(ans, 0, idx);
    }
    public boolean canFinish(int N, int[][] arr) {
        boolean[]vis=new boolean[N];
         ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for(int[]it:arr){
            int u=it[0];
            int v=it[1];
            adj[v].add(u);
        }
         int[] topo = topoSort(N, adj);
         if(topo.length<N)
         return false;
         return true;
    }
}
