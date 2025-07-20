
/*
Explanation:
Design a disjoint set (also called union-find) data structure that supports the following operations:

DisjointSet(int n) initializes the disjoint set with n elements.

void unionByRank(int u, int v) merges the sets containing u and v using the rank heuristic.

void unionBySize(int u, int v) merges the sets containing u and v using the size heuristic.

bool find(int u, int v) checks if the elements u and v are in the same set and returns true if they are, otherwise false.
*/

class DisjointSet {
    private int[]rank;
    private int[] size;
    private int[] parent;
    public DisjointSet(int n) {
      rank=new int[n+1];
      size=new int[n+1];
      parent=new int[n+1];
      Arrays.fill(size,1);
      for(int i=0;i<=n;i++){
        parent[i]=i;
      }
    }
public int findUPar(int node){
    if(node==parent[node])
    return node;
    return parent[node]=findUPar(parent[node]);
}

    public boolean find(int u, int v) {
        return (findUPar(u)==findUPar(v));
    }

    public void unionByRank(int u, int v) {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v)
        return;
        if(rank[ulp_u]<rank[ulp_v]){
            parent[ulp_u]=ulp_v;
        }
        else if(rank[ulp_u]>rank[ulp_v]){
            parent[ulp_v]=ulp_u;
        }
        else{
             parent[ulp_v]=ulp_u;
             rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
         int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v)
        return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+= size[ulp_u];
        }
        else if(size[ulp_u]>=size[ulp_v]){
            parent[ulp_v]=ulp_u;
             size[ulp_u]+= size[ulp_v];
        }
       
    }
}

