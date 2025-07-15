
/*
Explanation:
Given a sorted dictionary of an alien language having N words and K starting alphabets of a standard dictionary. Find the order of characters in the alien language.

There may be multiple valid orders for a particular test case, thus you may return any valid order as a string. The output will be True if the order returned by the function is correct, else False denoting an incorrect order.
*/

class Solution {
    public String findOrder(String [] dict, int N, int K) {
      List<Integer>[] adj=new ArrayList[K];
      for(int i=0;i<K;i++)
      adj[i]=new ArrayList<>();
      for(int i=0;i<N-1;i++){
        String s1=dict[i];
        String s2=dict[i+1];
        int len=Math.min(s1.length(),s2.length());
        for(int i1=0;i1<len;i1++){
            if(s1.charAt(i1)!=s2.charAt(i1)){
                adj[s1.charAt(i1)-'a'].add(s2.charAt(i1)-'a');
                break;
            }
        }
      } 
      List<Integer>topo=topoSort(K,adj);
        StringBuilder str=new StringBuilder();
        for(int i=0;i<K;i++){
            str.append((char)(topo.get(i)+'a'));
            str.append(' ');
        }
        return str.toString();
    }
    private List<Integer> topoSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            
            for (int it : adj[i]) {
                inDegree[it]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        return ans;
}
}
