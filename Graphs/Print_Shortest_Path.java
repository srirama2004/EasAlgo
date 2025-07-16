
/*
Explanation:
Given a weighted undirected graph having n vertices numbered from 1 to n and m edges describing there are edges, where edges[i]=[ai,bi,wi], representing an edge from vertex ai to bi with weight wi.

Find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1. If there exists a path, then return a list whose first element is the weight of the path and the remaining elements represent the shortest path from vertex 1 to vertex n.
*/

class Solution {
  public List<Integer> shortestPath(int n, int m, int[][] edges) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
      adj.get(edge[1]).add(new int[] {edge[0], edge[2]});
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.add(new int[] {0, 1});
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    int[] parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    dist[1] = 0;
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int node = curr[1];
      int dis = curr[0];
      for (int[] neighbor : adj.get(node)) {
        int adjNode = neighbor[0];
        int edWt = neighbor[1];
        if (dis + edWt < dist[adjNode]) {
          dist[adjNode] = dis + edWt;
          pq.add(new int[] {dist[adjNode], adjNode});
          parent[adjNode] = node;
        }
      }
    }
    if (dist[n] == Integer.MAX_VALUE) {
      return Arrays.asList(-1);
    }
    List<Integer> path = new ArrayList<>();
    int node = n;
    while (parent[node] != node) {
      path.add(node);
      node = parent[node];
    }
    path.add(1);
    Collections.reverse(path);
    path.add(0, dist[n]);
    return path;
  }
}

