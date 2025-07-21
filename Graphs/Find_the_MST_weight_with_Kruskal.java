
/*
Explanation:
Given a weighted, undirected, and connected graph with V vertices numbered from 0 to V-1 and E edges.

The ith edge is represented by [ai,bi,wi], where ai and bi denotes the endpoint of the edge and the wi denotes the weight of the edge.

Find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. 

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
*/

class DisjointSet{
    List<Integer>parent,size;
    public DisjointSet(int n){
         parent=new ArrayList<>(n+1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node,findUPar(parent.get(node)));
        return parent.get(node);
        }
        public void unionBySize(int u,int v){
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u==ulp_v)
            return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                 size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
            else if(size.get(ulp_u)>=size.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
               size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
}


class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<int[]>edges=new ArrayList<>();
        for(int i=0;i<V;i++){
            for(List<Integer>it:adj.get(i)){
                int v=it.get(0);
                int wt=it.get(1);
                int u=i;
                edges.add(new int[]{wt,u,v});
            }
        }
        DisjointSet ds=new DisjointSet(V);
        edges.sort(Comparator.comparingInt(o->o[0]));
        int sum=0;
        for(int[] it:edges){
            int wt=it[0];
            int u=it[1];
            int v=it[2];
            if(ds.findUPar(u)!=ds.findUPar(v)){
                sum+=wt;
                ds.unionBySize(u,v);
            }
        }
        return sum;
    }
}


